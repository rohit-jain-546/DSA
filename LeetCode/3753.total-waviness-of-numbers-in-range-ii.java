class Solution {
    private String s;
    private long[][][][][] dpCnt;
    private long[][][][][] dpWave;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {
        if (x < 0) return 0;

        s = String.valueOf(x);
        int n = s.length();

        dpCnt = new long[n][11][11][2][2];
        dpWave = new long[n][11][11][2][2];

        for (int i = 0; i < n; i++) {
            for (int a = 0; a < 11; a++) {
                for (int b = 0; b < 11; b++) {
                    for (int c = 0; c < 2; c++) {
                        Arrays.fill(dpCnt[i][a][b][c], -1);
                        Arrays.fill(dpWave[i][a][b][c], -1);
                    }
                }
            }
        }

        return dfs(0, 10, 10, 1, 1)[1];
    }

    private long[] dfs(int pos, int prev1, int prev2, int started, int tight) {
        if (pos == s.length()) {
            return new long[]{1, 0};
        }

        if (tight == 0 &&
            dpCnt[pos][prev1][prev2][started][0] != -1) {
            return new long[]{
                dpCnt[pos][prev1][prev2][started][0],
                dpWave[pos][prev1][prev2][started][0]
            };
        }

        int limit = tight == 1 ? s.charAt(pos) - '0' : 9;

        long totalCnt = 0;
        long totalWave = 0;

        for (int d = 0; d <= limit; d++) {
            int nextTight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 1 && d == 0) {
                long[] res = dfs(pos + 1, 10, 10, 1, nextTight);
                totalCnt += res[0];
                totalWave += res[1];
            } else {
                long add = 0;

                if (prev1 != 10 && prev2 != 10) {
                    if ((prev1 > prev2 && prev1 > d) ||
                        (prev1 < prev2 && prev1 < d)) {
                        add = 1;
                    }
                }

                long[] res = dfs(
                    pos + 1,
                    d,
                    prev1 == 10 ? 10 : prev1,
                    0,
                    nextTight
                );

                totalCnt += res[0];
                totalWave += res[1] + add * res[0];
            }
        }

        if (tight == 0) {
            dpCnt[pos][prev1][prev2][started][0] = totalCnt;
            dpWave[pos][prev1][prev2][started][0] = totalWave;
        }

        return new long[]{totalCnt, totalWave};
    }
}