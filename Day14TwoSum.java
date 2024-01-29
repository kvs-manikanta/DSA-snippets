import java.util.HashMap;
import java.util.Scanner;

public class Day14TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int b=target-nums[i];
            if(hm.containsKey(b))
            {
                return new int[]{hm.get(b),i};
            }
            else
            {
                hm.put(nums[i],i);
            }
        }

        return null;
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
        int target=sc.nextInt();
        int res[]=new int[2];
        res=twoSum(A, target);

        System.out.println(res[0]+" "+res[1]);
    }
}
