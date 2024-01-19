
public class DAY4MaxSubarraySum {
    public static int maxSubArray(int[] nums) {
        //kadane's algorithm we can get the max sum of a sub array 
        long maxsum=Integer.MIN_VALUE;
        long sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            maxsum=Math.max(maxsum,sum);
            if(sum<0)
            {
                sum=0;
            }
        }
        return (int)maxsum;
    }

    public static void main(String[] args) {
        int A[]=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int tsum=maxSubArray(A);

        System.out.println(tsum);
    }
    
}
