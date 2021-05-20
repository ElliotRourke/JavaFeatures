package java8.functional;

@FunctionalInterface
public interface GooFunctional {
    String doSomethingAwesome(String s);
    default void mySecondDefault() {
        System.out.println("Defaulting!");
    }
}
