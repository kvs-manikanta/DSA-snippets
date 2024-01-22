

public class Day8MergeSort1 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1;
        int p2=n-1;
        int p3=m+n-1;

        while(p1>=0 && p2>=0)
        {
            if(nums1[p1]<=nums2[p2])
            {
                nums1[p3]=nums2[p2];
                p3--; p2--;
            }
            else
            {
                nums1[p3]=nums1[p1];
                p3--; p1--;
            }
        }
        while(p2>=0)
        {
            nums1[p3]=nums2[p2];
            p3--; p2--;
        }
        
    }

    public static void main(String[] args) {
        int A[]=new int[]{4,0,0,0,0,0};
        int B[]=new int[]{1,2,3,5,6};

        merge(A,1,B,B.length);
        for(int i=0;i<A.length;i++)
        {
            System.out.print(A[i]+" ");
        }
    }
    
}
