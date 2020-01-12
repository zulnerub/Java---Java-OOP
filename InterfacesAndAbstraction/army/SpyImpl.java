package InterfacesAndAbstraction.army;


import InterfacesAndAbstraction.army.Interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {

    private String codeNumber;

    protected SpyImpl(int id, String firstName, String secondName, String codeNumber) {
        super(id, firstName, secondName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "\r\nCode Number: " + this.codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }
}
