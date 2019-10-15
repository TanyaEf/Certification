package cert.book1.assesment;

public class RainDeer extends Deer {

    public RainDeer(int age) {
        System.out.println("RainDeer");
    }

    @Override
    public boolean hasHorns() {
        return false;
    }
}
