class Solution {
    public long sumAndMultiply(int n) {
        if (n==0)return 0;
        int temp = n;
        int sum =0;
        
        StringBuilder sb = new StringBuilder();
        while(temp!=0){
            int t = temp%10;
            if(t!=0){
                sum+=t;
                sb.append(t);
            }
            temp/=10;

        }
        sb.reverse();
        long ans=0;
        for(int i =0;i<sb.length();i++){
            int dig = sb.charAt(i)-'0';
            ans=ans*10+dig;

        }

        return ans*sum;
    }
}