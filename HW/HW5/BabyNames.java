import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;


public class BabyNames{
    public static String gender;
    public static String name;
    public static Integer year;
    public static Integer count;
    public static BufferedReader reader;
    public static FileReader fstream;


    public static HashMap<Integer, HashMap<String, Integer>> boyData = new HashMap<Integer, HashMap<String, Integer>>();
    public static HashMap<Integer, HashMap<String, Integer>> girlData = new HashMap<Integer, HashMap<String, Integer>>();

    public static HashMap<Integer, HashMap<String, Integer>> sortedboyData = new HashMap<Integer, HashMap<String, Integer>>();
    public static HashMap<Integer, HashMap<String, Integer>> sortedgirlData = new HashMap<Integer, HashMap<String, Integer>>();

    public static HashMap<Integer, HashMap<String, Integer>> rankedBoysMap = new HashMap<Integer, HashMap<String, Integer>>();
    public static HashMap<Integer, HashMap<String, Integer>> rankedGirlsMap = new HashMap<Integer, HashMap<String, Integer>>();
    

    public static void main(String[] args) throws IOException {
        File dir = new File("C://ssw315//namesbystate");
        insertData(dir);
        copySortedMap();
        getFileReport("2010s");
    }
  
    public BabyNames(){
        gender = "";
        name = "";
        year = 0;
        count = 0;
    }

    public static String getGender(){
        return gender;
    }

    public static String getName(){
        return name;
    }

    public static Integer getYear(){
        return year;
    }

    public static Integer getCount(){
        return count;
    }

    
    public static void insertData(File directory) throws IOException{
        HashMap<String, Integer> keyValuesBoys = new HashMap<String, Integer>();
        HashMap<String, Integer> keyValuesGirls = new HashMap<String, Integer>();
        for (File file: directory.listFiles()){
            fstream = new FileReader(file);
                reader = new BufferedReader(fstream);
                String line = reader.readLine();
                while (line != null){ 
                    line = line.substring(line.indexOf(",") + 1);
                    String[] values = line.split(",");
                    gender = values[0];
                    year = Integer.valueOf(values[1]);
                    name = values[2];
                    count = Integer.valueOf(values[3]);

                    if (getGender().equals("F")){
                        keyValuesGirls.put(getName(), getCount());
                        girlData.put(getYear(), keyValuesGirls);
                    }
                    else if (getGender().equals("M")){
                        keyValuesBoys.put(getName(), getCount());
                        boyData.put(getYear(), keyValuesBoys);
                    }
                    line = reader.readLine();
                }
        }
        reader.close();
    }

    public static HashMap<String, Integer> sortValues(HashMap<String, Integer> data){
        //Creating list from hashmap
        List<Map.Entry<String, Integer> > list =
               new LinkedList<Map.Entry<String, Integer> >(data.entrySet());
 
        //Sorting list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
         
        //Puts sorted list into hashmap and returns hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static void copySortedMap(){
        HashMap<String, Integer> sortedkeyValuesBoys = new HashMap<String, Integer>();
        HashMap<String, Integer> sortedkeyValuesGirls = new HashMap<String, Integer>();

        for (HashMap.Entry<Integer, HashMap<String, Integer>> keys : boyData.entrySet()){
            sortedkeyValuesBoys = sortValues(keys.getValue());
            sortedboyData.put(keys.getKey(), sortedkeyValuesBoys);
        }

        for (HashMap.Entry<Integer, HashMap<String, Integer>> keys : girlData.entrySet()){
            sortedkeyValuesGirls = sortValues(keys.getValue());
            sortedgirlData.put(keys.getKey(), sortedkeyValuesGirls);
        }

    }

    public static void setRankings(){
        HashMap<String, Integer> ranksBoyValues = new HashMap<String, Integer>();
        HashMap<String, Integer> ranksGirlValues = new HashMap<String, Integer>();

        for (HashMap.Entry<Integer, HashMap<String, Integer>> keys : sortedboyData.entrySet()){
            HashMap <String, Integer> boyValues = keys.getValue();
            for (HashMap.Entry<String, Integer> address: boyValues.entrySet()){
                for (int x = 1; x <= 100; x++){
                    ranksBoyValues.put(address.getKey(), address.getValue());
                }
            }
            rankedBoysMap.put(keys.getKey(), ranksBoyValues);
        }

        for (HashMap.Entry<Integer, HashMap<String, Integer>> keys : sortedgirlData.entrySet()){
            HashMap <String, Integer> girlValues = keys.getValue();
            for (HashMap.Entry<String, Integer> address: girlValues.entrySet()){
                for (int x = 1; x <= 100; x++){
                    ranksGirlValues.put(address.getKey(), address.getValue());
                }
            }
            rankedGirlsMap.put(keys.getKey(), ranksBoyValues);
        }
    }

    public static void getFileReport(String yearRank) throws IOException{
        File b = new File(yearRank + "_RankedBabyBoyNames.csv");
        File g = new File(yearRank + "_RankedBabyGirlNames.csv");

        if(!b.exists() && !g.exists()){
            try {
                b.createNewFile();
                g.createNewFile();
            } catch (IOException e) {
                System.out.println("Couldn't create new csv file");
            }
        }
        FileWriter writerBoy = new FileWriter(b);
        FileWriter writerGirl = new FileWriter(g);
        BufferedWriter bufferedWriterBoy = new BufferedWriter(writerBoy);
        BufferedWriter bufferedWriterGirl = new BufferedWriter(writerGirl);

        bufferedWriterBoy.write("Name" + " , ");
        bufferedWriterGirl.write("Name" + " , ");

        setRankings();
        for (HashMap.Entry<Integer, HashMap<String, Integer>> keys : sortedboyData.entrySet()){
            bufferedWriterBoy.write(keys.getKey() + " , ");
            bufferedWriterBoy.newLine();
            HashMap<String, Integer> rankedBoys = keys.getValue();
            for (HashMap.Entry<String, Integer> address : rankedBoys.entrySet()){
                bufferedWriterBoy.write(/*address.getRank() + " , " + */address.getKey() + " , " + address.getValue());
                bufferedWriterBoy.newLine();
            }
        }
        bufferedWriterBoy.close();

        for (HashMap.Entry<Integer, HashMap<String, Integer>> keys : sortedgirlData.entrySet()){
            bufferedWriterGirl.write(keys.getKey() + " , ");
            bufferedWriterGirl.newLine();
            HashMap<String, Integer> rankedGirls = keys.getValue();
            for (HashMap.Entry<String, Integer> address : rankedGirls.entrySet()){
                bufferedWriterGirl.write(/*address.getRank() + " , " + */address.getKey() + " , " + address.getValue());
                bufferedWriterGirl.newLine();
            }
        }
        bufferedWriterGirl.close();
    }
}