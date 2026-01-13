package assignmentone;

public class StringBufferOperation {
    public static void main(String[] args) {
        
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World");
        System.out.println(sb);
        sb.insert(6, "Java ");
        System.out.println(sb);
        sb.replace(6, 11, "Java");
        System.out.println(sb);
        sb.delete(5, 11);
        System.out.println(sb);
        sb.deleteCharAt(1);
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);

        System.out.println(sb.capacity());
        sb.ensureCapacity(50);
        System.out.println(sb.capacity());
        sb.setLength(5);
        System.out.println(sb);
        System.out.println(sb.charAt(1));
        sb.setCharAt(0, 'Y');
        System.out.println(sb);
        System.out.println(sb.substring(6));
        System.out.println(sb.substring(0, 5));
        System.out.println(sb.length());
        System.out.println(sb.indexOf("World"));
        System.out.println(sb.lastIndexOf("o"));
    }
}
