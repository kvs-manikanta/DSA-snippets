public class Day17MergeSortedLists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode head=null;
        ListNode tmp=null;
        if (A == null) {
            return B;
        }

        if (B == null) {
            return A;
        }
        if(A.val<=B.val)
        {
            head=A; tmp=A; A=A.next;
        }
        else
        {
            head=B; tmp=B ; B=B.next;
        }

        while(A!=null && B!=null)
        {
            if(A.val<=B.val)
            {
                tmp.next=A;
                A=A.next;
                tmp=tmp.next;
            }
            else
            {
                tmp.next=B;
                B=B.next;
                tmp=tmp.next;
            }
        }
        while(A!=null)
        {
            tmp.next=A;
            A=A.next;
            tmp=tmp.next;
        }
        while(B!=null)
        {
            tmp.next=B;
            B=B.next;
            tmp=tmp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(5)));
        ListNode head1 = new ListNode(1, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(5)))));
        

        // Finding the middle node of the linked list
        Day17MergeSortedLists solution = new Day17MergeSortedLists();
        ListNode rootnode = solution.mergeTwoLists(head,head1);

        System.out.println("sorted merged Linked List:");
        printList(rootnode);
    }

    // Helper method to print the linked list
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    
}
