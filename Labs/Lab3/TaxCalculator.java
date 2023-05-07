import java.util.Scanner;

public class TaxCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //input variables that will be passed to calculate tax
        
        int status, income;
        
        //Array to show different filing status
        String[] filers = new String[] {"Single Filers", "Married, filing jointly", "Married, filing separately", "Head of household"};
        
        //catching error in user inputting status number and prompting user to enter again if wrong
        System.out.println("Select filing status (1,2,3,4): ");
        for (int x = 0; x < filers.length; x++){ //loop to traverse through each filing status and display properly for user
            System.out.println((x) + ": " + filers[x]);
        }
        do{ 
            status = getInt(input.nextLine());
            status = getFilingStatus(status);

        } while (status < 0 || status > 3);

        //catching error in user inputting tax income and prompting user to enter again if wrong
        System.out.print("Enter the income for 2022 : $");
        do{
            income = getInt(input.nextLine());  
	        income = getTaxableIncome(income);
	    } while (income < 0);
        
        //Calls calculating tax function
        double incomeTax = calcTax(status, income);
        System.out.printf("Your tax for year 2022 is $%.2f for an income of $%d using status %d.", incomeTax, income, status);        
    }

    public static int getInt(String input){
        int digit;
        try{
            digit = Integer.parseInt(input);
        } catch (NumberFormatException e){
            digit = -1;
        }
        return digit;
    }
    public static int getFilingStatus(int status){ //function to error trap for input of wrong number for filing status
        int filing = status;
        if (filing < 0 || filing > 3){
            System.out.println("Please enter a valid number from 0-3.");
            return -1;
        }
        return filing;
    }

    public static int getTaxableIncome(int income){ //function to error trap for input of wrong number for tax income
        int money = income;
        if (money < 0){
            System.out.println("Please enter a valid taxable income greater than $0.");
            return -1;
        }
        return money;
    }

    public static double calcTax(int status, int income){
        int fileStatus = status;
        int taxIncome = income;
        double[] taxRate = new double[] {0.1, 0.12, 0.22, 0.24, 0.32, 0.35, 0.37}; //array for all tax percentages
        double[] taxBracket;
        double totalTax = 0.0; //accumulator for total tax
        switch (fileStatus){ //tests for each filing status
            case 0: 
                taxBracket = new double[]{10275, 41775, 89075, 170050, 215950,539000}; //each case has own tax bracket array
              //For all cases, the logic is the same. When the tax income is at the highest level, we start with the first bracket and deduct the percentage. 
              //Then we move on to the next bracket and subtract the difference of the old bracket. The elements in the array represent the different tax brackets being computed. 
              //This process goes on for all types of income and filing statuses.
                if (taxIncome > taxBracket[5]){
                    for (int x = 0; x <= 5; x++){
                        if (x == 0)
                            totalTax += taxRate[x] * taxBracket[x];
                        else
                            totalTax += taxRate[x] * (taxBracket[x] - taxBracket[x-1]);
                        
                    }
                    taxIncome -= taxBracket[5];
                    totalTax += taxIncome * taxRate[6];
                    return totalTax;
                }
                else if (taxIncome > taxBracket[4]){
                    for (int x = 0; x <= 4; x++){
                        if (x == 0)
                            totalTax += taxRate[x] * taxBracket[x];
                        else
                            totalTax += taxRate[x] * (taxBracket[x] - taxBracket[x-1]);
                    }
                    taxIncome -= taxBracket[4];
                    totalTax += taxIncome * taxRate[5];
                    return totalTax;
                }
                else if (taxIncome > taxBracket[3]){
                    for (int x = 0; x <= 3; x++){
                        if (x == 0)
                            totalTax += taxRate[x] * taxBracket[x];
                        else
                            totalTax += taxRate[x] * (taxBracket[x] - taxBracket[x-1]);
                    }
                    taxIncome -= taxBracket[3];
                    totalTax += taxIncome * taxRate[4];
                    return totalTax;
                }
                else if (taxIncome > taxBracket[2]){
                    for (int x = 0; x <= 2; x++){
                        if (x == 0)
                            totalTax += taxRate[x] * taxBracket[x];
                        else
                            totalTax += taxRate[x] * (taxBracket[x] - taxBracket[x-1]);
                    }
                    taxIncome -= taxBracket[2];
                    totalTax += taxIncome * taxRate[3];
                    return totalTax;
                }
                else if (taxIncome > taxBracket[1]){
                    for (int x = 0; x <= 1; x++){
                        if (x == 0)
                            totalTax += taxRate[x] * taxBracket[x];
                        else
                            totalTax += taxRate[x] * (taxBracket[x] - taxBracket[x-1]);
                    }
                    taxIncome -= taxBracket[1];
                    totalTax += taxIncome * taxRate[2];
                    return totalTax;
                }
                else if (taxIncome > taxBracket[0]){
                    totalTax = taxRate[0] * taxBracket[0];
                    taxIncome -= taxBracket[0];
                    totalTax += taxIncome * taxRate[1];
                    return totalTax;
                }
                else{
                    totalTax = taxRate[0] * taxIncome;
                    return totalTax;
                }
            case 1:
                taxBracket = new double[]{20550, 83550, 178150, 340100, 431900,647850};
                if (taxIncome > taxBracket[5]){
                    for (int x = 0; x <= 5; x++){
                        if (x == 0)
                            totalTax += taxRate[x] * taxBracket[x];
                        else
                            totalTax += taxRate[x] * (taxBracket[x] - taxBracket[x-1]);
                        
                    }
                    taxIncome -= taxBracket[5];
                    totalTax += taxIncome * taxRate[6];
                    return totalTax;
                }
                else if (taxIncome > taxBracket[4]){
                    for (int x = 0; x <= 4; x++){
                        if (x == 0)
                            totalTax += taxRate[x] * taxBracket[x];
                        else
                            totalTax += taxRate[x] * (taxBracket[x] - taxBracket[x-1]);
                    }
                    taxIncome -= taxBracket[4];
                    totalTax += taxIncome * taxRate[5];
                    return totalTax;
                }
                else if (taxIncome > taxBracket[3]){
                    for (int x = 0; x <= 3; x++){
                        if (x == 0)
                            totalTax += taxRate[x] * taxBracket[x];
                        else
                            totalTax += taxRate[x] * (taxBracket[x] - taxBracket[x-1]);
                    }
                    taxIncome -= taxBracket[3];
                    totalTax += taxIncome * taxRate[4];
                    return totalTax;
                }
                else if (taxIncome > taxBracket[2]){
                    for (int x = 0; x <= 2; x++){
                        if (x == 0)
                            totalTax += taxRate[x] * taxBracket[x];
                        else
                            totalTax += taxRate[x] * (taxBracket[x] - taxBracket[x-1]);
                    }
                    taxIncome -= taxBracket[2];
                    totalTax += taxIncome * taxRate[3];
                    return totalTax;
                }
                else if (taxIncome > taxBracket[1]){
                    for (int x = 0; x <= 1; x++){
                        if (x == 0)
                            totalTax += taxRate[x] * taxBracket[x];
                        else
                            totalTax += taxRate[x] * (taxBracket[x] - taxBracket[x-1]);
                    }
                    taxIncome -= taxBracket[1];
                    totalTax += taxIncome * taxRate[2];
                    return totalTax;
                }
                else if (taxIncome > taxBracket[0]){
                    totalTax = taxRate[0] * taxBracket[0];
                    taxIncome -= taxBracket[0];
                    totalTax += taxIncome * taxRate[1];
                    return totalTax;
                }
                else{
                    totalTax = taxRate[0] * taxIncome;
                    return totalTax;
                }
            case 2:
                taxBracket = new double[]{10275, 41775, 89075, 170050, 215950,323925};
                if (taxIncome > taxBracket[5]){
                    for (int x = 0; x <= 5; x++){
                        if (x == 0)
                            totalTax += taxRate[x] * taxBracket[x];
                        else
                            totalTax += taxRate[x] * (taxBracket[x] - taxBracket[x-1]);
                        
                    }
                    taxIncome -= taxBracket[5];
                    totalTax += taxIncome * taxRate[6];
                    return totalTax;
                }
                else if (taxIncome > taxBracket[4]){
                    for (int x = 0; x <= 4; x++){
                        if (x == 0)
                            totalTax += taxRate[x] * taxBracket[x];
                        else
                            totalTax += taxRate[x] * (taxBracket[x] - taxBracket[x-1]);
                    }
                    taxIncome -= taxBracket[4];
                    totalTax += taxIncome * taxRate[5];
                    return totalTax;
                }
                else if (taxIncome > taxBracket[3]){
                    for (int x = 0; x <= 3; x++){
                        if (x == 0)
                            totalTax += taxRate[x] * taxBracket[x];
                        else
                            totalTax += taxRate[x] * (taxBracket[x] - taxBracket[x-1]);
                    }
                    taxIncome -= taxBracket[3];
                    totalTax += taxIncome * taxRate[4];
                    return totalTax;
                }
                else if (taxIncome > taxBracket[2]){
                    for (int x = 0; x <= 2; x++){
                        if (x == 0)
                            totalTax += taxRate[x] * taxBracket[x];
                        else
                            totalTax += taxRate[x] * (taxBracket[x] - taxBracket[x-1]);
                    }
                    taxIncome -= taxBracket[2];
                    totalTax += taxIncome * taxRate[3];
                    return totalTax;
                }
                else if (taxIncome > taxBracket[1]){
                    for (int x = 0; x <= 1; x++){
                        if (x == 0)
                            totalTax += taxRate[x] * taxBracket[x];
                        else
                            totalTax += taxRate[x] * (taxBracket[x] - taxBracket[x-1]);
                    }
                    taxIncome -= taxBracket[1];
                    totalTax += taxIncome * taxRate[2];
                    return totalTax;
                }
                else if (taxIncome > taxBracket[0]){
                    totalTax = taxRate[0] * taxBracket[0];
                    taxIncome -= taxBracket[0];
                    totalTax += taxIncome * taxRate[1];
                    return totalTax;
                }
                else{
                    totalTax = taxRate[0] * taxIncome;
                    return totalTax;
                }

            case 3:
                taxBracket = new double[]{14650, 55900, 89050, 170050, 215950, 539000};
                if (taxIncome > taxBracket[5]){
                    for (int x = 0; x <= 5; x++){
                        if (x == 0)
                            totalTax += taxRate[x] * taxBracket[x];
                        else
                            totalTax += taxRate[x] * (taxBracket[x] - taxBracket[x-1]);
                        
                    }
                    taxIncome -= taxBracket[5];
                    totalTax += taxIncome * taxRate[6];
                    return totalTax;
                }
                else if (taxIncome > taxBracket[4]){
                    for (int x = 0; x <= 4; x++){
                        if (x == 0)
                            totalTax += taxRate[x] * taxBracket[x];
                        else
                            totalTax += taxRate[x] * (taxBracket[x] - taxBracket[x-1]);
                    }
                    taxIncome -= taxBracket[4];
                    totalTax += taxIncome * taxRate[5];
                    return totalTax;
                }
                else if (taxIncome > taxBracket[3]){
                    for (int x = 0; x <= 3; x++){
                        if (x == 0)
                            totalTax += taxRate[x] * taxBracket[x];
                        else
                            totalTax += taxRate[x] * (taxBracket[x] - taxBracket[x-1]);
                    }
                    taxIncome -= taxBracket[3];
                    totalTax += taxIncome * taxRate[4];
                    return totalTax;
                }
                else if (taxIncome > taxBracket[2]){
                    for (int x = 0; x <= 2; x++){
                        if (x == 0)
                            totalTax += taxRate[x] * taxBracket[x];
                        else
                            totalTax += taxRate[x] * (taxBracket[x] - taxBracket[x-1]);
                    }
                    taxIncome -= taxBracket[2];
                    totalTax += taxIncome * taxRate[3];
                    return totalTax;
                }
                else if (taxIncome > taxBracket[1]){
                    for (int x = 0; x <= 1; x++){
                        if (x == 0)
                            totalTax += taxRate[x] * taxBracket[x];
                        else
                            totalTax += taxRate[x] * (taxBracket[x] - taxBracket[x-1]);
                    }
                    taxIncome -= taxBracket[1];
                    totalTax += taxIncome * taxRate[2];
                    return totalTax;
                }
                else if (taxIncome > taxBracket[0]){
                    totalTax = taxRate[0] * taxBracket[0];
                    taxIncome -= taxBracket[0];
                    totalTax += taxIncome * taxRate[1];
                    return totalTax;
                }
                else{
                    totalTax = taxRate[0] * taxIncome;
                    return totalTax;
                }
        }
        return -1;
    }
}