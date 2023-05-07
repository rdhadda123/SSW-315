import java.io.*;
import java.util.*;

public class CodeValidator{
    static Stack<Character> group = new Stack<>();

    public static boolean readLines(File file) throws FileNotFoundException{
        boolean grouped = true;
        int count = 0;
        try{
            Scanner input = new Scanner(file);
            
            while (input.hasNext()){
                String line = input.nextLine();
                count++;
                for (int i = 0; i < line.length(); i++){
                    char ch = line.charAt(i);
                    if (ch == '(' || ch == '{' || ch == '[')
                        group.push(ch);
                    else if (ch == ')' || ch == '}' || ch == ']')
                        grouped = checkStacks(ch, count);
                    
                    //Checks grouping for "" or ''
                    else if (ch == '\"' || ch == '\''){
                        if (group.empty())
                            group.push(ch);
                        else if (group.peek() != '\"' && group.peek() != '\''){
                            if (group.search(ch) == -1)
                                group.push(ch);
                            else{
                                System.out.print("The error occurs at line: " + count);
                                grouped = false;
                            }
                        }
                        else{
                           group.pop(); 
                           grouped = true;
                        }
                    }
                    
                    //Ignores words after comments
                    else if (ch == '/' && line.charAt(i+1) == '/')
                        break;
                }
            }

            if (!group.empty()){
                System.out.print("The code has incorrect grouping at line: " + count);
                grouped = false;
            }
            else if (grouped){
                System.out.print("The code has correct grouping");
            }
        }catch(FileNotFoundException e){
            System.out.print("File not read properly.");
        }

        return grouped;    
    }

    public static boolean checkStacks(char ch, int count){
        
        if ((!group.empty()) &&
            ((group.peek() == '(' && ch == ')') ||
            (group.peek() == '{' && ch == '}') ||
            (group.peek() == '[' && ch == ']') )){
                group.pop();
                return true;
            }
        else if (((group.empty()) || 
                (group.peek() != '(' && ch == ')') ||
                (group.peek() != '{' && ch == '}') ||
                (group.peek() != '[' && ch == ']'))){
                    System.out.println("The code does not have correct grouping at line: " + count);
                    return false;
                }
        
        return true;
    }
    public static void main(String[] args) throws FileNotFoundException{
        File file = new File(args[0]);

        if (!file.exists()){
            System.out.println("The file does not exist");
            System.exit(0);
        }

        readLines(file);
    }
}