package taxCalculator;

import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.Test; 

/** Tests for the TaxCalculator class. 
 */ 
public class taxCalculatorTest { 
 
	@Test
	public void testIntSuccess() {
		assertEquals(TaxCalculator.getInt("1"), 1);
	}
	@Test
	public void testIntSuccess2() {
		assertEquals(TaxCalculator.getInt("HFHFH"), -1);
	}
	@Test
	public void testIntSuccess3() {
		assertEquals(TaxCalculator.getInt("-4"), -4);
	}
	@Test
	public void testIntSuccess4() {
		assertEquals(TaxCalculator.getInt(null), -1);
	}
	
    @Test
    public void testSuccessCalcEqual() {
    	//Several tests to see if calculation displays proper result
        assertEquals(TaxCalculator.calcTax(0, 15000), 1594.5);
    }
    @Test
    public void testSuccessCalcEqual2() {
        assertEquals(TaxCalculator.calcTax(1, 600000), 157506.0);
    }
    @Test
    public void testSuccessCalcEqual3() {
        assertEquals(TaxCalculator.calcTax(2, 50000), 6617.0);
    }
    @Test
    public void testSuccessCalcEqual4() {
        assertEquals(TaxCalculator.calcTax(3, 300000), 77253.5);
    } 
    
    @Test
    public void testSuccessInputEqual() { 
    	//test for inputting filing status
    	assertEquals(TaxCalculator.getFilingStatus(0), 0);
    }
    @Test
    public void testSuccessInputEqual2() { 
        assertEquals(TaxCalculator.getFilingStatus(1), 1);
    	}
    @Test
    public void testSuccessInputEqual3() { 
        assertEquals(TaxCalculator.getFilingStatus(4), -1);
    	}
    @Test
    public void testSuccessInputEqual4() { 
        assertEquals(TaxCalculator.getFilingStatus(-1), -1);
    	}
    @Test
    public void testSuccessInputEqual5() { 
        assertEquals(TaxCalculator.getFilingStatus(-2), -1);
    	}

    @Test
    public void testSuccessInputTaxEqual() { 
       //Test for inputting tax income
        assertEquals(TaxCalculator.getTaxableIncome(300000), 300000);
    }
    @Test
    public void testSuccessInputTaxEqual2() { 
        assertEquals(TaxCalculator.getTaxableIncome(15000), 15000);
    }
    @Test
    public void testSuccessInputTaxEqual3() { 
        assertEquals(TaxCalculator.getTaxableIncome(-1), -1);
    }
    @Test
    public void testSuccessInputTaxEqual4() { 
        assertEquals(TaxCalculator.getTaxableIncome(-600000), -1);
    }
    
 
} 