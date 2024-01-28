import java.util.Scanner;

public class Day13RversePairs {
    
        public static int reversePairs(int[] nums) {
            return merge(nums, 0, nums.length - 1);
        }
    
        public static int merge(int A[], int s, int e) {
            if (s >= e) {
                return 0;
            }
            long mid = ((long) s + e) / 2;
    
            long lftcnt = merge(A, s, (int) mid);
            long rgtcnt = merge(A, (int) mid + 1, e);
            long cnt = countReversePairs(A, s, (int) mid, e);
            mergesort(A, s, (int) mid, e);
    
            return (int)(lftcnt + rgtcnt + cnt);
        }
    
        // performs the merging here
        public static void mergesort(int A[], int s, int mid, int e) {
            int temp[] = new int[e - s + 1];
            int p1 = s;
            int p2 = mid + 1;
            int p3 = 0;
    
            while (p1 <= mid && p2 <= e) {
                if (A[p1] <= A[p2]) {
                    temp[p3] = A[p1];
                    p3++;
                    p1++;
                } else {
                    temp[p3] = A[p2];
                    p3++;
                    p2++;
                }
            }
            while (p1 <= mid) {
                temp[p3] = A[p1];
                p1++;
                p3++;
            }
            while (p2 <= e) {
                temp[p3] = A[p2];
                p2++;
                p3++;
            }
    
            for (int i = 0; i <= e - s; i++) {
                A[i + s] = temp[i];
            }
        }
    
        public static long countReversePairs(int A[], int s, int mid, int e) {
            // compare left array to right for every A[i] > 2 * A[j] increase count
            int p1 = mid + 1;
            long cnt = 0;
            for (int i = s; i <= mid; i++) {
                while (p1 <= e && ((long) A[i] > (long) A[p1] * 2)) {
                    p1++;
                }
                cnt += p1 - (mid + 1);
            }
            return cnt;
        }
    
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter length of array :");
        int A[]=new int[sc.nextInt()];
        System.out.println("Enter the values of array"+" ");
        for(int i=0;i<A.length;i++)
        {
            A[i]=sc.nextInt();
        }
        sc.close();

        int pairs=reversePairs(A);
        
        System.out.println("No of pairs is :"+pairs);
    }
}
