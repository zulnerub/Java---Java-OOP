package Abstractions.StudentSystem;

public class CommandFactory {
    public static Command createCommand(String commandType) throws IllegalAccessException {
        switch (commandType){
            case "Create": return new CreateCommand();
            case "Show": return new ShowCommand();
            case "New": return new NewCommand();
        }

        throw new IllegalAccessException("Unknown command type!");

    }
}
