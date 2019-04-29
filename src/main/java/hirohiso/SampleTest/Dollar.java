package hirohiso.SampleTest;

public class Dollar {

    public int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    /***
     *
     * @param multipl
     * @return
     */
    public Dollar times(int multipl) {
        return new Dollar(this.amount*multipl);
    }

}
