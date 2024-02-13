import java.util.ArrayList;
import java.util.Collections;

public class Day29SumSubset {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> ansSubset=new ArrayList<>();
        SumSubset(0 , 0 , arr , N , ansSubset);
        Collections.sort(ansSubset);
        
        return ansSubset;
    }
    public void SumSubset(int ind , int sum , ArrayList<Integer> arr ,int N, ArrayList<Integer> ansSubset)
    {
        if(N==ind)
        {
            ansSubset.add(sum);
            return;
        }
        //pick element
        SumSubset(ind+1,sum+arr.get(ind),arr,N,ansSubset);
        
        //skip the element
        SumSubset(ind+1,sum,arr,N,ansSubset);
    }
}
