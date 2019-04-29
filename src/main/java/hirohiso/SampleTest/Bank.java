package hirohiso.SampleTest;

import java.util.HashMap;

public class Bank {
    private HashMap<Pair, Integer> rates = new HashMap<>();

    public Money reduce(Expression sum, String to) {
        return sum.reduce(this,to);
    }

    public void addRate(String from, String to, int value) {
        rates.put(new Pair(from, to), value);

    }

    public int rate(String from, String to) {
        if(from.equals(to)){
            return 1;
        }

        return rates.get(new Pair(from, to));
    }

}

