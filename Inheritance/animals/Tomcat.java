package Inheritance.animals;

public class Tomcat extends Cat {
    private static final String GENDER = "Male";
    public Tomcat(String name, int age) {
        super(name, age, GENDER);
        super.setSound("MEOW");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
