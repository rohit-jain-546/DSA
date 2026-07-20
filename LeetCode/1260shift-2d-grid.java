class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        k %= total;
        int[][] shifted = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curr = i * n + j;
                int next = (curr + k) % total;

                shifted[next / n][next % n] = grid[i][j];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int[] row : shifted) {
            List<Integer> list = new ArrayList<>();
            for (int num : row) {
                list.add(num);
            }
            ans.add(list);
        }

        return ans;
    }
}