public class Day41MedianInMatrix {
    public static int findMedian(int matrix[][], int m, int n) {
        // Write your code here

        int lo=Integer.MAX_VALUE;
        int hi=Integer.MIN_VALUE;

        for(int i=0;i<m;i++)
        {
            lo=Math.min(lo,matrix[i][0]);
            hi=Math.max(hi,matrix[i][n-1]);
        }

        int req=(m*n)/2;
        while(lo<=hi)
        {
            int mid=lo+(hi-lo)/2;

            int smallequ=countSmallEle(matrix,m,n,mid);

            if(smallequ<=req)
            {
                lo=mid+1;
            }
            else
            {
                hi=mid-1;
            }
        }

        return lo;
    }

    public static int countSmallEle(int matrix[][], int m, int n,int mid)
    {
        int cnt=0;
        for(int i=0;i<m;i++)
        {
            cnt+=upperValueOfMid(matrix[i],n,mid);

        }
        return cnt;
    }

    public static int upperValueOfMid(int mat[], int n, int peak) {
        int lo = 0;
        int hi = mat.length - 1;
        int ans = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(mat[mid]>peak)
            {
                ans=mid;
                hi=mid-1;
            }
            else
            {
                lo=mid+1;
            }
        }

        return ans ; 
    }
}
