package cert.book2.chapter1;

public class Hello <T> {
    T t;
    public Hello(T t){
        this.t = t;
    }

    @Override
    public String toString() {
        return t.toString();
    }
}
