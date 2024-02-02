public class Day18NthNodeOfList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp=head;
        int cnt=0;
        while(tmp!=null)
        {
            cnt++;
            tmp=tmp.next;
        }

        if(cnt==1)
        {
            return head.next;
        }
        ListNode head1=head;
        if(n>=cnt)
        {
            head=head1.next;
            return head;
        }
        ListNode curr=head;
        for(int i=0;i<cnt-n-1;i++)
        {
            curr=curr.next;
        }
        curr.next=curr.next.next;
        return head;
    }

    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        System.out.println("Original Linked List:");
        printList(head);

        // Reversing the linked list
        Day18NthNodeOfList solution = new Day18NthNodeOfList();
        ListNode reversedHead = solution.removeNthFromEnd(head,2);

        System.out.println("Reversed Linked List:");
        printList(reversedHead);
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
