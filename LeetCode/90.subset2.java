class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0,nums,new ArrayList<>(),result);
        return result;

    }
    public void backtrack(int start , int nums[] , List<Integer> curr ,List<List<Integer>> res){
        if(start==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[start]);
        backtrack(start+1,nums,curr,res);
        curr.remove(curr.size()-1);
        int idx =start+1;
        while(idx<nums.length && nums[idx]==nums[idx-1])idx++;
        backtrack(idx,nums,curr,res);

    }
} 
