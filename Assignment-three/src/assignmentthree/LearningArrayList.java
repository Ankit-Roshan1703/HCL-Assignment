package assignmentthree;

import java.util.ArrayList;

public class LearningArrayList {

    public static void main(String[] args) {

        ArrayList<String> list1 = new ArrayList<>();

        ArrayList<String> list2 = new ArrayList<>(5);

        list1.add("Learning");
        list1.add("ArrayList");
        list1.add("Java");

        ArrayList<String> list3 = new ArrayList<>(list1);

        list3.add("list3");

        System.out.println("List 1 : " + list1);

        System.out.println("List 3 : " + list3);

        list1.add("one");

        list2.add("list2");

        list2.addAll(list1);

        System.out.println("List 2 : " + list2);

        System.out.println("Element at index 2 of list 2 : " + list2.get(2));

        list1.set(0, "Working on");

        System.out.println("List 1 : " + list1);

        list2.remove(0);

        System.out.println("List 2 : " + list2);

        System.out.println("Size of list 1 : " + list1.size());

        System.out.println("Contain element : " + list1.contains("Java"));

        System.out.println("Is list empty : " + list1.isEmpty());

        System.out.println("Index of ArrayList : " + list1.indexOf("ArrayList"));

        list3.clear();

        System.out.println("List 3 after clear : " + list3);
        
    }
}

