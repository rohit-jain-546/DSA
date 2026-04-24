class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i =0,j=0,sum=0,minl=Integer.MAX_VALUE,n=nums.length;
        while(j<n){
            sum+=nums[j];
            while(sum>=target){
                minl=Math.min(minl,j-i+1);
                sum=sum-nums[i];
                i++;
            }
            j++;
        }
        if(minl==Integer.MAX_VALUE){
            return 0;
        }
        else return minl;
    }
}