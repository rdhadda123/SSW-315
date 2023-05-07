import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaxCounterTest {

	@Test
	void testParseValue1() {
		int[] nums = {0, 1, 2, 3, 4, 5, 6, 6, 6, 6};
		assertArrayEquals(MaxCounter.parseValue("0  1 2  3 4 5 6 6 6 6"), nums);
	}

	@Test
	void testMaxCount1() {
		int[] nums = {0, 1, 2, 3, 4, 5, 6, 6, 6, 6};
		int[] maxCount = {6, 4};
		assertArrayEquals(MaxCounter.getMaxCount(nums), maxCount);
	}
	
	@Test
	void testMaxCount2() {
		int[] nums = {-10, -10, -9, -8, -4, -4, -3, -2, -1, -1, -1};
		int[] maxCount = {-1, 3};
		assertArrayEquals(MaxCounter.getMaxCount(nums), maxCount);
	}
}
