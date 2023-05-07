import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ImageHelperTest {

	@Test
	void testValidMatrixTrue1() {
		int[][] test1 = {{1, 2, 3, 4},
		        		{5, 6, 7, 8},
		        		{9, 10, 11, 12},
		        		{13, 14, 15, 16}};
		assertTrue(ImageHelper.validMatrix(test1));
	}
	
	@Test
	void testValidMatrixTrue2() {
		int[][] test2 = {{1}};
		assertTrue(ImageHelper.validMatrix(test2));
	}
	
	@Test
	void testValidMatrixFalse1() {
		int[][] testFalse = {{1, 2, 3},
		        		{4, 5, 6},
		        		{7, 8, 9},
		        		{10, 11, 12}};
		assertFalse(ImageHelper.validMatrix(testFalse));
	}
	
	@Test
	void testValidMatrixFalse2() {
		int[][] testFalse = {{}};
		assertFalse(ImageHelper.validMatrix(testFalse));
	}
	
	@Test
	void testRotateClockwise1() {
		int[][] input = {{5, 1, 9, 11},
		        		{2, 4, 8, 10},
		        		{13, 3, 6, 7},
		        		{15, 14, 12, 16}};
		ImageHelper.rotateClockwise(input);
		int[][] output = {{15,13,2,5},
						{14,3,4,1},
						{12,6,8,9},
						{16,7,10,11}};
		assertTrue(Arrays.deepEquals(input, output));
	}
	
	@Test
	void testRotateClockwise2() {
		int[][] input = {{1, 2, 3},
						{4, 5, 6},
						{7, 8, 9}};
		ImageHelper.rotateClockwise(input);
		int[][] output = {{7,4,1},
						{8,5,2},
						{9,6,3}};
		assertTrue(Arrays.deepEquals(input, output));
	}
	
	@Test
	void testRotateCounterClockwise1() {
		int[][] input = {{5, 1, 9, 11},
		        		{2, 4, 8, 10},
		        		{13, 3, 6, 7},
		        		{15, 14, 12, 16}};
		ImageHelper.rotateCounterClockwise(input);
		int[][] output = {{11, 10, 7, 16},
						{9, 8, 6, 12},
						{1, 4, 3, 14},
						{5, 2, 13, 15}};
		assertTrue(Arrays.deepEquals(input, output));
	}
	
	@Test
	void testRotateCounterClockwise2() {
		int[][] input = {{1, 2, 3},
						{4, 5, 6},
						{7, 8, 9}};
		ImageHelper.rotateCounterClockwise(input);
		int[][] output = {{3, 6, 9},
						{2, 5, 8},
						{1, 4, 7}};
		assertTrue(Arrays.deepEquals(input, output));
	}
	
	@Test
	void testFlipVertical1() {
		int[][] input = {{5, 1, 9, 11},
		        		{2, 4, 8, 10},
		        		{13, 3, 6, 7},
		        		{15, 14, 12, 16}};
		ImageHelper.flipVertical(input);
		int[][] output = {{15, 14, 12, 16},
						{13, 3, 6, 7},
						{2, 4, 8, 10},
						{5, 1, 9, 11}};
		assertTrue(Arrays.deepEquals(input, output));
	}
	
	@Test
	void testFlipVertical2() {
		int[][] input = {{1, 2, 3, 4, 5},
		        		{6, 7, 8, 9, 10},
		        		{11, 12, 13, 14, 15},
		        		{16, 17, 18, 19, 20},
		        		{21, 22, 23, 24, 25}};
		ImageHelper.flipVertical(input);
		int[][] output = {{21, 22, 23, 24, 25},
						{16, 17, 18, 19, 20},
						{11, 12, 13, 14, 15},
						{6, 7, 8, 9, 10},
						{1, 2, 3, 4, 5}};
		assertTrue(Arrays.deepEquals(input, output));
	}
	
	@Test
	void testFlipHorizontal1() {
		int[][] input = {{5, 1, 9, 11},
		        		{2, 4, 8, 10},
		        		{13, 3, 6, 7},
		        		{15, 14, 12, 16}};
		ImageHelper.flipHorizontal(input);
		int[][] output = {{11, 9, 1, 5},
						{10, 8, 4, 2},
						{7, 6, 3, 13},
						{16, 12, 14, 15}};
		assertTrue(Arrays.deepEquals(input, output));
	}
	
	@Test
	void testFlipHorizontal2() {
		int[][] input = {{1, 2, 3, 4, 5},
		        		{6, 7, 8, 9, 10},
		        		{11, 12, 13, 14, 15},
		        		{16, 17, 18, 19, 20},
		        		{21, 22, 23, 24, 25}};
		ImageHelper.flipHorizontal(input);
		int[][] output = {{5, 4, 3, 2, 1},
						{10, 9, 8, 7, 6},
						{15, 14, 13, 12, 11},
						{20, 19, 18, 17, 16},
						{25, 24, 23, 22, 21}};
		assertTrue(Arrays.deepEquals(input, output));
	}
}
