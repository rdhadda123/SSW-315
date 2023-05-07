import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyIntegerTest {

	@Test
	public void testMyInteger() {
		MyInteger num = new MyInteger();
		assertEquals(num.get(), 0);
	}
	
	@Test
	public void testMyIntegerInt() {
		MyInteger num = new MyInteger(5);
		assertEquals(num.get(), 5);
	}
	
	@Test
	public void testMyIntegerString() {
		MyInteger num = new MyInteger("1234");
		assertEquals(num.get(), 1234);
	}
	
	@Test
	public void testMyIntegerChar() {
		char[] val = {'1', '2', '3', '4'};
		MyInteger num = new MyInteger(val);
		assertEquals(num.get(), 1234);
	}
	
	@Test
	public void testParseIntChar() {
		char[] val = {'1', '2', '3', '4'};
		assertEquals(MyInteger.parseInt(val), 1234);
	}
	
	@Test
	public void testParseIntString() {
		assertEquals(MyInteger.parseInt("1234"), 1234);
	}
	
	@Test
	public void testGet() {
		MyInteger num = new MyInteger();
		num.set(4);
		assertEquals(num.get(), 4);
	}
	
	@Test
	public void testSetInt() {
		MyInteger num = new MyInteger();
		assertTrue(num.set(2));
		assertEquals(num.get(), 2);
	}
	
	@Test
	public void testSetString() {
		MyInteger num = new MyInteger();
		assertTrue(num.set("12345"));
		assertEquals(num.get(), 12345);
	}
	
	@Test
	public void testSetChar() {
		MyInteger num = new MyInteger();
		char[] val = {'1', '2', '3', '4'};
		assertTrue(num.set(val));
		assertEquals(num.get(), 1234);
	}
	
	@Test
	public void testEven() {
		assertTrue(MyInteger.isEven(4));
	}
	
	@Test
	public void testEvenFalse() {
		assertFalse(MyInteger.isEven(3));
	}
	
	@Test
	public void testEvenInt() {
		MyInteger num = new MyInteger();
		num.set(4);
		assertTrue(MyInteger.isEven(num));
	}
	
	@Test
	public void testEvenIntFalse() {
		MyInteger num = new MyInteger();
		num.set(3);
		assertFalse(MyInteger.isEven(num));
	}
	
	@Test
	public void testEvenClass() {
		MyInteger num = new MyInteger();
		char[] val = {'2', '4'};
		num.set(val);
		assertTrue(MyInteger.isEven(num));
	}
	
	@Test
	public void testEvenClassFalse() {
		MyInteger num = new MyInteger();
		char[] val = {'2', '3'};
		num.set(val);
		assertFalse(MyInteger.isEven(num));
	}
	
	@Test
	public void testOdd() {
		assertTrue(MyInteger.isOdd(3));
	}
	
	@Test
	public void testOddFalse() {
		assertFalse(MyInteger.isOdd(4));
	}
	
	@Test
	public void testOddInt() {
		MyInteger num = new MyInteger();
		num.set(3);
		assertTrue(MyInteger.isOdd(num));
	}
	
	@Test
	public void testOddIntFalse() {
		MyInteger num = new MyInteger();
		num.set(4);
		assertFalse(MyInteger.isOdd(num));
	}
	
	@Test
	public void testOddClass() {
		MyInteger num = new MyInteger();
		char[] val = {'2', '3'};
		num.set(val);
		assertTrue(MyInteger.isOdd(num));
	}
	
	@Test
	public void testOddClassFalse() {
		MyInteger num = new MyInteger();
		char[] val = {'2', '4'};
		num.set(val);
		assertFalse(MyInteger.isOdd(num));
	}
	
	
	@Test
	public void testPrime() {
		assertTrue(MyInteger.isPrime(7));
	}
	
	@Test
	public void testPrimeFalse() {
		assertFalse(MyInteger.isPrime(6));
	}
	
	@Test
	public void testPrimeInt() {
		MyInteger num = new MyInteger();
		num.set(7);
		assertTrue(MyInteger.isPrime(num));
	}
	
	@Test
	public void testPrimeIntFalse() {
		MyInteger num = new MyInteger();
		num.set(6);
		assertFalse(MyInteger.isPrime(num));
	}
	
	@Test
	public void testPrimeClass() {
		MyInteger num = new MyInteger();
		char[] val = {'1', '3'};
		num.set(val);
		assertTrue(MyInteger.isPrime(num));
	}
	
	@Test
	public void testPrimeClassFalse() {
		MyInteger num = new MyInteger();
		char[] val = {'2', '4'};
		num.set(val);
		assertFalse(MyInteger.isPrime(num));
	}
	
	
	public void testEqualsInt() {
		MyInteger num = new MyInteger();
		num.set(7);
		MyInteger num2 = new MyInteger();
		num.set(7);
		assertTrue(num.equals(num2));
	}
	
	public void testEqualsIntFalse() {
		MyInteger num = new MyInteger();
		num.set(7);
		MyInteger num2 = new MyInteger();
		num.set(6);
		assertFalse(num.equals(num2));
	}
	
	public void testEqualsClass() {
		MyInteger num = new MyInteger();
		char[] val = {'2', '4'};
		num.set(val);
		assertFalse(num.equals(24));
	}
	
	public void testEqualsClassFalse() {
		MyInteger num = new MyInteger();
		char[] val = {'2', '4'};
		num.set(val);
		assertFalse(num.equals(23));
	}
}
