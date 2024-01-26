import java.util.Scanner;

public class Day11MajorityElement1 {
    public static int majorityElement(int[] nums) {
        int cnt=0;
        int currcand=nums[0];
        for(int i=0;i<nums.length;i++)
        {
            if(cnt==0)
            {
                currcand=nums[i];
               
            }
            if(nums[i]==currcand)
            {
                cnt++;
            }
            else
            {
                cnt--;
            }
        }

        return currcand;
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

        int majority=majorityElement(A);

        System.out.println("Majority element is: "+ majority);
    }
}
