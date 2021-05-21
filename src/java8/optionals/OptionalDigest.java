package java8.optionals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalDigest {

    public OptionalDigest () {}

    public void getJava8OptionalFeatures() {
        //Optionals can help us with validating values, helping us to eliminate error-prone boilerplate checks!
        Optional<String> optional = Optional.empty(); //An empty optional!
        String str = "myString";
        Optional<String> myOptionalString = Optional.of(str);//Non-null optional
        Optional<String> myNullOptionalString = Optional.ofNullable(getString());//Could return null! But if it does it will return an empty optional!

        //We can use optionals to also substitute empty optional values with new instances of an object, for example..
        List<String> optionalList = getList().orElseGet(ArrayList::new);

    }

    public String getString() {
        return null;
    }

    public Optional<List<String>> getList() {
        return Optional.empty();
    }

}
