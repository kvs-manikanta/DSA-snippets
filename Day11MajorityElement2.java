import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day11MajorityElement2 {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
       /* HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            if(hm.containsKey(nums[i]))
            {
                hm.put(nums[i],hm.get(nums[i])+1);
            }
            else
            hm.put(nums[i],1);
        }

        for(int key : hm.keySet())
        {
            if(hm.get(key)>Math.floor((nums.length)/3))
            {
                ans.add(key);
            }
        }

        return ans;

        */
        
        int cnt1=0; int cand1=-1;
        int cnt2=0; int cand2=-1;

        for(int i=0;i<nums.length;i++)
        {
            if(cnt1==0 && cand2!=nums[i])
            {
                cnt1=1;
                cand1=nums[i];
            }
            else if(cnt2==0 && cand1!=nums[i])
            {
                cnt2=1;
                cand2=nums[i];
            }
            else if(cand1==nums[i]){cnt1++;}
            else if(cand2==nums[i]){cnt2++;}
            else{
                cnt1--; cnt2--;
            }
            
        }

        int cntr1=0;
        int cntr2=0;

        for(int i=0;i<nums.length;i++)
        {
            if(cand1==nums[i])
            {
                cntr1++;
            }
            else if(cand2==nums[i])
            {
                cntr2++;
            }
        }
        if(cntr1>(nums.length/3))
        {
            ans.add(cand1);
        }
        if(cntr2>(nums.length/3))
        {
            ans.add(cand2);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> res=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter length of array :");
        int A[]=new int[sc.nextInt()];
        System.out.println("Enter the values of array"+" ");
        for(int i=0;i<A.length;i++)
        {
            A[i]=sc.nextInt();
        }
        sc.close();

        res=majorityElement(A);
        System.out.println("Majority elements > (n/3) : ");
        for(int i=0;i<res.size();i++)
        {
            System.out.print(res.get(i)+" ");
        }

    }
}
