package hirohiso.SampleTest;

public class Franc {
    private int amount;

    public Franc(int amount) {
        this.amount = amount;
    }

    /***
     *
     * @param multipl
     * @return
     */
    public Franc times(int multipl) {
        return new Franc(this.amount*multipl);
    }

    public boolean equals(Object o){
        Franc f = (Franc)o;
        return f.amount == this.amount;
    }
}
