public class Day9InversionPairsCount {
    public static long getInversions(long arr[], int n) {
        // Write your code here.
        long s=0;
        long e=arr.length-1;
        long pairs=inversionMerge(arr,s,e);

        return pairs;
    }

    public static long inversionMerge(long A[],long s , long e )
    {
        if(s==e)
        {
            return 0;
        }
        long mid=(s+e)/2;
        long leftcnt=inversionMerge(A,s,mid);
        long rightcnt=inversionMerge(A,mid+1,e);
        long implicitcnt=mergeArray(A,s,mid,e);

        return leftcnt+rightcnt+implicitcnt;
    }

    public static long mergeArray(long A[],long s , long m , long e)
    {
        long p1=s;
        long p2=m+1;
        long p3=0;
        long temp[]=new long[(int)(e-s+1)];
        long cnt=0;

        while(p1<=m && p2<=e)
        {
            if(A[(int)p1]<=A[(int)p2])
            {
                temp[(int)p3]=A[(int)p1];
                p1++;
                p3++;
            }
            else
            {
                temp[(int)p3]=A[(int)p2];
                cnt+=m-p1+1;
                p3++;
                p2++;
            }
        }
        while(p1<=m)
        {
            temp[(int)p3]=A[(int)p1];
            p1++;
            p3++;
        }
        while(p2<=e)
        {
            temp[(int)p3]=A[(int)p2];
            p2++;
            p3++;
        }

        for(int i=0;i<=e-s;i++)
        {
            A[(int)(s+i)]=temp[i];
        }

        return cnt;

    }

    public static void main(String[] args) {
        long A[]=new long[]{5,2,1,3,4};
        long prs=getInversions(A, A.length);

        System.out.println("Total inversion paris of array are :"+prs);
    }
}
