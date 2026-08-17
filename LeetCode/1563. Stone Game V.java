class Solution {

    int[][] dp;
    int[] sum;

    int solve(int l, int r) {

        if(l==r)
            return 0;

        if(dp[l][r]!=-1)
            return dp[l][r];

        int ans=0;

        for(int k=l;k<r;k++){

            int left=sum[k+1]-sum[l];
            int right=sum[r+1]-sum[k+1];

            if(left<right){

                int x=left+solve(l,k);

                if(x>ans)
                    ans=x;

            }
            else if(right<left){

                int x=right+solve(k+1,r);

                if(x>ans)
                    ans=x;

            }
            else{

                int x1=left+solve(l,k);
                int x2=right+solve(k+1,r);

                ans=Math.max(ans,Math.max(x1,x2));
            }
        }

        dp[l][r]=ans;
        return ans;
    }

    public int stoneGameV(int[] stoneValue) {

        int n=stoneValue.length;

        sum=new int[n+1];

        for(int i=0;i<n;i++)
            sum[i+1]=sum[i]+stoneValue[i];

        dp=new int[n][n];

        for(int i=0;i<n;i++)
            java.util.Arrays.fill(dp[i],-1);

        return solve(0,n-1);
    }
}