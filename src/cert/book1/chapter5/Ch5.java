package cert.book1.chapter5;


public class Ch5 {
    public static void start() {
/*        Heritor heritor = new Heritor();
        heritor.eat(new Heritor());*/

        JellyFish jellyFish = new JellyFish();
        Animal animal = new JellyFish();
        System.out.println(jellyFish.length);
        jellyFish.print();
        System.out.println(animal.length);
        animal.print();

    }
}
