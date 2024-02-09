import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day25ThreeSum {
        public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ansList=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(i>0 && nums[i]==nums[i-1]){continue;}

            int j=i+1;
            int k=n-1;
            while(j<k)
            {
                int sum=0;
                sum+=nums[i];
                sum+=nums[j];
                sum+=nums[k];
                if(sum==0)
                {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[i]);
                    tmpList.add(nums[j]);
                    tmpList.add(nums[k]);
                    ansList.add(tmpList);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1])j++;
                    while(j<k && nums[k]==nums[k+1])k--;

                }
                else if(sum>0)
                {
                    k--;
                }
                else
                {
                    j++;
                }
            }
        }

        return ansList;
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
        
        List<List<Integer>> result=threeSum(A);

        for(int i=0;i<result.size();i++)
        {
            System.out.println(result.get(i));
        }
    }
}
