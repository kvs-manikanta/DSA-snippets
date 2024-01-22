import java.util.Scanner;

public class Day4SortColors {
    public static void sortColors(int[] nums) {
        int low=0;
        int mid=0;
        int high=nums.length-1; 
        
        //Dutch National Flag Algorithm 
        while(mid<=high)
        {
            if(nums[mid]==0)
            {
                int val=nums[low];
                nums[low]=nums[mid];
                nums[mid]=val;
                low++;
                mid++;
            }
            else if(nums[mid]==1)
            {
                mid++;
            }
            else
            {
                int val=nums[high];
                nums[high]=nums[mid];
                nums[mid]=val;
                high--;
            }
        }
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
        sortColors(A);

        for(int i=0;i<A.length;i++)
        {
            System.out.print(A[i]+" ");
        }
    }
}
