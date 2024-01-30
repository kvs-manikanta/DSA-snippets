import java.util.HashMap;
import java.util.Scanner;

public class Day15LargestSubarraySum {
    public static int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,-1);
        int sum=0;
        int ans=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(hm.containsKey(sum))
            {
                int ind=hm.get(sum);
                int val=i-ind;
                ans=Math.max(ans,val);
            }
            else
            {
                hm.put(sum,i);
            }
        }
        return ans;
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
        int ans=maxLen(A, A.length);
        System.out.println(ans);
    }
}
