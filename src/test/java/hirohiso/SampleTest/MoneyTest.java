package hirohiso.SampleTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoneyTest {

    @Test
    public void testMultipl() {
        Dollar five = new Dollar(5);
        assertEquals(new Dollar(10), five.times(2));
        assertEquals(new Dollar(15), five.times(3));

    }

    @Test
    public void testEquals(){
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));
    }
    @Test
    public void testFrancMultipl() {
        Franc five = new Franc(5);

        assertEquals(new Franc(10), five.times(2));
        assertEquals(new Franc(15), five.times(3));

    }
}
