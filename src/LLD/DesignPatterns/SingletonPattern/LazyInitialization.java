package LLD.DesignPatterns.SingletonPattern;

public class LazyInitialization {

    private static LazyInitialization instance = null;

    private LazyInitialization() {
        // private constructor to prevent instantiation
    }

    public static LazyInitialization getInstance() {
        if (instance == null) {
            instance = new LazyInitialization();
        }
        return instance;
    }
}
