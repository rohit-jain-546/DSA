class Solution {

    List<int[]>[] graph;
    boolean[] visited;
    int minScore = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for(int[] road : roads) {
            graph[road[0]].add(new int[]{road[1], road[2]});
            graph[road[1]].add(new int[]{road[0], road[2]});
        }

        dfs(1);
        return minScore;
    }

    private void dfs(int city) {

        visited[city] = true;

        for(int[] next : graph[city]) {
            minScore = Math.min(minScore, next[1]);

            if(!visited[next[0]])
                dfs(next[0]);
        }
    }
}