package Abstractions.StudentSystem;

public class NewCommand implements Command {
    @Override
    public void execute(Repository repository, String[] args) {
        System.out.println("NEW COMMAND");
    }
}
