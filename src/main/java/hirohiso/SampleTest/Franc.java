package hirohiso.SampleTest;

public class Franc extends Money{

    public Franc(int amount) {
        this.amount = amount;
    }

    /***
     *
     * @param multipl
     * @return
     */
    public Money times(int multipl) {
        return new Franc(this.amount*multipl);
    }


}
