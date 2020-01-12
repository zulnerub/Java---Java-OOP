package InterfacesAndAbstraction.SayHelloExtended;

public abstract class BasePerson implements Person {

    private String name;

    public BasePerson(String name) {
        this.setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return this.sayHello();
    }
}
