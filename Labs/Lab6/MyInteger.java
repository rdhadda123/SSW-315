public class MyInteger{
    private int value;

    MyInteger(int value){
         this.value = value;
    } 

    MyInteger(String value){
        this.value = parseInt(value);
    }

    MyInteger(char[] value){
        this.value = parseInt(value);
    }

    MyInteger(){
        this.value = 0;
    } 

    public int get(){
        return value;
    }

    public boolean set(int value){
        this.value = value;
        return this.value == value;

    }

    public boolean set(String value){
        return set(parseInt(value));
    }

    public boolean set(char[] value){
        return set(parseInt(value));
    }

    public boolean isEven(){
        return isEven(value);
    }

    public static boolean isEven(int value){
        if (value % 2 == 0)
            return true;

        return false;
    }

    public static boolean isEven(MyInteger val){
        return isEven(val.get());
    }

    public boolean isOdd(){
        return isOdd(value);
    }

    public static boolean isOdd(int value){
        if (value % 2 != 0)
            return true;
        
        return false;
    }

    public static boolean isOdd(MyInteger val){
        return isOdd(val.get());
    }

    public boolean isPrime(){
        return isPrime(value);
    }

    public static boolean isPrime(int value){
        if (value <= 1)
            return false;

        for (int x = 2; x < value; x++){
            if (value % x == 0)
                return false;
        }

        return true;
    }

    public static boolean isPrime(MyInteger val){
        return isPrime(val.get());
    }

    public boolean equals(int value){
        return (this.value == value);
    }

    public boolean equals(MyInteger value){
        return equals(value.get());
    }

    public static int parseInt(char[] value){
        int val = 0;
        for (int x = 0; x < value.length; x++){
            val = val * 10 + (value[x] - '0');
        }
        return val;
    }

    public static int parseInt(String value){
        return parseInt(value.toCharArray());
    }
}