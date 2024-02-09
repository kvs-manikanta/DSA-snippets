import java.util.Scanner;

public class Day25RainWaterTrapped {
    public static int trap(int[] height) {
        int pfmax[]=new int[height.length];
        int sfmax[]=new int[height.length];
        int n=height.length;
        pfmax[0]=height[0];
        for(int i=1;i<n;i++)
        {
            pfmax[i]=Math.max(height[i],pfmax[i-1]);
        }

        sfmax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--)
        {
            sfmax[i]=Math.max(height[i],sfmax[i+1]);
        }

        int totalTrappedUnits=0;
        for(int i=1;i<n-1;i++)
        {
            int wtr=(Math.min(pfmax[i],sfmax[i])-height[i]);
            totalTrappedUnits+=wtr;
        }

        return totalTrappedUnits;
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

        int totalUnits=trap(A);
        System.out.println("Total water trapped :"+totalUnits);
    }
}
