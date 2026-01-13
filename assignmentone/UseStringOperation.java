package assignmentone;

public class UseStringOperation {

    public static void main(String[] args) {

        String str=new String("Ankit");
        String a="Ankit";
        String b="ankit";
        String c=" A n ki    ";
        System.out.println("The length of String is "+str.length());
        System.out.println(str.charAt(1));
        System.out.println(str.substring(0, 5));
        System.out.println(a.equals(b));
        System.out.println(a.equalsIgnoreCase(b));
        System.out.println(a.compareTo(b));
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
        System.out.println(c.trim());
        String d = "Hello World";
        System.out.println(d.contains("World"));
        String e = "Hello World";
        System.out.println(e.startsWith("Hello"));
        System.out.println(e.endsWith("World"));
        String f = "Hello World";
        System.out.println(f.indexOf("o"));
        System.out.println(f.lastIndexOf("o"));
        //String g = "Java";
        System.out.println(str.replace('v', 'o'));
        //String h = "apple,banana,grape";
        String[] fruits = str.split(",");
        for(String i : fruits) {
            System.out.println(i);
        }
        System.out.println(str.isEmpty());
        int num = 100;
        String str1 = String.valueOf(num);
        System.out.println(str1);

    }
    
}
