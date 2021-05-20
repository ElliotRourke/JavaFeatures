package java8.functional;

import java.util.function.Function;

public class FunctionalDigest {

    public FunctionalDigest() {}

    public void getJava8FunctionalFeatures() {
        //We can create functions using @FunctionalInterface or from the Java function package
        Function<String, String> fn = param -> param + " <- your string!";
        System.out.println(fn.apply("My String!")); //We apply the function to an input! Easy :)
        //Note we can pass these functions as parameters!


    }
}
