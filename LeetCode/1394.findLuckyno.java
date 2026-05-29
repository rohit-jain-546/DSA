class Solution {
    //1394
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int ans = -1;

        for(int key : map.keySet()) {
            if(key == map.get(key)) {
                ans = Math.max(ans, key);
            }
        }

        return ans;
    }
}