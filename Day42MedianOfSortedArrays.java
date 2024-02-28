public class Day42MedianOfSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length<nums1.length)
        {
            return findMedianSortedArrays(nums2,nums1);
        }
        int n1=nums1.length;
        int n2=nums2.length;
        int lo=0;
        int hi=nums1.length;

        //BS and pick the ele from arr1 and remaining from arr2 for left side 

        while(lo<=hi)
        {
            int mid=lo+(hi-lo)/2;
            int firsthalf=(nums1.length+nums2.length+1)/2;

            int cut1=mid;
            int cut2=firsthalf-mid;

            int l1,l2,r1,r2;
            //assume all ele from arr2 then assign l1 to -infinity 
            if(cut1==0)
            {
                l1=Integer.MIN_VALUE;
            }
            else
            {
                l1=nums1[cut1-1];
            }
            //assume all ele from arr1 then assign l2= -infinity 
            if(cut2==0)
            {
                l2=Integer.MIN_VALUE;
            }
            else
            {
                l2=nums2[cut2-1];
            }
            
            //assume all ele from r2 then assign to +infi
            if(cut1==nums1.length)
            {
                r1=Integer.MAX_VALUE;
            }
            else
            {
                r1=nums1[cut1];
            }
            //assume all ele from r1 then assign to +infi
            if(cut2==nums2.length)
            {
                r2=Integer.MAX_VALUE;
            }
            else
            {
                r2=nums2[cut2];
            }

            if(l1<=r2 && l2<=r1)
            {
                if((n1+n2)%2==0)
                {
                    return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
                else
                {
                    return (double)Math.max(l1,l2);
                }
            }
            else if(l1>r2)
            {
                hi=mid-1;
            }
            else
            {
                lo=mid+1;
            }
        } 
        return 0.0;
    }
}
