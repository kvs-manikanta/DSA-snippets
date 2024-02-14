import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day30Subset2 {
    class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ansSubset=new ArrayList<>();
        List<Integer> lst=new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets(0,nums.length,nums,lst,ansSubset);
        return ansSubset;
    }

    public void generateSubsets(int ind, int n, int nums[],List<Integer> lst, List<List<Integer>> ans)
    {
        if(ind==n)
        {
            if(!ans.contains(lst))
            {
                ans.add(new ArrayList<Integer>(lst));
            }
            return;
        }

        lst.add(nums[ind]);
        generateSubsets(ind+1,n,nums,lst,ans);
        lst.remove(lst.size()-1);
        /*while(ind+1<n && nums[i]==nums[i+1])
        {
            ind+=1;
        }
        */
        generateSubsets(ind+1,n,nums,lst,ans);
    }
}
}
