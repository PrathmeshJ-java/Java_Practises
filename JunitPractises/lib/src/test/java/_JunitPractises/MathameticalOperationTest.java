package _JunitPractises;

import static org.junit.jupiter.api.Assertions.*;




import org.junit.jupiter.api.Test;

class MathameticalOperationTest {

	@Test
	void testAddition() {
		MathamaticalOperation opr = new MathamaticalOperation();
		int Actual = opr.addition(4, 5);
		int expected = 9;
		assertEquals(expected, Actual);
		assertEquals(5, opr.addition(0, 5));
		assertEquals(4, opr.addition(-1, 5));
	}

	@Test
	void testSubtraction() {
		MathamaticalOperation opr = new MathamaticalOperation();
		int Actual = opr.subtraction(4, 5);
		int expected = -1;
		assertEquals(expected, Actual);
	}

	@Test
	void testMultiplication() {
		MathamaticalOperation opr = new MathamaticalOperation();
		int Actual = opr.multiplication(4, 5);
		int expected = 20;
		assertEquals(expected, Actual);
	}

	@Test
	void testDivision() {
		MathamaticalOperation opr = new MathamaticalOperation();
		int Actual = opr.division(6, 2);
		int expected = 3;
		assertEquals(expected, Actual);
	}
	
	@Test
	void testfindMax() {
		MathamaticalOperation opr = new MathamaticalOperation();
		int Actual = opr.findMax(new int[] {1,5,7,3,4,8,4});
		int expected = 8;
		assertEquals(expected, Actual);
		
	}
	
	@Test
	void testisEven() {
		MathamaticalOperation opr = new MathamaticalOperation();
        int number = 9;

        
        boolean result = opr.isEven(number);

        
//        assertTrue(result, number + " should be an even number");
        assertFalse(result, number + " should not be an even number");
	}
	
	@Test
	void testNotNull() {
		String str = "Hello World";
		assertNotNull(str, "str variable should not be null");
	}
	
	@Test
	void testNull() {
		String str = null;
		assertNull(str, "str variable should  be null");
	}

}
