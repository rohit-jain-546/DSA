class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums,0,res);
        return res;
    }
    public void backtrack(int [] nums,int idx , List<List<Integer>> res){
        if(idx==nums.length){
            List<Integer>temp=new ArrayList<>();
            for(int i : nums){
                temp.add(i);
            }
            res.add(temp);
            return;
        }
        for (int i =idx;i<nums.length;i++){
            swap(nums,i,idx);
            backtrack(nums,idx+1,res);
            swap(nums,i,idx);
        }
    }
    public void swap(int [] num , int i , int j){
        int t = num[i];
        num[i]=num[j];
        num[j]=t;
    }
}