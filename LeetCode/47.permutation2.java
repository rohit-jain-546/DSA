class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
         boolean[] visited = new boolean[nums.length];
       

        Arrays.sort(nums);
        backtrack(nums,0,res,visited);
        
        return res;
    }
    public void backtrack(int [] nums,int idx , List<List<Integer>> res,boolean[]visited){
        if(idx==nums.length){
            List<Integer>temp=new ArrayList<>();
            for(int i : nums){
                temp.add(i);
            }
            res.add(temp);
            return;
        }
        // HashSet<Integer>set=new HashSet<>();
        for (int i =idx;i<nums.length;i++){
            if(visited[i])continue;
           
            
            //set.add(nums[i]);
            while(i<nums.length && nums[i]==nums[i+1])continue;
            visited[i]=true;
            swap(nums,i,idx);
            backtrack(nums,idx+1,res,visited);

            
            swap(nums,i,idx);
        }
    }
    public void swap(int [] num , int i , int j){
        int t = num[i];
        num[i]=num[j];
        num[j]=t;
    }
}
    