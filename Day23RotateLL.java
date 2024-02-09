public class Day23RotateLL {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0)
        {
            return head;
        }
        int len=findLenghtLL(head);
        k=k%len;
        if(k==0)
        {
            return head;
        }
        ListNode sp=head;
        ListNode fp=head;
        for(int i=0;i<k;i++)
        {
            fp=fp.next;
        }
        while(fp.next!=null)
        {
            sp=sp.next;
            fp=fp.next;
        }
        fp.next=head;
        head=sp.next;
        sp.next=null;

        return head;
        
    }

    public int findLenghtLL(ListNode root)
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
