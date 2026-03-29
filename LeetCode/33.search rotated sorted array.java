class Solution {
    public int search(int[] nums, int target) {
        int pv =piv(nums,0,nums.length-1);
        if(pv==-1) return bin(nums,0,nums.length-1,target);
        if(nums[pv]==target) return pv;
        if(target>=nums[0]) return bin(nums,0,pv-1,target);
        else  return bin(nums,pv+1,nums.length-1,target); 
    }
    static int  bin(int[] nums,int s, int e, int tar){
        while(s<=e){
            int mid = s+(e-s)/2;
            if(nums[mid]==tar) return mid;
            if(tar<nums[mid]) e=mid-1;
            else s= mid+1;
        }
        return -1;
    }
    static int piv(int[] nums,int s,int e){
        while(s<=e){
            int mid = s+(e-s)/2;
            if(mid<e && nums[mid]>nums[mid+1]) return mid;
            if(mid>s && nums[mid]<nums[mid-1]) return mid-1;
            if(nums[mid]<=nums[s]) e=mid-1;
            else s=mid+1;
        }
        return -1;
    }
}