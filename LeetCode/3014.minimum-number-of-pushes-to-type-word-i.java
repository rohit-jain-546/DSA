class Solution {
    public int minimumPushes(String word) {
        int l = word.length();
        int ans=0;
        while(l>0){
            if(l<=8){
                
                ans+=l;
                l=0;
                break;
            }
            if(l<=16){
                ans+=(l-8)*2;
                l-=(l-8);
                continue;
            }
            if(l<=24){
                ans+=(l-16)*3;
                l-=(l-16);
                continue;
            }
            if(l<=26){
                ans+=(l-24)*4;
                l-=(l-24);
                continue;
            }

        }
        return ans;
    }
}