class Solution {
    public int maximumProduct(int[] nums) {
       Arrays.sort(nums);
       int k=nums.length;
       int ans= nums[k-1]*nums[k-2]*nums[k-3];
       int ans2= nums[0]*nums[1]*nums[k-1];

       

       return Math.max(ans,ans2);
        
    }
}