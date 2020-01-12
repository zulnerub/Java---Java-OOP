package InterfacesAndAbstraction.SayHello;

public class Bulgarian implements Person {

    private String name;

    public Bulgarian(String pesho) {
        this.name = pesho;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
