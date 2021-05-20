package java8.functional;

@FunctionalInterface
public interface FooExtended extends FooFunctional, GooFunctional {
    //We can extend one functional interface with multiple others as long..
    //..as these functional interfaces share the same function signature.
}
