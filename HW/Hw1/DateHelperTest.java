import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateHelperTest {

	@Test
	public void testgetMonthString1() {
		assertEquals(DateHelper.getMonth(1), "January");
	}
	
	@Test
	public void testgetMonthString2() {
		assertEquals(DateHelper.getMonth(0), "");
	}
	
	@Test
	public void testgetMonthString3() {
		assertEquals(DateHelper.getMonth(13), "");
	}
	
	@Test
	public void testgetMonthInt1() {
		assertEquals(DateHelper.getMonth("feb"), 2);
	}
	
	@Test
	public void testgetMonthInt2() {
		assertEquals(DateHelper.getMonth("Sunny"), -1);
	}
	
	@Test
	public void testgetMonthInt3() {
		assertEquals(DateHelper.getMonth("Ja"), -1);
	}
	
	@Test
	public void testgetDayInt1() {
		assertEquals(DateHelper.getDay(0), "Sunday");
	}
	
	@Test
	public void testgetDayInt2() {
		assertEquals(DateHelper.getDay(7), "Sunday");
	}
	
	@Test
	public void testgetDayInt3() {
		assertEquals(DateHelper.getDay(4), "Thursday");
	}

	@Test
	public void testgetDayString1() {
		assertEquals(DateHelper.getDay("Sun"), 0);
	}
	
	@Test
	public void testgetDayString2() {
		assertEquals(DateHelper.getDay("fr"), -1);
	}
	
	@Test
	public void testgetDayString3() {
		assertEquals(DateHelper.getDay("Thursdae"), -1);
	}
	
	@Test
	public void testgetDateString() {
		assertEquals(DateHelper.getDate(2022, 1, 10), "2022-01-10");
	}

	@Test
	public void testgetDateInt() {
		int num[] = {2022, 1, 10};
		assertArrayEquals(DateHelper.getDate("2022-01-10"), num);
	}
	
    @Test 
    public void testLeapTrue() { 
        String msg = "should be leap year"; 
        assertTrue(DateHelper.isLeapYear(2000), msg);
    }
    
    @Test 
    public void testLeapFalse1() { 
        String msg = "should not be leap year"; 
        assertFalse(DateHelper.isLeapYear(2001), msg);
    }
    
    @Test 
    public void testLeapFalse2() { 
        String msg = "should not be leap year"; 
        assertFalse(DateHelper.isLeapYear(1999), msg);
    }
    
    @Test 
    public void testValidDateTrue() { 
        String msg = "is a valid date"; 
        assertTrue(DateHelper.isValidDate(2000, 2, 29), msg);
    }
    
    @Test 
    public void testValidDateFalse1() { 
        String msg = "is not a valid date"; 
        assertFalse(DateHelper.isValidDate(2001, 13, 30), msg);
    }
    
    @Test 
    public void testValidDateFalse2() { 
        String msg = "is not a valid date"; 
        assertFalse(DateHelper.isValidDate(1999, -2, 28), msg);
    }
    
    @Test
	public void testDayOfYear1() {
		assertEquals(DateHelper.dayOfYear(2022, 1, 10), 10);
	}
    
    @Test
	public void testDayOfYear2() {
		assertEquals(DateHelper.dayOfYear(2022, 9, 9), 252);
	}
    
    @Test
	public void testDayOfMonth1() {
		assertEquals(DateHelper.daysOfMonth(2020, 2), 29);
	}
    
    @Test
	public void testDayOfMonth2() {
		assertEquals(DateHelper.daysOfMonth(2022, 1), 31);
	}
    
    @Test
	public void testDayOfWeek1() {
		assertEquals(DateHelper.dayOfWeek(2022, 1, 10), "Monday");
	}
    
    @Test
	public void testDayOfWeek2() {
		assertEquals(DateHelper.dayOfWeek(1965, 1, 1), "Friday");
	}
    
    @Test
	public void testDaysBetween(){
		assertEquals(DateHelper.daysBetween(2022, 1, 10, 2022, 9, 9), 242);
	}
    
    @Test
    public void testRandomYear1() {  
        assertNotEquals(DateHelper.randomYear(10, 20), 9);
    }
    
    @Test
    public void testRandomYear2() {  
        assertNotEquals(DateHelper.randomYear(10), 0);
    }
    
    @Test
    public void testRandomYear3() {  
        assertNotEquals(DateHelper.randomYear(), 0);
    }
 
    @Test
    public void testRandomMonth() {  
        assertNotEquals(DateHelper.randomMonth(), 0);
    }
    
    @Test
    public void testRandomDay1() {  
        assertNotEquals(DateHelper.randomDay(2022, 9), 0);
    }
    
    @Test
    public void testRandomDay2() {  
        assertNotEquals(DateHelper.randomDay(3), 0);
    }
    
    @Test
    public void testRandomDay3() {  
        assertNotEquals(DateHelper.randomDay(), 32);
    }
    
    @Test
    public void testRandomDate() {  
    	int rand[] = {0, 0, 0};
        assertNotEquals(DateHelper.randomDate(), rand);
    }
}
