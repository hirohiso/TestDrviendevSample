package hirohiso.SampleTest;

abstract class Money {
    protected int amount;
    protected String currency;
    abstract Money times(int multiple);

    public Money(int amount,String currency){
        this.amount = amount;
        this.currency = currency;
    }
    public boolean equals(Object o){
        Money m = (Money)o;
        return (m.amount == this.amount) && (this.getClass() == m.getClass());
    }


    static Dollar dollar(int m){
        return new Dollar(m,"USD");
    }
    static Franc franc(int m){
        return new Franc(m,"CHF");
    }

    public String currency(){
        return this.currency;
    };
}
