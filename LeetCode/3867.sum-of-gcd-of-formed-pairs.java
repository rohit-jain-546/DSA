import java.util.Arrays;

class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length, m = 0;
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            m = Math.max(m, nums[i]);
            p[i] = gcd(nums[i], m);
        }
        Arrays.sort(p);
        long s = 0;
        for (int l = 0, r = n - 1; l < r;)
            s += gcd(p[l++], p[r--]);
        return s;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}