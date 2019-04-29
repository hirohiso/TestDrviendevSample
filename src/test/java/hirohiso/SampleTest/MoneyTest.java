package hirohiso.SampleTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoneyTest {

	@Test
	public void test() {
		Dollar five = new Dollar(5);
		five.times(2);
		assertEquals(10, five.amount);

	}

}
