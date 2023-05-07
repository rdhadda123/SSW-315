import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class StudentRecords{

    static class Student{
        public long id;
        public String firstName;
        public String middleName;
        public String lastName;

        public Student(long id, String firstName, String lastName, String middleName){
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = middleName;
        }

        public long getId(){
            return id;
        }

        public String getFirstName(){
            return firstName;
        }

        public String getLastName(){
            return lastName;
        }

        public String getMiddleName(){
            return middleName;
        }

        public String toString(){
            if (middleName != " ")
                return id + " " + firstName + " " + middleName + " " + lastName;
             
            return id + " " + firstName + " " + lastName;
        }
    }

    private static long simulate(List<String> firstNames, List<String> lastNames, List<Student> students, String fileName) throws IOException{
        File names = new File("C:\\ssw315\\HW\\HW6\\names.txt");
        long readTime = readNames(names, firstNames);

        File surnames = new File("C:\\ssw315\\HW\\HW6\\surnames.txt");
        readTime += readNames(surnames, lastNames);

        System.out.println("parsed " + firstNames.size() + " names and " + lastNames.size() + " last names in " + readTime + " sec");

        long generateData = generateStudentData(firstNames, lastNames, students);
        long sortData = sortStudentData(students);
        long sequenceData = sequentialStudentData(students);
        long recordData = generateReport(fileName, students);

        System.out.println("Generation  " + generateData + " sec");
        System.out.println("Sorting    " + sortData + "sec");
        System.out.println("Sequence  " + sequenceData + " sec");
        System.out.println("Recording  " + recordData + " sec");

        return readTime + generateData + sortData + sequenceData + recordData;
    }

    private static long simulate(Set<String> firstNames, Set<String> lastNames, Map<Long, Student> idMap, String fileName) throws IOException{
        File names = new File("C:\\ssw315\\HW\\HW6\\names.txt");
        long readTime = readNames(names, firstNames);

        File surnames = new File("C:\\ssw315\\HW\\HW6\\surnames.txt");
        readTime += readNames(surnames, lastNames);

        System.out.println("parsed " + firstNames.size() + " names and " + lastNames.size() + " last names in " + readTime + " sec");

        long generateData = generateStudentData(firstNames, lastNames, idMap);
        long sequenceData = sequentialStudentData(idMap);
        long recordData = generateReport(fileName, idMap);

        System.out.println("Generation  " + generateData + " sec");
        System.out.println("Sequence  " + sequenceData + " sec");
        System.out.println("Recording  " + recordData + " sec");

        return readTime + generateData  + sequenceData;
    }

    private static long readNames(File file, Collection<String> names) throws FileNotFoundException{
        long startTime = System.currentTimeMillis();
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()){
            String line = reader.nextLine();
            names.add(line);
        }
        reader.close();
        long endTime = System.currentTimeMillis();

        return (endTime - startTime);
    }

    private static long generateStudentData(List<String> firstNames, List<String> lastNames, List<Student> students){
        long startTime = System.currentTimeMillis();
        long id = 1;
        Random rand = new Random();
        for (int i = 0; i < 100000; i++) {
            String firstName = firstNames.get(rand.nextInt(firstNames.size()));
            String lastName = lastNames.get(rand.nextInt(lastNames.size()));
    
            String middleInitial = " ";
            if (rand.nextBoolean()) {
                middleInitial = String.valueOf((char)(rand.nextInt(26) + 'A'));
            }
    
            Student student = new Student(id, firstName, lastName, middleInitial);            
            students.add(student);
        
            id++;
        }

        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }
        
    private static long generateStudentData(Set<String> firstNames, Set<String> lastNames, Map<Long, Student> idMap) {
        long startTime = System.currentTimeMillis();
      
        Random rand = new Random();
        for (long id = 1; id <= 100000; id++) {
            Iterator<String> firstNameIterator = firstNames.iterator();
            Iterator<String> lastNameIterator = lastNames.iterator();

            long firstName = rand.nextInt(firstNames.size());
            long lastName = rand.nextInt(firstNames.size());

            String randomFirst = " ";
            String randomLast = " ";

            long first = 0;
            long last = 0;

            while (firstNameIterator.hasNext()){
                randomFirst = firstNameIterator.next();
                if (first == firstName)
                    break;
                first++;
            }

            while (lastNameIterator.hasNext()){
                randomLast = lastNameIterator.next();
                if (last == lastName)
                    break;
                last++;
            }

            String middleName = " ";
            if (rand.nextBoolean()) {
                middleName = String.valueOf((char)('A' + rand.nextInt(26)));
          }
      
          Student student = new Student(id, randomFirst, middleName, randomLast);
      
          idMap.put(id, student);
        }
      
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
      }

        private static long sortStudentData(List<Student> students) {
            long startTime = System.currentTimeMillis();

            Comparator<Student> compare = Comparator
              .comparing(Student::getLastName)
              .thenComparing(Student::getFirstName)
              .thenComparing(Student::getMiddleName)
              .thenComparing(Student::getId);
          
            Collections.sort(students, compare);
          
            long endTime = System.currentTimeMillis();
            return (endTime - startTime);
          }
          

        private static long sequentialStudentData(List<Student> students) {
            long startTime = System.currentTimeMillis();
            long id = 1; 
            for (Student student : students) {
                if (student.getId() == id)
                    id++;
            }

            long endTime = System.currentTimeMillis();
            return (endTime - startTime); // return the student id
        }
        

        private static long sequentialStudentData(Map<Long, Student> studentMap) {
            long startTime = System.currentTimeMillis();
            long id = 1;
            
            while (studentMap.containsKey(id))
                id++;

            long endTime = System.currentTimeMillis();
            return (endTime - startTime);
        }
          

        private static long generateReport(String reportFile, Collection<Student> students) throws IOException {
            long startTime = System.currentTimeMillis();

            Iterator<Student> out = students.iterator();
            FileWriter file = new FileWriter(reportFile);

            while (out.hasNext())
                file.write(out.next().toString() + "\n");

            file.close();

            long endTime = System.currentTimeMillis();
            return endTime - startTime;
        }

        private static long generateReport(String reportFile, Map<Long, Student> idMap) throws IOException {
            long startTime = System.currentTimeMillis();
        
            Iterator<Student> out = idMap.values().iterator();
            FileWriter file = new FileWriter(reportFile);
        
            while (out.hasNext()) {
                file.write(out.next().toString() + "\n");
            }
            file.close();
        
            long endTime = System.currentTimeMillis();
            return endTime - startTime;
        }

        public static void main (String[] args) throws IOException{
            String fileName1 = "C:\\ssw315\\HW\\HW6\\randomRecords.ArrayList.txt";
            String fileName2 = "C:\\ssw315\\HW\\HW6\\randomRecords.LinkedList.txt";
            String fileName3 = "C:\\ssw315\\HW\\HW6\\randomRecords.HashMap.txt";
            String fileName4 = "C:\\ssw315\\HW\\HW6\\randomRecords.TreeMap.txt";

            ArrayList<String> firstNames = new ArrayList<>();
            ArrayList<String> lastNames = new ArrayList<>(); 
            ArrayList<Student> students = new ArrayList<>();

            System.out.println("ArrayList Total   " + StudentRecords.simulate(firstNames, lastNames, students, fileName1) + " sec");
            System.out.println();

            LinkedList<String> firstNames2 = new LinkedList<>();
            LinkedList<String> lastNames2 = new LinkedList<>(); 
            LinkedList<Student> students2 = new LinkedList<>();

            System.out.println("LinkedList Total   " + StudentRecords.simulate(firstNames2, lastNames2, students2, fileName2) + " sec");
            System.out.println();

            HashSet<String> firstNames3 = new HashSet<String>();
            HashSet<String> lastNames3 = new HashSet<String>();
            HashMap<Long, Student> students3 = new HashMap<Long, Student>();
            System.out.println("HashMap Total   " + StudentRecords.simulate(firstNames3, lastNames3, students3, fileName3) + " sec");
            System.out.println();

            TreeSet<String> firstNames4 = new TreeSet<String>();
            TreeSet<String> lastNames4 = new TreeSet<String>();
            TreeMap<Long, Student> students4 = new TreeMap<Long, Student>();
            System.out.println("TreeMap Total   " + StudentRecords.simulate(firstNames4, lastNames4, students4, fileName4) + " sec");
            System.out.println();

        }
}