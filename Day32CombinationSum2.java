import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day32CombinationSum2 {
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ansList=new ArrayList<>();
        List<Integer> lst=new ArrayList<>();
        Arrays.sort(candidates);
        GenerateAllCombinations(0,0,target,candidates,ansList,lst);
        return ansList;

    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void GenerateAllCombinations(int ind ,int sum ,int target ,int[] cand ,List<List<Integer>> ansList ,List<Integer> lst)
    {
        if(sum==target)
        {
            ansList.add(new ArrayList(lst));
            return ;
        }

        for(int i=ind;i<cand.length;i++)
        {
            if(i>ind && cand[i]==cand[i-1])
            {
                continue;
            } 
            if(cand[i]>target) break;
            if(sum<=target)
            {
                lst.add(cand[i]);
                GenerateAllCombinations(i+1,sum+cand[i],target,cand,ansList,lst);
                lst.remove(lst.size()-1);
            }
           
        }
    
    }
}