package InterfacesAndAbstraction.SayHello;

public class European implements Person {
    private String name;

    public European(String pesho) {
        this.name = pesho;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
