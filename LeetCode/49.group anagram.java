class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap <String,List<String>> map = new HashMap<>();
        for(String w : strs){
            char [] c = w.toCharArray();
            Arrays.sort(c);
            String k = new String (c);
            if(!map.containsKey(k)){
                map.put(k,new ArrayList<>());
            }
            map.get(k).add(w);
        }return new ArrayList<>(map.values());
    }
}