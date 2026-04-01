class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] lmax = new int [n];
        int[] rmax = new int [n];
        lmax[0]=height[0];
        rmax[n-1]=height[n-1];
        int m =n-1;
        for(int i =1;i<n;i++){
            lmax[i]=Math.max(lmax[i-1],height[i]);
            rmax[m-1]=Math.max(rmax[m],height[m-1]);
            m--;
        }
        int sum=0;
        for(int i =0; i< n;i++){
            sum+=Math.min(lmax[i],rmax[i])-height[i];
        }return sum;
    

        
    }
}