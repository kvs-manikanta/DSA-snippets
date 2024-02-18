import java.util.ArrayList;
import java.util.List;

public class Day33PalindromePartitions {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> lst=new ArrayList<>();
        generatePartitions(0,s,res,lst);

        return res;
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void generatePartitions(int ind, String s, List<List<String>> res, List<String> lst)
    {
        if(ind==s.length())
        {
            res.add(new ArrayList(lst));
            return ;
        }

        for(int i=ind;i<s.length();i++)
        {
            if(isPalindrome(s,ind,i))
            {
                lst.add(s.substring(ind,i+1));
                generatePartitions(i+1,s,res,lst);
                lst.remove(lst.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s , int st , int ed)
    {
        while(st<=ed)
        {
            if(s.charAt(st)!=s.charAt(ed))
            {
                return false;
            }
            st++;
            ed--;
        }

        return true;
    }
}
