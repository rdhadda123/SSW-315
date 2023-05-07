public class RomanNumber{
    public static final int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000, 4000, 5000, 9000, 10000, 40000, 50000, 90000, 100000};
    public static final String[] letters = {"Ⅰ", "Ⅳ", "Ⅴ", "Ⅸ", "Ⅹ", "ⅩⅬ", "Ⅼ", "ⅩⅭ", "Ⅽ", "ⅭⅮ", "Ⅾ", "ⅭⅯ", "Ⅿ", "Ⅿↁ", "ↁ", "Ⅿↂ", "ↂ", "ↂↇ", "ↇ", "ↂↈ", "ↈ"};

    private int value;
    private String number;

    public RomanNumber(int value){
        this.value = value;
        number = parseNumber(value);
    }

    public RomanNumber(String number){
        this.number = number;
        value = parseValue(number);
    }

    public int getValue(){
        return value;
    }

    public String getNumber(){
        return number;
    }

    public static int parseValue(String number){
        int val = 0;
        for (int x = letters.length - 1; x >= 0; x--){
            while (number.startsWith(letters[x])){
                val += values[x];
                number = number.substring(letters[x].length());
            }
        }
        return val;
    }

    public static String parseNumber(int value){
        if (value < 1 || value > 300000)
            throw new IllegalArgumentException("Value is not acceptable. Has to be between 1 and 300000");
        StringBuilder num = new StringBuilder();

        for (int x = values.length - 1; x >= 0; x--){
            while(value >= values[x]){
                value = value - values[x];
                num.append(letters[x]);
            }
        }

        return num.toString();
    }

    public boolean equals(String number){
        return (this.number).equalsIgnoreCase(number);
    }

    public boolean equals(int value){
        return this.value == value;
    }

    public String add(String number){
        this.value += parseValue(number); 
        this.number = parseNumber(this.value);

        if (this.value < 0)
            throw new ArithmeticException("No negative allowed");

        return this.number;
    }

    public String subtract(String number){
        this.value -= parseValue(number); 
        this.number = parseNumber(this.value);

        if (this.value < 0)
            throw new ArithmeticException("No negative allowed");

        return this.number;    
    }

    public String multiply(String number){
        this.value *= parseValue(number); 
        this.number = parseNumber(this.value);

        if (this.value < 0)
            throw new ArithmeticException("No negative allowed");

        return this.number;    
    }

    public String divide(String number){
        this.value /= parseValue(number); 
        this.number = parseNumber(this.value);

        if (this.value < 0)
            throw new ArithmeticException("No negative allowed");
            
        return this.number;    
    }

    public String min(String number){
        int first = parseValue(this.number);
        int second = parseValue(number);

        if (first > second)
            return number;
        
        return this.number;
    }

    public String max(String number){
        int first = parseValue(this.number);
        int second = parseValue(number);

        if (first > second)
            return this.number;
        
        return number;
    }

    public static String calculate(String number){
        String result = "";
        int operation = 0;
        if (number.contains("+")){
            operation = parseValue(number.substring(0, number.indexOf("+"))) + parseValue(number.substring((number.indexOf("+") + 1), number.length()));
            result = parseNumber(operation);
        }
        else if (number.contains("-")){
            operation = parseValue(number.substring(0, number.indexOf("-"))) - parseValue(number.substring((number.indexOf("-") + 1), number.length()));
            result = parseNumber(operation);        
        }
        else if (number.contains("*")){
            operation = parseValue(number.substring(0, number.indexOf("*"))) * parseValue(number.substring((number.indexOf("*") + 1), number.length()));
            result = parseNumber(operation);        
        }  
        else if (number.contains("/")){
            operation = parseValue(number.substring(0, number.indexOf("/"))) / parseValue(number.substring((number.indexOf("/") + 1), number.length()));
            result = parseNumber(operation);        
        }  

        if (operation < 0)
            throw new ArithmeticException("No negative allowed");

        return result;
    }
}