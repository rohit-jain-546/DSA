class Solution {
    public int maximumCandies(int[] candies, long k) {
        // Arrays.sort(candies);

        long total = 0;
        int max =0;
        for (int c : candies) {total += c;max=Math.max(max,c);}
        if (total < k) return 0;

        int s =1, e= max;

        while(s<e){
            long sum =0;
            int mid = s+(e-s+1)/2;
            for (int c : candies){
                sum+=c/mid;
                if(sum>=k)break;
            }
            if(sum<k){
                e=mid-1;
            }else s=mid;

        }return s;
    }
}