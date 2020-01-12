package Abstractions.StudentSystem;

public class ShowCommand implements Command{
    public void execute(Repository repository, String args[]) {
        var name = args[1];
        if (repository.containsStudentByName(name)) {
            var student = repository.findOneByName(name);
            String view = String.format("%s is %s years old.", student.getName(), student.getAge());

            if (student.getGrade() >= 5.00) {
                view += " Excellent student.";
            } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                view += " Average student.";
            } else {
                view += " Very nice person.";
            }
            System.out.println(view);
        }
    }
}
