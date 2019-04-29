package hirohiso.SampleTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoneyTest {

    @Test
    public void test() {
        Dollar five = new Dollar(5);
        Dollar product = null;

        product = five.times(2);
        assertEquals(10, product.amount);
        product = five.times(3);
        assertEquals(15, product.amount);

    }

}
