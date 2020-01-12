package Abstractions.StudentSystem;

public class StudentSystem {
    private Repository repo;

    public StudentSystem()
    {
        this.repo = new Repository();
    }

    @Deprecated
    public Repository getRepo() {
        return this.repo;
    }

    public void ParseCommand(String[]args) throws IllegalAccessException {
//        Scanner scanner = new Scanner(System.in);
//        String[] args = scanner.nextLine().split(" ");

        Command command = CommandFactory.createCommand(args[0]);
        command.execute(this.repo, args);
        }
    }

