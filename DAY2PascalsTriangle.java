import java.util.ArrayList;
import java.util.List;

public class DAY2PascalsTriangle {
     public static List<List<Integer>> generate(int numRows) {
        int row=numRows;
        List<List<Integer>> anslst=new ArrayList<>();
        for(int i=1;i<=row;i++)
        {
            //going through the each row and generating the each of pascals triangle 
            anslst.add(generateRow(i,new ArrayList()));

        }

        return anslst;
    }

    public static List<Integer> generateRow(int r, List<Integer> lst)
    {
        /*4rd row -- 1  3  3  1 ---> 
        we are going from 1st col to the n-2 col for genarating the values 
        observing the the pattern can get the formula below */
        int val=1;
        lst.add(val);
        for(int i=1;i<r;i++)
        {
            val=val*(r-i);
            val=val/i;
            lst.add(val);
        }

        return lst;
    }

    public static void main(String[] args) {
        
        List<List<Integer>> ans=generate(5);
        
        for(int i=0;i<ans.size();i++)
        {
            for(int j=0;j<ans.get(i).size();j++)
            {
                System.out.print(ans.get(i).get(j)+" ");
            }
            System.out.println();
        }


    }
}
