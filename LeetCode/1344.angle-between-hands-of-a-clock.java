class Solution {
    public double angleClock(int hour, int minutes) {
       double ans =Math.abs((hour%12+(minutes/60.0))-(minutes/5.0))*30; 
       return Math.min(360.0-ans,ans);
    }
}