import java.util.Scanner;

public class Day5TimeToBuyAndSellStocks {
    public static int maxProfit(int[] prices) {
        int minprice=prices[0];
        int prof=0;
        // To get the maximum prof we need to look for the min price we have bought in past , traverse //and check for max prof we can get 
        for(int i=1;i<prices.length;i++)
        {
            int cost=prices[i]-minprice;
            prof=Math.max(prof,cost);
            minprice=Math.min(minprice,prices[i]);
        }

        return prof;
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A[]=new int[6];
        System.out.println("Enter the values of array"+" ");
        for(int i=0;i<A.length;i++)
        {
            A[i]=sc.nextInt();
        }
        sc.close();
        int prof=maxProfit(A);
        System.out.println(prof);

    }
}
