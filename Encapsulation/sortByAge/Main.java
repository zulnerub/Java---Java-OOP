package Encapsulation.sortByAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(rd.readLine());

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = rd.readLine().split("\\s+");
            persons.add(new Person(input[0], input[1], Integer.parseInt(input[2])));
        }

        Collections.sort(persons, (firstPerson, secondPerson) -> {
            int sComp = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());

            if (sComp != 0){
                return sComp;
            }else{
                return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
            }
        });

        for (Person person :
                persons) {
            System.out.println(person.toString());
        }

    }
}
