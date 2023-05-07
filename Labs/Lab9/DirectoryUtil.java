import java.io.*;
import java.text.DecimalFormat;
import java.util.Stack;

public class DirectoryUtil{
    static Stack<String> stackFile;
    static Stack<String> stackOrder;

    static class FileInfo {
        public long count;
        public long size;
        public String sizeFormat;
    }
//Testing
    public static String readableFileSize(long size) {
        if (size <= 0)
            return "";
        final String[] units = new String[] { "B", "kB", "MB", "GB", "TB" };
        int digits = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.##").format(size / Math.pow(1024, digits)) + " " + units[digits];
    }

    public static void getFileReport(String folderName){
        File f = new File(folderName + ".log");
        getDirInfo(new File(folderName));

        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println("Couldnt create new log file");
            }

        }

        FileWriter fstream;
        try {
            fstream = new FileWriter(f, true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(stackFile.pop());
            out.newLine();
            out.close();
        } catch (IOException e) {
            System.out.println("could not write to the file"); 
        }
    }

    public static FileInfo getDirInfo(File file) {
        FileInfo fileInfo = new FileInfo();
        stackFile = new Stack<>();
        stackOrder = new Stack<>();

        long numFiles = 0; // Store the total size of all files
        long sizeFiles = 0;

        if (file.isDirectory()) {
            File[] files = file.listFiles(); // All files and subdirectories
            long folderFileCount = 0;
            long folderFileSize = 0;

            for (int i = 0; i < files.length; i++) {
                FileInfo currentFolder = getDirInfo(files[i]); // Recursive call
                folderFileSize += currentFolder.size;
                folderFileCount += currentFolder.count;
            }
            numFiles += folderFileCount;
            sizeFiles += folderFileSize;
            stackFile.push(numFiles + "     " + readableFileSize(sizeFiles) + "   " + file.getPath());
        } else { // Base case
            numFiles++;
            sizeFiles += file.length();
        }

        while (stackFile.size() > 0) {
            stackOrder.push(stackFile.pop());
        }
        while (stackOrder.size() > 0) {
            String temp = stackOrder.pop();
            System.out.println(temp);
            stackFile.push(temp);
        }

        fileInfo.count = numFiles;
        fileInfo.size = sizeFiles;
        fileInfo.sizeFormat = readableFileSize(sizeFiles);
        return fileInfo;
    }

    public static void main(String[] args) {
        getFileReport("C:/ssw315");
    }
}