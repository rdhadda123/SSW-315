import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RomanNumberTest {

	@Test
	public void testRomanNumberInt() {
		RomanNumber test = new RomanNumber(100);
		assertEquals(test.getValue(), 100);
		assertEquals(test.getNumber(), "Ⅽ");
	}

	@Test
	public void testRomanNumberString() {
		RomanNumber test = new RomanNumber("Ⅼ");
		assertEquals(test.getNumber(), "Ⅼ");
		assertEquals(test.getValue(), 50);
	}
	
	@Test
	public void testGetValue() {
		RomanNumber test = new RomanNumber(10);
		assertEquals(test.getValue(), 10);
	}
	
	@Test
	public void testGetNumber() {
		RomanNumber test = new RomanNumber("Ⅹ");
		assertEquals(test.getNumber(), "Ⅹ");
	}
	
	@Test
	public void testParseValue() {
		String num = "ⅩⅬ";
		assertEquals(RomanNumber.parseValue(num), 40);
	}
	
	@Test
	public void testParseNumber() {
		int val = 40;
		assertEquals(RomanNumber.parseNumber(val), "ⅩⅬ");
	}
	
	@Test
	public void testEqualsString() {
		RomanNumber test = new RomanNumber("ↈↈↈ");
		String num = "ↈↈↈ";
		assertTrue(test.equals(num));
	}
	
	@Test
	public void testEqualsInt() {
		RomanNumber test = new RomanNumber(100000);
		int num = 100000;
		assertTrue(test.equals(num));
	}
	
	@Test
	public void testAdd() {
		RomanNumber test = new RomanNumber("Ⅹ");
		String num = "Ⅴ";
		assertEquals(test.add(num), "ⅩⅤ");
	}
	
	@Test
	public void testSubtract() {
		RomanNumber test = new RomanNumber("Ⅹ");
		String num = "Ⅴ";
		assertEquals(test.subtract(num), "Ⅴ");
	}
	
	@Test
	public void testMultiply() {
		RomanNumber test = new RomanNumber("Ⅹ");
		String num = "Ⅴ";
		assertEquals(test.multiply(num), "Ⅼ");
	}
	
	@Test
	public void testDivide() {
		RomanNumber test = new RomanNumber("Ⅹ");
		String num = "Ⅴ";
		assertEquals(test.divide(num), "ⅠⅠ");
	}
	
	@Test
	public void testMin() {
		RomanNumber test = new RomanNumber("Ⅹ");
		String num = "Ⅸ";
		assertEquals(test.min(num), "Ⅸ");
	}
	
	@Test
	public void testMax() {
		RomanNumber test = new RomanNumber("Ⅹ");
		String num = "Ⅸ";
		assertEquals(test.max(num), "Ⅹ");
	}
	
	@Test
	public void testCalculateAdd() {
		String num = "ⅩⅬ+Ⅹ";
		assertEquals(RomanNumber.calculate(num), "Ⅼ");
	}
	
	@Test
	public void testCalculateSubtract() {
		String num = "ⅩⅬ-Ⅹ";
		assertEquals(RomanNumber.calculate(num), "ⅩⅩⅩ");
	}
	
	@Test
	public void testCalculateMultiply() {
		String num = "ⅩⅬ*Ⅹ";
		assertEquals(RomanNumber.calculate(num), "ⅭⅮ");
	}
	
	@Test
	public void testCalculateDivide() {
		String num = "ⅩⅬ/Ⅹ";
		assertEquals(RomanNumber.calculate(num), "Ⅳ");
	}
	
	
}
