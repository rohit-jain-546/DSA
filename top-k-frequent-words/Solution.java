class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String,Integer> map = new HashMap<>();
        for(String w : words){
            map.put(w,map.getOrDefault(w,0)+1);
        }


        PriorityQueue <Map.Entry<String,Integer>>heap= new PriorityQueue<>((a,b)->{
            if(!a.getValue().equals(b.getValue()))
            return a.getValue()-b.getValue();
            return b.getKey().compareTo(a.getKey());
        });
        for(Map.Entry<String, Integer> entry:map.entrySet()){
            heap.offer(entry);
            if(heap.size()>k){
                heap.poll();
            }
        }
        List<String> res =new ArrayList<>();
       int i =0;
       while(!heap.isEmpty()){
        res.add(heap.poll().getKey());

       }
       Collections.reverse(res);
       return res;
        

    }
}