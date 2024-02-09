public class Day19IntersectionOfLists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int cnt1=lengthOfList(headA);
        int cnt2=lengthOfList(headB);
        if(cnt1>cnt2)
        {
            int steps=cnt1-cnt2;
            for(int i=0;i<steps;i++)
            {
                headA=headA.next;
            }
        }
        else
        {
            int steps=cnt2-cnt1;
            for(int i=0;i<steps;i++)
            {
                headB=headB.next;
            }
        }
        ListNode currA=headA;
        ListNode currB=headB;

        while(currA!=null)
        {
            if(currA==currB)
            {
                return currA;
            }
            currA=currA.next;
            currB=currB.next;
        }

        return null;
    }

    public static int lengthOfList(ListNode root)
    {
        ListNode tmp=root;
        int cnt=0;
        while(tmp!=null)
        {
            cnt++;
            tmp=tmp.next;
        }
        return cnt;
    }
}
