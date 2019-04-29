package hirohiso.SampleTest;

public class Dollar extends Money{


    public Dollar(int amount,String currency) {
        super(amount, currency);
    }

    /***
     *
     * @param multipl
     * @return
     */
    public Money times(int multipl) {
        return Money.dollar(this.amount*multipl);
    }

}
