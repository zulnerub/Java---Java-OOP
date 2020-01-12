package InterfacesAndAbstraction.CollectionHierarchy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> inputData = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());
        
            int timesToRemove = Integer.parseInt(sc.nextLine());



        AddCollection addCollection = new AddCollection();
        AddRemovable addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        if (inputData.size() > 0){
            toAdd(addCollection, inputData);
            toAdd(addRemoveCollection, inputData);
            toAdd(myList, inputData);
        }


        if (timesToRemove > 0){
            toRemove(addRemoveCollection, timesToRemove);
            toRemove(myList, timesToRemove);
        }




    }

    public static void toRemove(AddRemovable collection, int timesToRemove){
        for (int i = 0; i < timesToRemove; i++) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }

    public static void toAdd(Addable collection, List<String> inputData){
        for (String item :
                inputData) {
            System.out.print(collection.add(item) + " ");
        }
        System.out.println();
    }
}
