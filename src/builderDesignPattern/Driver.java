package builderDesignPattern;

public class Driver {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder()
                .build();
        System.out.println(person.toString());
    }
}
