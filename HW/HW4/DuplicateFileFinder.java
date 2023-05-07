import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DuplicateFileFinder {
    private static MessageDigest messageDigest;

    public static void findDuplicateFiles(Map<String, List<String>> filesList, File directory) {
        String path = "";
        for (File dirChild : directory.listFiles()) {
            if (dirChild.isDirectory()) {
                findDuplicateFiles(filesList, dirChild); // Using recursion to read through all subdirectories
            } 
            else {
                try {
                    String hashOutput = getHashInBytes(dirChild);
                    List<String> identicalList = filesList.get(hashOutput); //List to store identical paths
                    if (identicalList == null) {
                        identicalList = new LinkedList<String>();
                    }
                    path = dirChild.getAbsolutePath();
                    identicalList.add(path);

                    // Update hash table
                    filesList.put(hashOutput, identicalList);
                } catch (IOException e) {
                    throw new RuntimeException("cannot read file " + path, e);
                }
            }
        }
    }

    public static String getHashInBytes(File dir) throws IOException{ //Converting to hash
        FileInputStream fileInput = new FileInputStream(dir);
        byte[] fileData = new byte[(int) dir.length()];
        fileInput.read(fileData);
        fileInput.close();
        
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("cannot initialize MD5 hash function", e);
        }

        // Creates hash
        return new BigInteger(1, messageDigest.digest(fileData)).toString(16);
    }

    public static String readableFileSize(long size) { //Returns size in bytes
        if (size <= 0)
            return "";
        final String[] units = new String[] { "B", "kB", "MB", "GB", "TB" };
        int digits = (int) (Math.log10(size) / Math.log10(1024));
        return (Math.round((size / Math.pow(1024, digits))*100))/100.0 + " " + units[digits];
    }

    public static void getFileReport(File dir){ //Output in log and console
        File f = new File("duplicates.log");

        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println("Couldn't create new log file");
            }
        }
        Map<String, List<String>> lists = new HashMap<String, List<String>>();
        findDuplicateFiles(lists, dir);
        FileWriter fstream;
        for (List<String> list : lists.values()) {
            if (list.size() > 1) {
                //System.out.println(list);
                System.out.println("\n");
                for (String file : list) {
                    File temp = new File(file);
                    try {
                        System.out.println(readableFileSize(temp.length()) + "   " + file + "    " + getHashInBytes(temp)); //output to console
                        fstream = new FileWriter(f, true);
                        BufferedWriter out = new BufferedWriter(fstream);
                        out.write(readableFileSize(temp.length()) + "   " + file + "    " + getHashInBytes(temp)); //output to log
                        out.newLine();
                        out.close();
                    } catch (IOException e) {
                        System.out.println("could not write to the file");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter a directory: ");
        Scanner input = new Scanner(System.in);
        String dirName = input.nextLine();
        if (dirName.length() < 1) {
            System.out.println("Please supply a directory path");
            return;
        }
        File dir = new File(dirName);
        if (!dir.isDirectory()) {
            System.out.println("Supplied directory does not exist.");
            return;
        }

        getFileReport(dir);
    }
}