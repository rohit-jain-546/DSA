class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] sorted = new int[n][2];

        for(int i=0;i<n;i++){
            sorted[i][0]=nums[i];
            sorted[i][1]=i;
        }

        Arrays.sort(sorted,(a,b)->a[0]-b[0]);

        int[] pos=new int[n];
        int[] group=new int[n];

        int id=0;
        pos[sorted[0][1]]=0;

        for(int i=1;i<n;i++){
            if(sorted[i][0]-sorted[i-1][0]>maxDiff) id++;
            group[i]=id;
            pos[sorted[i][1]]=i;
        }

        int[] far=new int[n];
        int right=0;

        for(int i=0;i<n;i++){
            while(right+1<n && sorted[right+1][0]-sorted[i][0]<=maxDiff){
                right++;
            }
            far[i]=right;
        }

        int[][] jump=new int[18][n];
        jump[0]=far;

        for(int k=1;k<18;k++){
            for(int i=0;i<n;i++){
                jump[k][i]=jump[k-1][jump[k-1][i]];
            }
        }

        int[] ans=new int[queries.length];

        for(int i=0;i<queries.length;i++){
            int u=pos[queries[i][0]];
            int v=pos[queries[i][1]];

            if(u==v){
                ans[i]=0;
                continue;
            }

            if(u>v){
                int temp=u;
                u=v;
                v=temp;
            }

            if(group[u]!=group[v]){
                ans[i]=-1;
                continue;
            }

            int curr=u;
            int steps=0;

            for(int k=17;k>=0;k--){
                if(jump[k][curr]<v){
                    curr=jump[k][curr];
                    steps+=1<<k;
                }
            }

            ans[i]=steps+1;
        }

        return ans;
    }
}