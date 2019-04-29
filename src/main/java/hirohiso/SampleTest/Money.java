package hirohiso.SampleTest;

public class Money {
    protected int amount;
    protected String currency;

    public Money times(int multiple){
        return new Money(this.amount*multiple,this.currency);
    };

    public Money(int amount,String currency){
        this.amount = amount;
        this.currency = currency;
    }
    public boolean equals(Object o){
        Money m = (Money)o;
        return (m.amount == this.amount) && (this.currency() == m.currency());
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

    public String toString(){
        return this.amount + ":" + this.currency;
    }
}
