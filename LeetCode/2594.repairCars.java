class Solution {
    public long repairCars(int[] ranks, int cars) {
        int max =0;
        for (int i  : ranks){
            max = Math.max(max,i);
        }
        long s =0, e=(long)max*cars*cars ;
        while(s<e){
            long  mid = s+(e-s)/2;
            long sum =0;
            for(int r : ranks ){
                sum+=(long)Math.sqrt((double)mid/r);
                if(sum>=cars)break;
            }
            if(sum>=cars)e=mid;
            else s=mid+1;
        }
        return s;
    }
}