public class Day21ReverseKGroupLists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tmp=head;
        ListNode prev=null;
        while(tmp!=null)
        {
            //find the kth node and need to reverse that k group 
            ListNode kthnode=findKthNode(tmp,k);
            if(kthnode==null)
            {
                if(prev!=null)
                prev.next=tmp;
                break;
            }
            //storing the next node from kth node for future connection and making next to null for reverse 
            ListNode futrnd=kthnode.next;
            kthnode.next=null;
            reverse(tmp);
            //for the first grpup of k node after reversing tmp and head will equal for making new head after reverse 
            //we make our new head as kthnode after reverse 
            if(tmp==head)
            {
                head=kthnode;
            }
            else
            {
                prev.next=kthnode;
            }
            prev=tmp;
            tmp=futrnd;

        }

        return head;
    }

    public ListNode reverse(ListNode root)
    {
        ListNode curr=root;
        ListNode prev=null;
        while(curr!=null)
        {
            ListNode forw=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forw;
        }

        return prev;
    }

    public ListNode findKthNode(ListNode head,int k)
    {
        ListNode tmp=head;
        int i=1;
        while(tmp!=null && i<k)
        {
            tmp=tmp.next;
            i++;
        }

        return tmp;
    }

}
