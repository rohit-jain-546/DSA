class Solution {
    public int[] searchRange(int[] nums, int target) {
        int []ar={-1,-1}; int n = nums.length;  
        if(n==0) return ar;
        int left = 0,right = n - 1,k=0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > nums[mid]) 
                left = mid + 1;
            else  
                right = mid - 1;  
        }
        if (left >= n || nums[left] != target) 
            return ar;

       ar[0]=left;
       right=n-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target >= nums[mid]) 
                left = mid + 1;
            else  
                right = mid - 1;  
        }ar[1]=right;return ar;

    }
}