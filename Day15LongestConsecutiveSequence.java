import java.util.Arrays;
import java.util.Scanner;

public class Day15LongestConsecutiveSequence {
     public static int longestConsecutive(int[] nums) {
        /*HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            hs.add(nums[i]);
        }

        int ans=0;

        for(int i=0;i<nums.length;i++)
        {
            int ele=nums[i];
            if(!hs.contains(ele-1))
            {
                int cnt=0;
                while(hs.contains(ele))
                {
                    cnt++;
                    ele=ele+1;
                }
                ans=Math.max(ans,cnt);
            }  
        }
        return ans;
        */
        if(nums.length==0)
        {
            return 0;
        }
        Arrays.sort(nums);
        int lastSmaller = nums[0];
        int count = 1;
        int maxLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == lastSmaller + 1) {
                count++;
                lastSmaller = nums[i];
            } else if (nums[i] != lastSmaller) {
                count = 1;
                lastSmaller = nums[i];
            }
            
            maxLength = Math.max(maxLength, count);
        }
        
        return maxLength;
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
        int maxseq=longestConsecutive(A);

        System.out.println(maxseq);
    }
}
