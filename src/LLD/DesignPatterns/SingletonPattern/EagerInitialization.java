package LLD.DesignPatterns.SingletonPattern;

public class EagerInitialization {
    private static EagerInitialization instance = new EagerInitialization();

    private EagerInitialization() {
        // private constructor to prevent instantiation
    }

    public static EagerInitialization getInstance() {
        return instance;
    }
}
