package hirohiso.SampleTest;

public class Franc extends Money{


    public Franc(int amount,String currency) {
        super(amount, currency);
    }

    /***
     *
     * @param multipl
     * @return
     */
    public Money times(int multipl) {
        return Money.franc(this.amount*multipl);
    }



}
