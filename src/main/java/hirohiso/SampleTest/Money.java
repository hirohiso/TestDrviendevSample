package hirohiso.SampleTest;

public class Money implements Expression{
    protected int amount;
    protected String currency;


    public Money(int amount,String currency){
        this.amount = amount;
        this.currency = currency;
    }
    public boolean equals(Object o){
        Money m = (Money)o;
        return (m.amount == this.amount) && (this.currency() == m.currency());
    }


    static Money dollar(int m){
        return new Money(m,"USD");
    }
    static Money franc(int m){
        return new Money(m,"CHF");
    }

    public String currency(){
        return this.currency;
    };

    public String toString(){
        return this.amount + ":" + this.currency;
    }

    public Expression plus(Expression added) {

        return new Sum(this,added);
    }

    public Expression times(int multiple){
        return new Money(this.amount*multiple,this.currency);
    };

    public Money reduce(Bank bank,String to) {
        int rate = bank.rate(this.currency, to);
        return new Money(this.amount/rate, to);
    }
}
