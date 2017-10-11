package is.ru.StringCalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
	
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}
	
	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}
	
	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}
	
	@Test
	public void testMultipleNumbers() {
		assertEquals(6, Calculator.add("1,2,3"));
	}
	
	@Test
	public void testNewLine() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	
	@Test
	public void testNegative() {
		Exception exception = null;
		try {
			Calculator.add("-1,2");
		}
		catch(Exception e) {
			exception = e;
		}
	}
	
	@Test
	public void testNegatives() {
		Exception exception = null;
		try {
			Calculator.add("2,-4,3,-5");
		}
		catch(Exception e) {
			exception = e;
		}
	}
	
	@Test
	public void testGreaterThanThousand() {
		assertEquals(2, Calculator.add("1001,2"));
	}
}