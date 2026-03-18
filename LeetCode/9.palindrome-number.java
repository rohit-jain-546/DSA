class Solution {
    public boolean isPalindrome(int x) {
         if (x<0)
        return false;
        if(x!=0&&x%10==0)
        return false;
        int s=0;
        int t=x;
        int u=x;
        if (x<=Integer.MIN_VALUE||x>=Integer.MAX_VALUE)
        return false;
        while(x!=0){
            s++;
            x/=10;
        }
        int d=0;
        
        while(t!=0){
            d += (t%10)*(Math.pow(10,(s-1)));
            t/=10;
            s--;
        }
        if (d<=Integer.MIN_VALUE||d>=Integer.MAX_VALUE)
        return false;
        if (d==u)
        return true;
        else
        return false;

    }
}