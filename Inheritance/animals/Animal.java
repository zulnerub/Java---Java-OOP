package Inheritance.animals;

public class Animal {
    private String name;
    private int age;
    private String gender;
    private String sound;

    public Animal(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String produceSound() {
        return this.sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %d %s%n%s",
                this.getClass().getSimpleName(),
                this.getName(),
                this.getAge(),
                this.getGender(),
                this.produceSound());
    }
}

