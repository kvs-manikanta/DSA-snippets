

public class Day23FlattenTheLL 
{
    static class Node
    {
            int data;
            Node next;  
            Node bottom;
            
            Node(int d)
            {
                data = d;
                next = null;
                bottom = null;
            }
    }
    /*Function which returns the  root of 
    the flattened linked list. */
    public static Node flatten(Node root)
    {
	// Your code here
	    return verticalMerge(root);
    }
    
    public static Node verticalMerge(Node root)
    {
        if(root==null || root.next==null)
        {
            return root;
        }
        Node mergedhead=verticalMerge(root.next);
        return mergeVerticalLists(root,mergedhead);
    }
    
    public static  Node mergeVerticalLists(Node A,Node B)
    {
        Node dummy=new Node(-1);
        Node tmp=dummy;
        while(A!=null && B!=null)
        {
            if(A.data<=B.data)
            {
                tmp.bottom=A;
                tmp=A;
                A=A.bottom;
            }
            else
            {
                tmp.bottom=B;
                tmp=B;
                B=B.bottom;
            }
        }
        if(A!=null)
        {
            tmp.bottom=A;
        }
        if(B!=null)
        {
            tmp.bottom=B;
        }
        
        return dummy.bottom;
        
    }
}
