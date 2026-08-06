class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int pd =1,num=n;
            while(num>0){
                pd*=num%10;
                num/=10;
            }
            if(pd%t==0){
                return n;
            }
            n++;
        }
    }
}