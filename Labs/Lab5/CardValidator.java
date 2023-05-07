import java.util.Scanner;

public class CardValidator{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a credit card number of 13-16 digits." + "\n" + "Start with 4 for Visa cards." + "\n" + "Start with 5 for Master cards." + "\n" + "Start with 37 for American Express cards." + "\n" + "Start with 6 for Discover cards.");
        long number = input.nextLong();
    
        boolean valid = isValid(number);
        System.out.println("Card is valid: " + valid);
    }

    public static long[] getDigitsRightLeft(long number){
        long arrayNum = number;
        long[] digitsEnter = new long[(String.valueOf(number)).length()];
        int count = 0;
        while (arrayNum > 0){
            digitsEnter[count] = arrayNum % 10;
            arrayNum = arrayNum / 10;
            count++;
        }

        return digitsEnter;
    }

    public static int secondDigitSum(long number){
        long[] digitCounter = getDigitsRightLeft(number);
        int digitMultiply = 0;
        int secondDigitsTotal = 0;        

        for (int x = 1; x < digitCounter.length; x += 2){
            digitMultiply = (int)(digitCounter[x] * 2);
            if (digitMultiply < 10)
                secondDigitsTotal += digitMultiply;
            else{
                digitMultiply = (digitMultiply % 10) + (digitMultiply / 10);
                secondDigitsTotal += digitMultiply;
            } 
        }

        System.out.println("The step 2 total is: " + secondDigitsTotal);
        return secondDigitsTotal;
    }

    public static int oddDigitSum(long number){
        long[] digitCounter = getDigitsRightLeft(number);
        int stepThreeTotal = 0;

        for (int y = 0; y < digitCounter.length; y += 2){
            stepThreeTotal += digitCounter[y];
        }

        System.out.println("The step 3 total is: " + stepThreeTotal);
        return stepThreeTotal;
    }
    
    public static boolean isValid(long number){
        if ((getDigitsRightLeft(number).length >= 13 && getDigitsRightLeft(number).length <=16) 
                && (getDigitsRightLeft(number)[getDigitsRightLeft(number).length - 1] == 4 
                || getDigitsRightLeft(number)[getDigitsRightLeft(number).length - 1] == 5 
                || getDigitsRightLeft(number)[getDigitsRightLeft(number).length - 1] == 6 
                || (getDigitsRightLeft(number)[getDigitsRightLeft(number).length - 1] == 3 
                && getDigitsRightLeft(number)[getDigitsRightLeft(number).length - 2] == 7))){
            int finalTotal = secondDigitSum(number) + oddDigitSum(number);
            System.out.println("The final total is: " + finalTotal);
            if (finalTotal % 10 == 0)
                return true;

            }
            return false;
    }
}