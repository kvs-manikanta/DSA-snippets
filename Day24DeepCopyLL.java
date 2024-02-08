
public class Day24DeepCopyLL {
    static class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head==null)
        {
            return null;
        }
        Node x=head;
        //making list similar node copy next to each nody 
        while(x!=null)
        {
            Node y=new Node(x.val);
            y.next=x.next;
            x.next=y;
            x=x.next.next;
        }

        //pointing the new node random pointers same like given random pointers 
        Node tmp=head;
        while(tmp!=null)
        {
            if(tmp.random==null)
            {
                tmp.next.random=null;
            }
            else
            tmp.next.random=tmp.random.next;
            tmp=tmp.next.next;
        }

        //Delinking the new inserted list between the given list 

        x=head;
        Node clonehead=head.next;
        Node y=clonehead;
        while(x!=null)
        {
            x.next=x.next.next;
            if(y.next!=null)
            {
                y.next=y.next.next;
            }
            
            x=x.next;
            y=y.next;
        }

        return clonehead;
    }
}
