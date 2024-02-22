public class Day39SingleElement {
        public int singleNonDuplicate(int[] nums) {
            int n = nums.length;
            
            if (n == 1) {
                return nums[0];
            }
            
            if (nums[0] != nums[1]) {
                return nums[0];
            }
            
            if (nums[n - 2] != nums[n - 1]) {
                return nums[n - 1];
            }
    
            int low = 0, high = n - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                
                if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || 
                    (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                    low = mid + 1;
                } else if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                    return nums[mid];
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
    
}
