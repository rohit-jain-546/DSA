class Solution {
    public double myPow(double x, int n) {
        long l =n;
        if(l<0){
            l=-l;
            x=1/x;
        }
        double res=1;
        while(l>0){
            if((l%2)==1){
                res*=x;
            }
            x*=x;
            l/=2;
        }
        return res;
        
    }
}