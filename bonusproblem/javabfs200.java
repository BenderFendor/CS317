import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        Set<String> visited = new HashSet<>();

        int rows = grid.length;
        int cols = grid[0].length;

        class Helper {
            void bfs(int r, int c) {
                Queue<int[]> q = new ArrayDeque<>();

                visited.add(r + "," + c);
                q.add(new int[] { r, c });

                while (!q.isEmpty()) {
                    int[] current = q.poll();

                    int row = current[0];
                    int col = current[1];

                    int[][] directions = {
                        {1, 0},
                        {-1, 0},
                        {0, 1},
                        {0, -1}
                    };

                    for (int[] direction : directions) {
                        int dr = direction[0];
                        int dc = direction[1];

                        r = row + dr;
                        c = col + dc;

                        if (
                            r >= 0 &&
                            r < rows &&
                            c >= 0 &&
                            c < cols &&
                            grid[r][c] == '1' &&
                            !visited.contains(r + "," + c)
                        ) {
                            q.add(new int[] { r, c });
                            visited.add(r + "," + c);
                        }
                    }
                }
            }
        }

        Helper helper = new Helper();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (
                    grid[r][c] == '1' &&
                    !visited.contains(r + "," + c)
                ) {
                    islands += 1;
                    helper.bfs(r, c);
                }
            }
        }

        return islands;
    }
}
