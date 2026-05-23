class Solution {
    public int[] leftRightDifference(int[] nums) {
        int total=0;

        for(int n:nums) total+=n;

        int left=0;
        int[] ans=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            total-=nums[i];
            ans[i]=Math.abs(left-total);
            left+=nums[i];
        }

        return ans;
    }
}