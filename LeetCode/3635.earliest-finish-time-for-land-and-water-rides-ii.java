class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ld = landStartTime.length;
        int wd = waterStartTime.length;
        int ans =Integer.MAX_VALUE;
        int a =Integer.MAX_VALUE;
        for (int i =0 ; i < ld ; i++){
            a = Math.min(landStartTime[i]+landDuration[i],a);
        }
        for(int j =0 ; j< wd;j++){
            int f = Math.max(a,waterStartTime[j])+waterDuration[j];
            ans = Math.min(ans, f );
        }
        a=Integer.MAX_VALUE;
         for (int i =0 ; i < wd ; i++){
            a =Math.min( waterStartTime[i]+waterDuration[i],a);
        }
        for(int j =0 ; j< ld;j++){
            int f = Math.max(a,landStartTime[j])+landDuration[j];
            ans = Math.min(ans, f );
        }return ans;  
    }
}