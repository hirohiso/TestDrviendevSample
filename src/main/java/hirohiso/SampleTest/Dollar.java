package hirohiso.SampleTest;

public class Dollar extends Money{


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
