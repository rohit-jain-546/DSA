class Solution{
    public int numDistinct(String s,String t){
        if(s.length()<t.length()) return 0;
        char[] sc=s.toCharArray(),tc=t.toCharArray();
        int[] dp=new int[tc.length+1];
        dp[0]=1;
        for(int i=0;i<sc.length;i++)
            for(int j=tc.length;j>0;j--)
                if(sc[i]==tc[j-1]) dp[j]+=dp[j-1];
        return dp[tc.length];
    }
}