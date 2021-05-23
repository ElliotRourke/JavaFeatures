package java8.optionals;

import javax.swing.text.html.Option;
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

        //What if we need to reach some nested field in an object? Previously we may need many checks before reading the field...
        Optional<User> user = Optional.ofNullable(getUser());
        String result = user
                .map(User::getAddress)
                .map(Address::getMyAddress)
                .orElse("Could not get address!");

        //We can also just make our above pojo return optionals in its getter using Optional.of(..) and then use Stream<T> flatmap to process the object.

    }

    private String getString() {
        return null;
    }

    private Optional<List<String>> getList() {
        return Optional.empty();
    }

    private User getUser() {
        return new User();
    }

}
