class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int mn=0,mx=0;

        for(int i=1;i<n;i++){
            if(nums[i]<nums[mn]) mn=i;
            if(nums[i]>nums[mx]) mx=i;
        }

        int a=Math.min(mn,mx);
        int b=Math.max(mn,mx);

        int x=b+1;
        int y=n-a;
        int z=a+1+n-b;

        return Math.min(x,Math.min(y,z));
    }
}