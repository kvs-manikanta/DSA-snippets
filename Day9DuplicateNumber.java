import java.util.Scanner;

public class Day9DuplicateNumber {
        public static int findDuplicate(int[] nums) {
            int n=nums.length;
            //every ele should placed in its i+1 postion until we swap to reach i+1 position
    
            for(int i=0;i<n;i++)
            {
                while(nums[i]>0 && nums[i]<=n && nums[i]!=i+1)
                {
                    int temp=nums[i];
                    if(nums[i]==nums[temp-1])
                    {
                        break;
                    }
                    else
                    {
                        nums[i]=nums[temp-1];
                        nums[temp-1]=temp;
                    }
                    
                }
            }
    
            for(int i=0;i<n;i++)
            {
                if(nums[i]!=i+1)
                {
                    return nums[i];
                }
            }
            return 0;
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

        int duplicate=findDuplicate(A);
        System.out.println("Duplicate elements in given array is : "+duplicate);
    }
    
}
