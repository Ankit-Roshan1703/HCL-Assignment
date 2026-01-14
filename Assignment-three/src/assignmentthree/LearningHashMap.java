package assignmentthree;

import java.util.HashMap;
import java.util.Map;

public class LearningHashMap {

    public static void main(String[] args) {
        
        HashMap<Integer, String> map1 = new HashMap<>();

        HashMap<Integer, String> map2 = new HashMap<>(10);

        HashMap<Integer, String> map3 = new HashMap<>(10, 0.75f);

        map1.put(1, "Java");
        map1.put(2, "Python");
        map1.put(3, "C++");

        map2.put(1, "Hello");

        map3.put(1, "Anki");


        HashMap<Integer, String> map4 = new HashMap<>(map1);

        System.out.println("Map1: " + map1);
        System.out.println("Map4 (Copied from Map1): " + map4);

        map1.put(4, "Spring");

        map1.putIfAbsent(2, "JavaScript");

        System.out.println("Value for key 3: " + map1.get(3));

        map1.remove(1);

        System.out.println("Contains key 2? " + map1.containsKey(2));

        System.out.println("Contains value Java? " + map1.containsValue("Java"));

        System.out.println("Size of map1: " + map1.size());

        System.out.println("Is map1 empty? " + map1.isEmpty());

        System.out.println("Keys: " + map1.keySet());

        System.out.println("Values: " + map1.values());

        System.out.println("Key-Value pairs:");
        for (Map.Entry<Integer, String> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        map1.replace(3, "CPP");

        System.out.println("Value for key 5: " + map1.getOrDefault(5, "Not Found"));

        System.out.println("Using forEach:");
        map1.forEach((k, v) -> System.out.println(k + " -> " + v));

        map4.clear();
        System.out.println("Map4 after clear(): " + map4);

        System.out.println("Final Map1: " + map1);

    }
    
}
