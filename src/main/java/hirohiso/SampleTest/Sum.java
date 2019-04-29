package hirohiso.SampleTest;

public class Sum implements Expression{
    Expression augend;
    Expression addend;

    public Sum(Expression add,Expression aug){
        this.addend = add;
        this.augend = aug;

    }

    public Money reduce(Bank bank,String to){
        int amount = this.addend.reduce(bank, to).amount + this.augend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression added) {
        return new Sum(this, added);
    }

    public Expression times(int multipl) {
        return new Sum(this.addend.times(multipl), this.augend.times(multipl));
    }

}
