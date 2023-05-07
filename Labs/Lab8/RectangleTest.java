import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class RectangleTest {

	@Test
	public void testRectangle() {
		Rectangle test = new Rectangle();
		assertEquals(test.getSide1(), 0.0);
		assertEquals(test.getSide2(), 0.0);
	}
	
	@Test
	public void testRectangleDouble() {
		Rectangle test = new Rectangle(4.5, 5.0);
		assertEquals(test.getSide1(), 4.5);
		assertEquals(test.getSide2(), 5.0);
	}
	
	@Test
	public void testRectangleSetSide1() {
		Rectangle test = new Rectangle();
		test.setSide1(5.5);
		assertEquals(test.getSide1(), 5.5);
	}
	
	@Test
	public void testRectangleSetSide2() {
		Rectangle test = new Rectangle();
		test.setSide2(6.5);
		assertEquals(test.getSide2(), 6.5);
	}
	
	@Test
	public void testRectangleGetSide1() {
		Rectangle test = new Rectangle(5.0, 6.0);
		assertEquals(test.getSide1(), 5.0);
	}
	
	@Test
	public void testRectangleGetSide2() {
		Rectangle test = new Rectangle(5.0, 6.0);
		assertEquals(test.getSide2(), 6.0);
	}
	
	
	@Test
	public void testRectangleGetArea() {
		Rectangle test = new Rectangle(4.5, 5.23);
		assertEquals(test.getArea(), 23.54);
	}
	
	@Test
	public void testRectangleGetPerimeter() {
		Rectangle test = new Rectangle(5.0, 6.0);
		assertEquals(test.getPerimeter(), 22.0);
	}
	
	@Test
	public void testRectangleIsSquareFalse() {
		Rectangle test = new Rectangle(5.0, 6.0);
		assertFalse(test.isSquare());
	}
	
	@Test
	public void testRectangleIsSquareTrue() {
		Rectangle test = new Rectangle(5.0, 5.0);
		assertTrue(test.isSquare());
	}
	
	@Test
	public void testRectangleEqualsTrue() {
		Rectangle test = new Rectangle(5.0, 6.0);
		Rectangle test2 = new Rectangle(5.0, 6.0);
		assertTrue(test.isEquals(test2));
	}
	
	@Test
	public void testRectangleEqualsFalse() {
		Rectangle test = new Rectangle(5.0, 6.0);
		Rectangle test2 = new Rectangle(5.0, 7.0);
		assertFalse(test.isEquals(test2));
	}
	
	@Test
	public void testRectangleToString() {
		Rectangle test = new Rectangle(4.0, 5.0);
		String details = "created: " + test.getDateCreated() + ", color: " + test.getColor()+ " and filled: " + test.isFilled() + " Rectangle: Side 1: " + test.getSide1() + " and Side 2: " + test.getSide2();
		assertEquals(test.toString(), details);
	}
	
	@Test
	public void testCompare(){
		GeometricObject[] test = {(new Rectangle(1.5, 4.0)), (new Rectangle(5.1, 2.0)), (new Rectangle(3.5, 4.0)), (new Triangle(1.5, 4.0, 8.0)), (new Triangle(2.5, 4.0, 5.5))};
		java.util.Arrays.sort(test);
		for (int x = 1; x < test.length; x++) {
			assertTrue(test[x - 1].getArea() <= test[x].getArea());
		}
	}
}

