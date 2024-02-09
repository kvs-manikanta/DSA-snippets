public class Day22PalindromeLL {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean isPalindrome(ListNode A) {
        ListNode sp=A;
        ListNode fp=A;
        while(fp.next!=null && fp.next.next!=null)
        {
            sp=sp.next;
            fp=fp.next.next;
        }

        ListNode revhead=reverseLL(sp.next);
        ListNode head=A;
        while(revhead!=null)
        {
            if(head.val!=revhead.val)
            {
                return false;
            }
            else
            {
                head=head.next;
                revhead=revhead.next;
            }
        }

        return true;
    }
    public ListNode reverseLL(ListNode sp)
    {
        ListNode curr=sp;
        ListNode prev=null;
        while(curr!=null)
        {
            ListNode fut=curr.next;
            curr.next=prev;
            prev=curr;
            curr=fut;
        }

        return prev;
    }
}
