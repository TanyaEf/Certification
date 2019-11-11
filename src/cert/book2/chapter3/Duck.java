package cert.book2.chapter3;

public class Duck implements Comparable<Duck> {
    private String name;

    public Duck(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Duck other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                '}';
    }
}
