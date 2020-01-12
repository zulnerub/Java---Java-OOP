package Abstractions.StudentSystem;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    public String status(){
        if (this.grade >= 3.00 && this.grade < 3.50){
            return "Average";
        }else if (this.grade >= 3.50 && this.grade < 4.50){
            return "Good";
        }else if (this.grade >= 4.50 && this.grade < 5.50){
            return "Very good";
        }else if (this.grade >= 5.50){
            return "Exellent";
        }

        return "Poor";
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append(" is ");
        sb.append(getAge()).append(" years old. ");
        sb.append(status()).append(" student.");

        return sb.toString();
    }
}
