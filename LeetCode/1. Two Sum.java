class Solution {
    public int[] twoSum(int[] nums, int target) {
    int n = nums.length;
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int r =0;r<n;r++){
        if(map.containsKey(target-nums[r])){
            int m = map.get(target-nums[r]);
            int [] a={m,r};
            return a;
        }else map.put(nums[r],r);
    }int[]a=new int[2]; return a ;     
    }
} 