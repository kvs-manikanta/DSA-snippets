import java.util.Scanner;

public class Day9RepeatAndMissingNum {
    public static void repeatedNumber(final int[] A) {
        for(int i=0;i<A.length;i++)
        {
            while(A[i]>0 && A[i]<=A.length && A[i]!=i+1)
            {
                int temp=A[i];
                if(A[i]==A[temp-1])
                {
                    break;
                }
                else
                {
                    A[i]=A[temp-1];
                    A[temp-1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter length of array :");
        int A[]=new int[sc.nextInt()];
        System.out.println("Enter the values of array"+" ");
        for(int i=0;i<A.length;i++)
        {
            A[i]=sc.nextInt();
        }
        sc.close();

        repeatedNumber(A);

        for(int i=0;i<A.length;i++)
        {
            if(A[i]!=i+1)
            {
                System.out.print(A[i]+" "+(i+1));
            }
        }
    }
}
