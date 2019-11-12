package cert.book2.chapter3;

public class Squirrel {
    private String name;
    private int weight;

    public Squirrel(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "name:" + name + ", weight:" + weight;
    }
}
