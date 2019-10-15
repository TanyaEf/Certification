package cert.book1.assesment;

public class Assesment {

    public static void assesmemt() {
        boolean keepGoing = true;
        int count = 0;
        int x = 3;

        while (count++ < 3) {
            int y = (1 + 2 * count) % 3;
            switch (y) {
                default:
                case 0:
                    x -= 1;
                    break;
                case 1:
                    x += 5;

            }
        }
        System.out.println(x);

        /*       Deer deer = new RainDeer(5);
        System.out.println(","+deer.hasHorns());

        System.out.println(LocalDate.of(2015, Calendar.APRIL, 1));
        System.out.println(LocalDate.of(2015, Month.APRIL, 1));
        System.out.println(LocalDate.of(2015, 3, 1));
        System.out.println(LocalDate.of(2015, 4, 1));
        System.out.println(new LocalDate(2015, 3, 1));
        System.out.println(new LocalDate(2015, 4, 1));*/
    }
}
