package Abstractions.StudentSystem;

public class CreateCommand implements Command{
    public void execute(Repository studentRepository, String args[]){

        var name = args[1];
        var age = Integer.parseInt(args[2]);
        var grade =Double.parseDouble(args[3]);
        if (!studentRepository.containsStudentByName(name))
        {
            var student = new Student(name, age, grade);
            studentRepository.registerStudent(name,student);
        }
    }
}
