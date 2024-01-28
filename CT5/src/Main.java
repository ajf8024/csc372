import java.util.Scanner;
import java.io.*;
public class Main
{

    // product of the array using recursion
    static int multiply(int arr[], int n)
    {
        // Terminating condition
        if (n == 0)
            return(arr[n]);
        else
            return (arr[n] * multiply(arr, n - 1));
    }


    public static void main(String[] args)
    {
        int n=5;
        Scanner sc=new Scanner(System.in);

        int a[]=new int[n]; // Array to store user inputs for multiplication
        // Taking numbers for multiplication
        System.out.println("Enter "+n+" numbers now : ");
        for(int i=0;i<n;i++)
        {
            System.out.println("Number  "+(i+1)+":");
            a[i]=sc.nextInt();
        }
        System.out.println("Product of the given "+n+" numbers is =");
        //recursive function call to get the multiplication result
        System.out.print(multiply(a,
                a.length - 1));
    }
}
