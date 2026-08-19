import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n,int[][] reservedSeats) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int[] x:reservedSeats){
            int r=x[0],s=x[1];
            if(s>=2&&s<=9){
                int v=mp.getOrDefault(r,0);
                v|=(1<<(s-2));
                mp.put(r,v);
            }
        }
        long ans=(long)(n-mp.size())*2;
        for(int mask:mp.values()){
            boolean a=(mask&15)==0;     
            boolean b=(mask&60)==0;      
            boolean c=(mask&240)==0;     
            if(a&&c) ans+=2;
            else if(a||b||c) ans++;
        }
        return (int)ans;
    }
}