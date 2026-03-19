class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high =0,low=1;
        for(int p : piles){
            high= Math.max(high,p);
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            long hrs=0;
            for(int p : piles){
                hrs+=(p+mid-1)/mid;
            }
            if(hrs<=h){
                high=mid-1;
            }else{
                low=mid+1;
            }

        }return low;
    }
}