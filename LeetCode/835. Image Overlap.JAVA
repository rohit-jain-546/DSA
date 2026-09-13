class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length, m = 0;
        int[][] c = new int[60][60];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (img1[i][j] == 1)
                    for (int x = 0; x < n; x++)
                        for (int y = 0; y < n; y++)
                            if (img2[x][y] == 1)
                                m = Math.max(m, ++c[i - x + 30][j - y + 30]);
        return m;
    }
}