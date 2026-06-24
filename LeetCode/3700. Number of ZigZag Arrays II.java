class Solution{
    static final long MOD=1000000007L;

    public int zigZagArrays(int n,int l,int r){
        int m=r-l+1;
        int sz=2*m;

        long[][] mat=new long[sz][sz];

        for(int i=0;i<m;i++){
            for(int j=0;j<i;j++)mat[i][m+j]=1;
            for(int j=i+1;j<m;j++)mat[m+i][j]=1;
        }

        long[] state=new long[sz];

        for(int i=0;i<m;i++){
            state[i]=i;
            state[m+i]=m-1-i;
        }

        long p=n-2;

        while(p>0){
            if((p&1)==1)state=multiply(mat,state);
            mat=multiply(mat,mat);
            p>>=1;
        }

        long ans=0;
        for(long x:state)ans=(ans+x)%MOD;

        return(int)ans;
    }

    private long[] multiply(long[][] a,long[] v){
        int n=a.length;
        long[] res=new long[n];

        for(int i=0;i<n;i++){
            long cur=0;
            for(int j=0;j<n;j++){
                if(a[i][j]!=0)cur=(cur+a[i][j]*v[j])%MOD;
            }
            res[i]=cur;
        }

        return res;
    }

    private long[][] multiply(long[][] a,long[][] b){
        int n=a.length;
        long[][] res=new long[n][n];

        for(int i=0;i<n;i++){
            for(int k=0;k<n;k++){
                if(a[i][k]==0)continue;

                long val=a[i][k];

                for(int j=0;j<n;j++){
                    if(b[k][j]==0)continue;
                    res[i][j]=(res[i][j]+val*b[k][j])%MOD;
                }
            }
        }

        return res;
    }
}