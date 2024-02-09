public class Day20DetectCycle {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode sp=head;
            ListNode fp=head;
    
            while(fp!=null && fp.next!=null)
            {
                fp=fp.next.next;
                sp=sp.next;
                if(sp==fp)
                {
                    return true;
                }
            }
    
            return false;
        }
    }
}
