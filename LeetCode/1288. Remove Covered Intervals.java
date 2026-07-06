class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0])return b[1]-a[1];
            return a[0]-b[0];
        });
        int c =0;
        int maxEnd=-1;
        for(int []a:intervals){
            if(a[1]>maxEnd){
                c++;
                maxEnd=a[1];
            }
        }
        return c;
    }
}