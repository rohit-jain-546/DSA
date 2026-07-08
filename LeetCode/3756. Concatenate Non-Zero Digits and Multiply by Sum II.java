class Solution {
    static final int MOD=1000000007;

    public int[] sumAndMultiply(String s,int[][] queries) {
        int n=s.length();

        long[] hash=new long[n+1];
        long[] pow10=new long[n+1];
        int[] count=new int[n+1];
        int[] sum=new int[n+1];

        pow10[0]=1;
        for(int i=1;i<=n;i++)
            pow10[i]=(pow10[i-1]*10)%MOD;

        for(int i=0;i<n;i++){
            hash[i+1]=hash[i];
            count[i+1]=count[i];
            sum[i+1]=sum[i];

            char ch=s.charAt(i);
            if(ch!='0'){
                int digit=ch-'0';
                hash[i+1]=(hash[i]*10+digit)%MOD;
                count[i+1]=count[i]+1;
                sum[i+1]=sum[i]+digit;
            }
        }

        int[] ans=new int[queries.length];

        for(int i=0;i<queries.length;i++){
            int l=queries[i][0];
            int r=queries[i][1];

            int digits=count[r+1]-count[l];
            int digitSum=sum[r+1]-sum[l];

            long x=(hash[r+1]-(hash[l]*pow10[digits])%MOD+MOD)%MOD;
            ans[i]=(int)((x*digitSum)%MOD);
        }

        return ans;
    }
}