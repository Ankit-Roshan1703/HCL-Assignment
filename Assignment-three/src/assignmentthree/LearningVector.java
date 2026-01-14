package assignmentthree;

import java.util.ArrayList;
import java.util.Vector;

public class LearningVector {
    public static void main(String[] args) {
        
        Vector<String> v1 = new Vector<>();

        Vector<String> v2 = new Vector<>(3);

        Vector<String> v3 = new Vector<>(2,3);

        v1.add("Learing");
        v1.add("Vector");
        v1.add("Java");

        v3.add("v3 Element");

        ArrayList<String> list = new ArrayList<>(v1);
        Vector<String> v4 = new Vector<>(list);

        System.out.println("Vector v1 : " + v1);
        System.out.println("Vector v4 : " + v4);

        v1.add("one");
        v1.addElement("Two");
        v1.add(2,"index");

        v2.addAll(v1);

        System.out.println("Element at index 2  of v1 : " + v1.get(2));

        v1.set(1, "Updated");

        v1.remove(2);

        System.out.println(v1);

        v1.removeElement("one");

        System.out.println(v1);

        System.out.println("Size of v1 : " + v1.size());

        System.out.println("Capacity of v1 : " + v1.capacity());

        System.out.println("Contains Update : " + v1.contains("Update"));

        System.out.println("Index of Update in v1 : " + v1.indexOf("Update"));

        System.out.println("v4 : " + v4);

        v4.clear();

        System.out.println("v4 after clear : " + v4);
        
    }
}
