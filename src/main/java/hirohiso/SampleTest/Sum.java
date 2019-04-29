package hirohiso.SampleTest;

public class Sum implements Expression{
    Money augend;
    Money addend;

    public Sum(Money add,Money aug){
        this.addend = add;
        this.augend = aug;

    }

    public Money reduce(Bank bank,String to){
        int amount = this.addend.amount + this.augend.amount;
        return new Money(amount, to);
    }

}
