package java8.functional;

@FunctionalInterface
public interface FooFunctional {
    String doSomethingAwesome(String s);

    //A functional interface, constrained to only having one public abstract function.
    //However we can add a default method.
    default void myFirstDefault() {
        System.out.println("Defaulting!");
    }
}
