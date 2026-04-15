class Solution {
    public int maxProfit(int[] prices) {
        int mp=Integer.MAX_VALUE;
        int prof=0;
        for(int p:prices){
            if(p<mp){
                mp=p;
            }
            else{
                prof=Math.max(prof,p-mp);
            }
            
        }
        return prof;
        
        
    }
}