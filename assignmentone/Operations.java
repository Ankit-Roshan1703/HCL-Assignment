package assignmentone;

import java.util.Scanner;

class BasicOperations{

    public void addition(int a, int b){

        System.out.println("Sum of " + a + " and " + b + " is : ");
        System.out.println(a+b);

    }

    public void subtraction(int a, int b){

        System.out.println("Difference of " + a + " and " + b + " is : ");
        System.out.println(a-b);

    }

    public void multiplication(int a, int b){

        System.out.println("Product of " + a + " and " + b + " is : ");
        System.out.println(a*b);

    }

    public void division(int a, int b){

        System.out.println("Quotient of " + a + " and " + b + " is : ");
        System.out.println(a/b);
    }

    public void remainder(int a, int b){

        System.out.println("Remainder of " + a + " and " + b + " is : ");
        System.out.println(a%b);

    }

    public void square(int a){

        System.out.println("Square of " + a + " is : ");
        System.out.println(a*a);

    }

    public void cube(int a){

        System.out.println("Cube of " + a + " is : ");
        System.out.println(a*a*a);

    }

    public void absolute(int a){

        int ans ;

        if(a>=0){
            ans = a;
        }
        else{
            ans = -a;
        }

        System.out.println("Absolute value of " + a + " is : ");
        System.out.println(ans);

    }

}

public class Operations {
    public static void main(String[] args) {

        BasicOperations obj = new BasicOperations();

        Scanner s = new Scanner(System.in);

        System.out.println("Enter two number : ");
        int a = s.nextInt();
        int b = s.nextInt();

        obj.addition(a, b);
        obj.subtraction(a, b);
        obj.multiplication(a, b);
        obj.division(a, b);
        obj.remainder(a, b);
        obj.square(a);
        obj.cube(a);
        obj.absolute(-4);
        obj.absolute(4);


        s.close();
        
    }
}
