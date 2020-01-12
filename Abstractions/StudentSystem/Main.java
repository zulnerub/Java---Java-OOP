package Abstractions.StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        while (true)
        {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("Exit")){
                break;
            }
            studentSystem.ParseCommand(input);
        }
    }
}
