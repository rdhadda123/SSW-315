import java.util.Scanner;

public class MaxCounter{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String num = "";
        
        System.out.println("Enter numbers in a string: ");
        num = input.nextLine();        
    
        int numbers[] = parseValue(num);

        int maxCounter[] = getMaxCount(numbers);
        System.out.println("The largest number is " + maxCounter[0]);
        System.out.println("The occurrence count of the largest number is " + maxCounter[1]);
    }
    public static int[] parseValue(String num){
        String nums[] = num.split("\\s+");
        int numbers[] = new int[nums.length];

        for (int x = 0; x < nums.length; x++)
            try{
                numbers[x] = Integer.parseInt(nums[x]);
            }catch(NumberFormatException e){
                numbers[x] = Integer.MIN_VALUE;
            }

        return numbers;
    }

    public static int[] getMaxCount(int numbers[]){
        int maxCount[] = new int[2];
        int max = numbers[0];
        int count = 0;
        for (int y = 0; y < numbers.length; y++){
            if (numbers[y] > max){
                max = numbers[y];
                count = 1;
            }
            else if (numbers[y] == max)
                count++;
        }

        maxCount[0] = max;
        maxCount[1] = count;

        return maxCount;
    }
}