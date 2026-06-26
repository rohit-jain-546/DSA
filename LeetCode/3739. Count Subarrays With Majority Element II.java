import java.util.*;

class Solution {
    class BIT {
        int n;
        long[] bit;

        BIT(int n) {
            this.n = n;
            bit = new long[n + 1];
        }

        void update(int idx, int val) {
            while (idx <= n) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        long query(int idx) {
            long sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        int[] values = prefix.clone();
        Arrays.sort(values);

        int m = 1;
        for (int i = 1; i < values.length; i++) {
            if (values[i] != values[m - 1]) {
                values[m++] = values[i];
            }
        }

        BIT bit = new BIT(m);
        long ans = 0;

        for (int x : prefix) {
            int idx = lowerBound(values, m, x) + 1;
            ans += bit.query(idx - 1);
            bit.update(idx, 1);
        }

        return ans;
    }

    private int lowerBound(int[] arr, int size, int target) {
        int l = 0, r = size;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}