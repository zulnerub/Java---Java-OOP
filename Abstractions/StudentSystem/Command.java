package Abstractions.StudentSystem;

public interface Command {

    void execute(Repository repository, String[] args);
}
