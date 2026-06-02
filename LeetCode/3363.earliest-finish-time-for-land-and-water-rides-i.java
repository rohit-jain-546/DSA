class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ld = landStartTime.length;
        int wd = waterStartTime.length;
        int ans =Integer.MAX_VALUE;
        for (int i =0 ; i < ld ; i++){
            int a = landStartTime[i]+landDuration[i];
            for(int j =0 ; j< wd;j++){
                if(waterStartTime[j]>a){
                    int z = (waterStartTime[j]-a);
                    a+=(waterStartTime[j]-a);
                    a+= waterDuration[j];
                    ans = Math.min(ans, a );
                    a-= waterDuration[j]+z;
                    continue;
                }
                a+= waterDuration[j];
                    ans = Math.min(ans, a );
                    a-= waterDuration[j];
            }
        }
        for (int i =0 ; i < wd ; i++){
            int a = waterStartTime[i]+waterDuration[i];
            for(int j =0 ; j< ld;j++){
                if(landStartTime[j]>a){
                    int z = (landStartTime[j]-a);
                    a+=(landStartTime[j]-a);
                    a+= landDuration[j];
                    ans = Math.min(ans, a );
                    a-= landDuration[j]+z;
                    continue;
                }
                a+= landDuration[j];
                    ans = Math.min(ans, a );
                    a-= landDuration[j];
                
            }
        }return ans;
    }
}