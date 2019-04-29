package hirohiso.SampleTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoneyTest {

    @Test
    public void testMultipl() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));

    }

    @Test
    public void testEquals(){
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.dollar(5).equals(Money.franc(5)));
    }


    @Test
    public void testCurrency(){
        assertEquals("USD",Money.dollar(1).currency());
        assertEquals("CHF",Money.franc(1).currency());
    }

    @Test
    public void testSimpleAddition(){
        Money five  = Money.dollar(5);
        //お金（ドル）とお金（ドル）の合計
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        //合計をドル換算で
        Money reduce = bank.reduce(sum,"USD");
        assertEquals(Money.dollar(10),reduce);
    }

    @Test
    public void testPlusReturnSum(){
        Money five = Money.dollar(5);

        Expression result = five.plus(five);
        Sum sum = (Sum)result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    public void testReduceSum(){
        //3ドルと4ドルの合計をドル換算で受け取るテスト
        Expression sum = new Sum(Money.dollar(3),Money.dollar(4));
        Bank bank = new Bank();
        Money reduce = bank.reduce(sum,"USD");
        //reduceメソッドでsumからお金を取り出して合計した新しいMoneyを返す
        assertEquals(Money.dollar(7),reduce);
    }

    @Test
    public void testReduceMoney(){
        Bank bank = new Bank();
        //reduceメソッドはExpressionを引数にとるので、
        //Moneyもテスト対象に加える
        Money reduce = bank.reduce(Money.dollar(1),"USD");
        assertEquals(Money.dollar(1),reduce);
    }

    @Test
    public void testReduceMoneyDifferentCurrency(){
        Bank bank = new Bank();
        //通貨レートを登録
        bank.addRate("CHF","USD",2);

        Money reduce = bank.reduce(Money.franc(2),"USD");
        assertEquals(Money.dollar(1),reduce);
    }
    @Test
    public void testIdentityRate(){
        Bank bank = new Bank();

        assertEquals(1,bank.rate("USD", "USD"));
    }

    @Test
    public void testMixedAddition(){
        Expression fiveBacks  = Money.dollar(5);
        Expression tenFrancs  = Money.franc(10);
        //お金（ドル）とお金（ドル）の合計

        Bank bank = new Bank();
        //通貨レートを登録
        bank.addRate("CHF","USD",2);
        //合計をドル換算で
        Money result = bank.reduce(fiveBacks.plus(tenFrancs),"USD");
        assertEquals(Money.dollar(10),result);
    }

    @Test
    public void testSumPlusMoney(){
        Expression fiveBacks  = Money.dollar(5);
        Expression tenFrancs  = Money.franc(10);
        Bank bank = new Bank();
        //通貨レートを登録
        bank.addRate("CHF","USD",2);

        //お金（ドル）とお金（フラン）の合計とお金(ドル)の合計
        Expression sum = new Sum(fiveBacks, tenFrancs).plus(fiveBacks);
        //合計をドル換算で
        Money result = bank.reduce(sum,"USD");
        assertEquals(Money.dollar(15),result);
    }
    @Test
    public void testSumTimes(){
        Expression fiveBacks  = Money.dollar(5);
        Expression tenFrancs  = Money.franc(10);
        Bank bank = new Bank();
        //通貨レートを登録
        bank.addRate("CHF","USD",2);

        //お金（ドル）とお金（フラン）の合計の2倍
        Expression sum = new Sum(fiveBacks, tenFrancs).times(2);
        //合計をドル換算で
        Money result = bank.reduce(sum,"USD");
        assertEquals(Money.dollar(20),result);
    }
}
