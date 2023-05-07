import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardValidatorTest {

	@Test
	void testGetDigitsRightLeft() {
		long[] nums = {6, 2, 6, 2, 0, 4, 8, 1, 0, 6, 7, 5, 8, 8, 3, 4};
		assertArrayEquals(CardValidator.getDigitsRightLeft(4388576018402626l), nums);
	}

	@Test
	void testSecondDigitSums() {
		assertEquals(CardValidator.secondDigitSum(4388576018402626l), 37);
	}
	
	@Test
	void testOddDigitSums() {
		assertEquals(CardValidator.oddDigitSum(4388576018402626l), 38);
	}
	
	@Test
	void testValidFalse1() {
		assertFalse(CardValidator.isValid(4388576018402626l));
	}
	
	@Test
	void testValidFalse2() {
		assertFalse(CardValidator.isValid(35680289366482983l));
	}
	
	@Test
	void testValidFalse3() {
		assertFalse(CardValidator.isValid(678902435l));
	}
	
	@Test
	void testValidFalse4() {
		assertFalse(CardValidator.isValid(3782039373728374647l));
	}
	
	@Test
	void testValidTrue() {
		assertTrue(CardValidator.isValid(4388576018410707l));
	}
	
	@Test
	void testValidTrue2() {
		assertTrue(CardValidator.isValid(371234567895004l));
	}
}
