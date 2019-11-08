package cert.book2.chapter1;

public enum Seasons {
    WINTER {
        @Override
        public void printHours() {
            System.out.println("short hours");
        }
    },
    SUMMER {

        @Override
        public void printHours() {
            System.out.println("long hours");
        }
    },
    SPRING,
    FALL;
    public void printHours() {

    }
}
