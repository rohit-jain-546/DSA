class Solution {
    public boolean isUgly(int n) {
         if (n<=Integer. MIN_VALUE||n>=Integer. MAX_VALUE)
        return false;
        int s = 1;
        int t =n;
        while (n!=0&&(n%2==0||n%3==0||n%5==0)){
           while (n%2==0){
            s*=2;
            n/=2;

           }
            while (n%3==0){
            s*=3;
            n/=3;

           }
            while (n%5==0){
            s*=5;
            n/=5;

           } 
        }if(t==s)
        return true;
        else
        return false;
    }
}