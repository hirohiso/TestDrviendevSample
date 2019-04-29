package hirohiso.SampleTest;

abstract class Money {
    protected int amount;
    public boolean equals(Object o){
        Money m = (Money)o;
        return (m.amount == this.amount) && (this.getClass() == m.getClass());
    }

    abstract Money times(int multiple);
    static Dollar dollar(int m){
        return new Dollar(m);
    }
    static Franc franc(int m){
        return new Franc(m);
    }
}
