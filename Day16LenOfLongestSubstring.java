import java.util.HashMap;
import java.util.Map;

public class Day16LenOfLongestSubstring {
     public static int lengthOfLongestSubstring(String s) {
        int lft=0;
        int rgt=0;
        /*Set<Character> st=new HashSet<>();
        int maxlen=0;
        while(rgt < s.length())
        {
            if(!st.contains(s.charAt(rgt)))
            {
                st.add(s.charAt(rgt));
                maxlen=Math.max(maxlen,rgt-lft+1);
                rgt++;
            }
            else
            {
                st.remove(s.charAt(lft));
                lft++;
                
            }
            
        }
        return maxlen;
        */
        
        Map<Character,Integer> hm=new HashMap<>();
        int maxlen=0;
        while(rgt < s.length())
        {
            if(!hm.containsKey(s.charAt(rgt)) || hm.get(s.charAt(rgt)) < lft)
            {
                hm.put(s.charAt(rgt),rgt);
                maxlen=Math.max(maxlen,rgt-lft+1);
                rgt++;
            }
            else
            {
                lft=hm.get(s.charAt(rgt))+1;
                hm.put(s.charAt(rgt),rgt);
                rgt++;
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        String str="abcabcbb";
        int len=lengthOfLongestSubstring(str);

        System.out.println(len);
    }
    
}
