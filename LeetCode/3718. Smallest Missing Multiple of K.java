class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] seen = new boolean[101];

        for (int num : nums) {
            if (num % k == 0) {
                seen[num / k] = true;
            }
        }

        int multiple = 1;
        while (multiple < seen.length && seen[multiple]) {
            multiple++;
        }

        return multiple * k;
    }
}