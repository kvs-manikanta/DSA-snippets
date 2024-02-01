public class Day17MiddleOfList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode sp = head;
        ListNode fp = head;
        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }
        return sp;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Original Linked List:");
        printList(head);

        // Finding the middle node of the linked list
        Day17MiddleOfList solution = new Day17MiddleOfList();
        ListNode midnode = solution.middleNode(head);

        System.out.println("Middle Node of the Linked List:");
        printList(midnode);
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
