package hirohiso.SampleTest;

public class Pair {
    private String from;
    private String to;

    Pair(String from, String to){
        this.from = from;
        this.to= to;
    }

    public boolean equals(Object o){
        Pair pair = (Pair)o;
        return (this.from.equals(pair.from) )&&(this.to.equals(pair.to));
    }

    public int hashCode(){
        return 0;
    }

}
