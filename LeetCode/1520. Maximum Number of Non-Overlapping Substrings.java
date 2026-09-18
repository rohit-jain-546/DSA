import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] L = new int[26], R = new int[26];
        Arrays.fill(L, -1);
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 97;
            if (L[c] < 0)
                L[c] = i;
            R[c] = i;
        }
        List<int[]> I = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (L[i] < 0)
                continue;
            int r = R[i], j = L[i];
            for (; j <= r; j++) {
                int c = s.charAt(j) - 97;
                if (L[c] < L[i]) {
                    r = -1;
                    break;
                }
                r = Math.max(r, R[c]);
            }
            if (r >= 0)
                I.add(new int[] { L[i], r });
        }
        I.sort((a, b) -> a[1] - b[1]);
        List<String> A = new ArrayList<>();
        int t = -1;
        for (int[] a : I)
            if (a[0] > t) {
                A.add(s.substring(a[0], a[1] + 1));
                t = a[1];
            }
        return A;
    }
}