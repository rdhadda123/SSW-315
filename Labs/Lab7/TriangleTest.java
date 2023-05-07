import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TriangleTest {

	@Test
	public void testTriangle() {
		Triangle one = new Triangle();
		assertEquals(one.getSide1(), 0.0);
		assertEquals(one.getSide2(), 0.0);
		assertEquals(one.getSide3(), 0.0);
	}
	
	@Test
	public void testTriangleInts() {
		Triangle two = new Triangle(4.5, 5.0, 6.0);
		assertEquals(two.getSide1(), 4.5);
		assertEquals(two.getSide2(), 5.0);
		assertEquals(two.getSide3(), 6.0);
	}
	
	@Test
	public void testSetSide1() {
		Triangle test = new Triangle();
		test.setSide1(5.5);
		assertEquals(test.getSide1(), 5.5);
	}
	
	@Test
	public void testSetSide2() {
		Triangle test = new Triangle();
		test.setSide2(6.5);
		assertEquals(test.getSide2(), 6.5);
	}
	
	@Test
	public void testSetSide3() {
		Triangle test = new Triangle();
		test.setSide3(7.5);
		assertEquals(test.getSide3(), 7.5);
	}
	
	@Test
	public void testGetSide1() {
		Triangle test = new Triangle(4.5, 5.0, 6.0);
		assertEquals(test.getSide1(), 4.5);
	}
	
	@Test
	public void testGetSide2() {
		Triangle test = new Triangle(4.5, 5.0, 6.0);
		assertEquals(test.getSide2(), 5.0);
	}
	
	@Test
	public void testGetSide3() {
		Triangle test = new Triangle(4.5, 5.0, 6.0);
		assertEquals(test.getSide3(), 6.0);
	}
	
	@Test
	public void testGetArea() {
		Triangle test = new Triangle(4.5, 5.0, 6.0);
		assertEquals(test.getArea(), 11.01);
	}
	
	@Test
	public void testGetPerimeter() {
		Triangle test = new Triangle(4.5, 5.0, 6.0);
		assertEquals(test.getPerimeter(), 15.5);
	}
	
	@Test
	public void testEquilateral() {
		Triangle test = new Triangle();
		assertTrue(test.isEquilateral());
	}
	
	@Test
	public void testEquilateral2() {
		Triangle test = new Triangle(5.0, 5.0, 5.0);
		assertTrue(test.isEquilateral());
	}
	
	@Test
	public void testIsosceles() {
		Triangle test = new Triangle(5.0, 5.0, 6.0);
		assertTrue(test.isIsosceles());
	}
	
	@Test
	public void testIsosceles2() {
		Triangle test = new Triangle(5.0, 5.0, 5.0);
		assertFalse(test.isIsosceles());
	}
	
	@Test
	public void testScalene() {
		Triangle test = new Triangle(4.0, 5.0, 6.0);
		assertTrue(test.isScalene());
	}
	
	@Test
	public void testScalene2() {
		Triangle test = new Triangle(0.1, 0.11, 0.111);
		assertTrue(test.isScalene());
	}
	
	@Test
	public void testScalene3() {
		Triangle test = new Triangle(0.1, 0.1, 0.111);
		assertFalse(test.isScalene());
	}
	
	@Test
	public void testToString() {
		Triangle test = new Triangle(4.0, 5.0, 6.0);
		String details = "created: " + test.getDateCreated() + ", color: " + test.getColor()+ " and filled: " + test.isFilled() + " Side 1: " + test.getSide1() + " Side 2: " + test.getSide2() + " and Side 3: " + + test.getSide3();
		assertEquals(test.toString(), details);
	}
	
	@Test
	public void testGeometricObject() {
		Triangle test = new Triangle();
		java.util.Date date = new java.util.Date();
		assertEquals(test.getDateCreated(), date);
		assertEquals(test.getColor(), "white");
	}
	
	@Test
	public void testGeometricObjectArgs() {
		Triangle test = new Triangle();
		java.util.Date date = new java.util.Date();
		test.setColor("red");
		test.setFilled(true);
		assertEquals(test.getDateCreated(), date);
		assertEquals(test.getColor(), "red");
		assertTrue(test.isFilled());
	}
	
	@Test
	public void testGetColor() {
		Triangle test = new Triangle();
		assertEquals(test.getColor(), "white");
	}
	
	@Test
	public void testSetColor() {
		Triangle test = new Triangle();
		test.setColor("blue");
		assertEquals(test.getColor(), "blue");
	}
	
	@Test
	public void testIsFilled() {
		Triangle test = new Triangle();
		assertFalse(test.isFilled());
	}
	
	@Test
	public void testSetFilled() {
		Triangle test = new Triangle();
		test.setFilled(true);
		assertTrue(test.isFilled());
	}
	
	@Test
	public void testGetDateCreated() {
		Triangle test = new Triangle();
		java.util.Date date = new java.util.Date();
		assertEquals(test.getDateCreated(), date);
	}
}
