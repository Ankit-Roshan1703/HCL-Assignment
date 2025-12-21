package assignmentone;

import java.util.Scanner;

class ArrayOper{

    public void insert(int arr1[], int n, int element, int indexPosition){

        int arr2[] = new int[n+1];

        for(int i=0; i<n+1; i++){

            if(indexPosition>n){
                arr2[n] = element;
            }
            if(i<indexPosition){
                arr2[i] = arr1[i];
            }
            else if(i == indexPosition){
                arr2[i] = element;
            }
            else{
                arr2[i] = arr1[i-1];
            }
            
        }

        System.out.println("Array after insertion : ");

        for(int i=0; i<n+1; i++){
            System.out.print(arr2[i] + " ");
        }
    }

    public void deleteElement(int arr[], int size, int indexPosition){

        int arr2[] = new int[size-1];

        for(int i=0; i<size - 1; i++){
            if(i<indexPosition){
                arr2[i] = arr[i];
            }
            else{
                arr2[i] = arr[i+1];
            }
        }
        System.out.println("Array after Deletions : ");

        for(int i=0; i<size-1; i++){
            System.out.print(arr2[i] + " ");
        }

    }

    public void linerSearch(int arr[], int size, int element){

        
        int index = -1;
        for(int i=0; i<size; i++){

            if(arr[i] == element){
                index = i;
            }
        }

        if(index == -1){
            System.out.println("Element is present at index : " + index);
        }
        else{
            System.out.println("Element not found ");
        }
    }

    public int[] insertionSort(int arr[]){

        for(int i=0; i<arr.length; i++){

            int temp = arr[i];

            for(int j=i+1; j<arr.length; j++){

                if(arr[i] > arr[j]){
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                else{
                    if(i == j){
                        break;
                    }
                }
            }
        }

        // System.out.println("Array after Insertion sort : ");

        // for(int i=0; i<arr.length; i++){
        //     System.out.print(arr[i] + " ");
        // }

        return arr;

    }

    public void binarySearch(int arr2[], int element){

        int arr1[] = insertionSort(arr2);

        int s = 0;
        int e = arr1.length - 1;
        int index = -1;

        int mid = s + (e-s)/2;
       
        while(s<=e){

            if(arr1[mid] == element){
                index = mid;
                break;
            }
            else if(arr1[mid]>element){
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
            mid = s + (e-s)/2;
        }

        if(index == -1){
            System.out.println("Element not found");
        }
        else{
            System.out.println("Element found at index " + index);
        }

    }

    public void findMax(int arr[]){

        int max = arr[0];

        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println("Maximum element is : " + max);
    }

    public void countEvenOdd(int arr[]){

        int even = 0;
        int odd = 0;

        for(int i=0; i<arr.length; i++){

            if(arr[i]%2 == 0){
                even++;
            }
            else{
                odd++;
            }
        }
        System.out.println("Total no. of even element : " + even);
        System.out.println("Total no. of odd element : " + odd);
    }

}

public class ArrayOperations {
    
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        ArrayOper obj = new ArrayOper();

        int arr[] = new int[5];

        System.out.println("Enter element in array : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = s.nextInt();
        }

        //obj.insert(arr, 5, 12, 5);

        //obj.deleteElement(arr, 3, 2);

        //obj.linerSearch(arr, 5, 6);\

        //int arr1[] = {2, 5, 1, 7,3};

        //obj.insertionSort(arr1);

        obj.binarySearch(arr, 7);

        s.close();
        
    }
}
