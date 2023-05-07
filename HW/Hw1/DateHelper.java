public class DateHelper{
    public static final String[] monthName = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public static final String[] dayName = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public static final int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static String getMonth(int month){
        if (month < 1 || month > 12 )
            return "";

        return monthName[month - 1];

    }
 
    public static int getMonth(String month){
        if (month.length() >= 3){
            for (int x = 0; x < monthName.length; x++){
                if ((monthName[x].toLowerCase()).contains(month.toLowerCase())){
                    return x + 1;
                }
            }
        }

        return -1;
    }

    public static String getDay(int day){
        if (day == 0 || day == 7)
            return dayName[0];

        return dayName[day];
    }

    public static int getDay(String day){
        if (day.length() >= 3){
            for (int x = 0; x < dayName.length; x++){
                if ((dayName[x].toLowerCase()).contains(day.toLowerCase())){
                    return x;
                }
            }
        }
        
        return -1;
    }
 
    public static String getDate(int year, int month, int day){
        return String.format("%04d-%02d-%02d", year, month, day);

    }
  
    public static int[] getDate(String date){
        int dates[] = new int[3];

        int startIndex = 0;
        int lastIndex = date.indexOf("-", startIndex);

        dates[0] = Integer.parseInt((date.substring(startIndex, lastIndex)));
        
        startIndex = lastIndex + 1;
        lastIndex = date.indexOf("-", startIndex);
        dates[1] = Integer.parseInt((date.substring(startIndex, lastIndex)));

        startIndex = lastIndex + 1;
        lastIndex = date.length();
        dates[2] = Integer.parseInt((date.substring(startIndex, lastIndex)));

        return dates;
    }
 
    public static boolean isLeapYear(int year){
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
            return true;

        return false;
    }
  
    public static boolean isValidDate(int year, int month, int day){
        if (isLeapYear(year) == true){
            daysInMonth[1] = 29;
            if (month > 0 && month <= 12){
                if (daysInMonth[month-1] >= day && day > 0)
                    return true;
                }
            }
        else{
                if (month > 0 && month <= 12){
                    if (daysInMonth[month-1] >= day && day > 0)
                        return true;
                }
            }
        
        return false;
    }
 
    public static int dayOfYear(int year, int month, int day){
        int dayNum = 0;
        if (isValidDate(year, month, day) == true){
            if (month != 1){
                for (int x = 0; x < (month-1); x++){
                    dayNum += daysInMonth[x];
                }
                dayNum += day;
            }
            else
                dayNum += day;
        }
        else 
            return -1;

        return dayNum;
    }

    public static int daysOfMonth(int year, int month){
        if (isLeapYear(year) == true){
            if (month == 2)
                return 29;
        }
    
        return daysInMonth[month-1];
    }
 
    public static String dayOfWeek(int year, int month, int day){
        int count = 0;

        for (int startPoint = 1965; startPoint < year; startPoint++){
            if (isLeapYear(year))
                count += 366;
            else
                count += 365;
        }

        for (int x = 1; x < month; x++){
            count += daysInMonth[x - 1];
            if ((isLeapYear(year)) && x == 2)
                count += 1;
        }

        count += day - 1;
        return dayName[(count + 5) % 7];
    }

    public static int daysBetween(int yearFirst, int monthFirst, int dayFirst, int yearSecond, int monthSecond, int daySecond){
        int first = dayOfYear(yearFirst, monthFirst, dayFirst);
        int second = dayOfYear(yearSecond, monthSecond, daySecond);
        first += yearFirst * 365;
        second += yearSecond * 365;

        if (monthFirst <= 2)
            first += (yearFirst - 1) / 4 - (yearFirst - 1) / 100 + (yearFirst -1) / 400;
        else
            first += (yearFirst) / 4 - (yearFirst) / 100 + (yearFirst) / 400;

        if (monthSecond <= 2)
            second += (yearSecond - 1) / 4 - (yearSecond - 1) / 100 + (yearSecond -1) / 400;
        else 
            second += (yearSecond) / 4 - (yearSecond) / 100 + (yearSecond) / 400;
        

        return Math.abs(second - first);
    }


    public static int randomYear(int start, int end){
        if (start > end)
            return 0;
        return (int)(start + Math.random() * (end - start + 1));
    }
     
    public static int randomYear(int end){
        return (int)(1 + Math.random() * end);
    }
     
    public static int randomYear(){
        return (int)(1 + Math.random() * 9999);
    }

    public static int randomMonth(){
        return (int)(1 + Math.random() * 12);
    }
 
    public static int randomDay(int year, int month){
        if (isLeapYear(year) == true){
            daysInMonth[1] = 29;
            return (int)(1 + Math.random() * daysInMonth[month-1]);
        } 

        return (int)(1 + Math.random() * daysInMonth[month-1]);
    }

    public static int randomDay(int month){
        return (int)(1 + Math.random() * daysInMonth[month - 1]);
    }

    public static int randomDay(){
        return (int)(1 + Math.random() * 31);
    }

    public static int[] randomDate(){
        int[] fields = new int[3];
        fields[0] = randomYear();
        fields[1] = randomMonth();
        fields[2] = randomDay(fields[0], fields[1]);

        return fields;
    }

}