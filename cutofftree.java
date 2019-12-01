class Solution {
    public int cutOffTree(List < List < Integer >> forest) {
        int result = 0;
        PriorityQueue < int[] > trees = new PriorityQueue < > ((a, b) - > a[2] - b[2]);
         int directions[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                if (forest.get(i).get(j) > 1)
                    trees.add(new int[] {
                        i,
                        j,
                        forest.get(i).get(j)
                    });
            }
        }
        int[] start = new int[2];
        while (!trees.isEmpty()) {
            int[] tree = trees.poll();
            int d = bfs(directions, forest, start, tree);
            if (d < 0) return -1;
            result = result + d;
            start[0] = tree[0];
            start[1] = tree[1];
        }
        return result;
    }
    private int bfs(int[][] dir, List < List < Integer >> forest, int[] start, int[] tree) {
        int m = forest.size(), n = forest.get(0).size();
        int step = 0;
        boolean[][] visited = new boolean[m][n];
        Queue < int[] > queue = new LinkedList < > ();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current[] = queue.poll();
                if (current[0] == tree[0] && current[1] == tree[1]) return step;
                for (int[] d: dir) {
                    int nr = d[0] + current[0];
                    int nc = d[1] + current[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || forest.get(nr).get(nc) == 0 || visited[nr][nc])
                        continue;
                    queue.add(new int[] {
                        nr,
                        nc
                    });
                    visited[nr][nc] = true;
                }
            }
            step++;
        }
        return -1;
    }
}
