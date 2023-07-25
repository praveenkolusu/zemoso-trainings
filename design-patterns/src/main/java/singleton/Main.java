package singleton;

public class Main {
    public static void main(String[] args) {
        Caching caching= Caching.getInstance();
        System.out.println( caching.getValue("key1"));
        caching.deleteKey("key1");
        caching.addValue("key5","value5");
        boolean hasKey=caching.hasKey("key1");
        System.out.println(hasKey);
        System.out.println( caching.getValue("key1"));
        System.out.println( caching.getValue("key5"));
    }
}