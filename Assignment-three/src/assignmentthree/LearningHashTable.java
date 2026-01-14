package assignmentthree;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

public class LearningHashTable {
    public static void main(String[] args) {
        
        Hashtable<Integer, String> ht1 = new Hashtable<>();

        Hashtable<Integer, String> ht2 = new Hashtable<>(10);

        Hashtable<Integer, String> ht3 = new Hashtable<>(10, 0.75f);

        ht1.put(1, "Java");
        ht1.put(2, "Python");
        ht1.put(3, "C++");

        ht2.put(1, "One ht2");
        ht3.put(1, "One ht3");

        Hashtable<Integer, String> ht4 = new Hashtable<>(ht1);

        System.out.println("Hashtable ht1: " + ht1);
        System.out.println("Hashtable ht4 (Copied from ht1): " + ht4);

        ht1.put(4, "Spring");

        System.out.println("Value for key 2: " + ht1.get(2));

        ht1.remove(1);

        System.out.println("Contains key 3? " + ht1.containsKey(3));

        System.out.println("Contains value Java? " + ht1.containsValue("Java"));

        System.out.println("Size of ht1: " + ht1.size());

        System.out.println("Is ht1 empty? " + ht1.isEmpty());

        System.out.println("Keys using Enumeration:");
        Enumeration<Integer> keys = ht1.keys();
        while (keys.hasMoreElements()) {
            System.out.println(keys.nextElement());
        }

        System.out.println("Values using Enumeration:");
        Enumeration<String> values = ht1.elements();
        while (values.hasMoreElements()) {
            System.out.println(values.nextElement());
        }

        System.out.println("Key-Value pairs:");
        for (Map.Entry<Integer, String> entry : ht1.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("Key Set: " + ht1.keySet());

        System.out.println("Values Collection: " + ht1.values());

        ht1.replace(3, "CPP");

        System.out.println("Using forEach:");
        ht1.forEach((k, v) -> System.out.println(k + " -> " + v));

        ht4.clear();
        System.out.println("Hashtable ht4 after clear(): " + ht4);

        System.out.println("Final Hashtable ht1: " + ht1);

    }
}
