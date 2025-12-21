package assignmentone;

class OperationsMatrix{

    void addition(int arr1[][], int arr2[][]){

        int row = arr1.length;
        int clounm = arr1[0].length;

        int sum[][] = new int[row][clounm];

        for(int i=0; i<row; i++){
            for(int j=0; j<clounm; j++){
                sum[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        System.out.println("Sum of arr1 and arr2 is : ");

        for(int i=0; i<sum.length; i++){
            for(int j=0; j<sum[0].length; j++){
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
    }

    void subtraction(int arr1[][], int arr2[][]){

        int row = arr1.length;
        int clounm = arr1[0].length;

        int diference[][] = new int[row][clounm];

        for(int i=0; i<row; i++){
            for(int j=0; j<clounm; j++){
                diference[i][j] = arr1[i][j] - arr2[i][j];
            }
        }

        System.out.println("Difference of arr1 and arr2 is : ");

        for(int i=0; i<diference.length; i++){
            for(int j=0; j<diference[0].length; j++){
                System.out.print(diference[i][j] + " ");
            }
            System.out.println();
        }
    }

    void multi(int arr1[][], int arr2[][]){

        if(arr1[0].length != arr2.length){
            System.out.println("Multiplication is not possible");
            return;
        }

        int row = arr1.length;
        int column = arr2[0].length;

        int arr3[][] = new int[row][column];

        for(int i=0; i<arr1.length; i++){

            for(int j=0; j<arr2[0].length; j++){

                for(int k=0; k<arr2.length; k++){

                    arr3[i][j] = arr3[i][j] + arr1[i][k] * arr2[k][j]; 

                }
            }
        }

        System.out.println("product arr3of arr1 and arr2 is : ");

        for(int i=0; i<arr3.length; i++){
            for(int j=0; j<arr3[0].length; j++){
                System.out.print(arr3[i][j] + " ");
            }
            System.out.println();
        }
    }

    void isSquareMatrix(int arr1[][]){

        int row = arr1.length;
        int column = arr1[0].length;

        if(row == column){
            System.out.println("It is a Square matrix");
        }
        else{
            System.out.println("It is not a Square matrix");
        }

    }


}

public class Operations2dArray {

    public static void main(String[] args) {

        OperationsMatrix obj = new OperationsMatrix();

        int arr1[][] = {{1,2},{3,4},{5,6}};

        int arr2[][] = {{1,2},{3,4}};

        //int arr3[][] = {{1,2},{4,5},{7,8}};


        //obj.addition(arr1, arr2);

        //obj.subtraction(arr1, arr2);

        obj.multi(arr1, arr2);

        //obj.isSquareMatrix(arr3);

    }
    
}
