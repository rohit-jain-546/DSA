class Solution {
    public int reverse(int x) {
         if(x<=Integer.MIN_VALUE||x>=Integer.MAX_VALUE)
        return 0;
        int s = 0;
        int t=x;
        while(x!=0){
            s++;
            x/=10;
        }
        int d = 0;   
        while(t!=0){
            d += (t%10) *( Math.pow(10,(s-1)));
            t/=10;
            s--;
        }if(d<=Integer.MIN_VALUE||d>=Integer.MAX_VALUE)
        return 0;
       return d;

    }
}