package java8.optionals;

public class User {

    private Address address;

    public User() {
        this.address = new Address();
    }


    public Address getAddress() {
        return address;
    }
}
