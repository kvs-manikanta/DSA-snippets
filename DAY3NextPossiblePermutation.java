public class DAY3NextPossiblePermutation {
    public static void nextPermutation(int[] nums) {
        //get the next longest prefix match from right and break and store the index 
        int ind=-1;
        int n=nums.length;
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                ind=i;
                break;
            }
        }
        //if we didnt find any break point that means this last permutaion of given nums so we  
        //reverse the array and return 
        if(ind==-1)
        {
            reverse(nums,0,n-1);
            return ;
        }
        //once we find the ind of break point we swap it with the next greater ele inoder to get     
        //the next permutation 
        for(int i=n-1;i>ind;i--)
        {
            if(nums[i]>nums[ind])
            {
                int temp=nums[i];
                nums[i]=nums[ind];
                nums[ind]=temp;
                break;
            }
        }
        //and reverse the array on ele which remains on its right to get the next permutaion 
        reverse(nums,ind+1,n-1);

    }

    public static void reverse(int[] A, int s, int e)
    {
        while(s<e)
        {
            int temp=A[e];
            A[e]=A[s];
            A[s]=temp;

            s++;
            e--;
        }
    }

    public static void main(String[] args) {
        int A[]=new int[]{1,2,4,3,5};
        nextPermutation(A);

        for(int i=0;i<A.length;i++)
        {
            System.out.print(A[i]+" ");
        }
    }
}
