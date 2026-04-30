class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> ar= new ArrayList<>();
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i =0; i<nums.length;i++){
            if(hs.containsKey(nums[i])){
                hs.put(nums[i],hs.get(nums[i])+1);
            }
            else hs.put(nums[i],1);
        }
        for(int i:hs.keySet()){
            if(hs.get(i)>nums.length/3){
                ar.add(i);
            }
        }
        return ar;
    }
}