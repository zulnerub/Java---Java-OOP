package Polymorphism.word;



public class Initialization {

    public static CommandImpl buildCommandInterface(StringBuilder text) {
        CommandImpl asd =  new CommandImpl(text);

        asd.init();


        return asd;
    }
}
