
class Solution{
    private static final long MOD=1000000007L;

    public int zigZagArrays(int n,int l,int r){
        int m=r-l+1;

        if(n==1)return m;

        long[] up=new long[m];
        long[] down=new long[m];

        for(int i=0;i<m;i++){
            up[i]=i;
            down[i]=m-1-i;
        }

        if(n==2){
            long ans=0;
            for(int i=0;i<m;i++){
                ans=(ans+up[i]+down[i])%MOD;
            }
            return(int)ans;
        }

        for(int len=3;len<=n;len++){
            long[] newUp=new long[m];
            long[] newDown=new long[m];

            long pref=0;
            for(int i=0;i<m;i++){
                newUp[i]=pref;
                pref=(pref+down[i])%MOD;
            }

            long suff=0;
            for(int i=m-1;i>=0;i--){
                newDown[i]=suff;
                suff=(suff+up[i])%MOD;
            }

            up=newUp;
            down=newDown;
        }

        long ans=0;
        for(int i=0;i<m;i++){
            ans=(ans+up[i]+down[i])%MOD;
        }

        return(int)ans;
    }
}

