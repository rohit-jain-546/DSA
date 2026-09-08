class Solution {
    public int countCommas(int n) {
        long c=0,p=1000;
        for(;n>=p;p*=1000)c+=n-p+1;
        return (int)c;
    }
}