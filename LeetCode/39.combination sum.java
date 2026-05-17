class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr =  new ArrayList<>();
        bactrack(0,candidates,res,curr,target);
        return res;

    }
    void bactrack(int idx, int [] ar, List<List<Integer>> res,List<Integer> curr,int target){
        if(idx==ar.length||target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(ar[idx]);
        bactrack(idx,ar,res,curr,target-ar[idx]);
        curr.remove(curr.size()-1);
        bactrack(idx+1,ar,res,curr,target);


    }
}