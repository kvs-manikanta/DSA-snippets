import java.util.ArrayList;
import java.util.List;

public class Day31CombinationSum {
     public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        generateCombinationSum(0, 0, target, candidates, ansList, lst);
        return ansList;
    }

    public void generateCombinationSum(int ind, int sum, int target, int[] cand, List<List<Integer>> ansList, List<Integer> lst) {
        if (sum == target) {
            ansList.add(new ArrayList<>(lst));
            return;
        }
        if (ind == cand.length || sum > target) {
            return;
        }
        // Include current element
        lst.add(cand[ind]);
        generateCombinationSum(ind, sum + cand[ind], target, cand, ansList, lst);
        lst.remove(lst.size() - 1);
        // Exclude current element
        generateCombinationSum(ind + 1, sum, target, cand, ansList, lst);
    }
}
