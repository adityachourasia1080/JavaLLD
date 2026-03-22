package Microsoft;

import java.util.*;
public class ReachBuilding {
    public int shortestDistance(int[][] grid) {
        /**
         * Find empty cell minimizing sum of distances from all buildings.
         * Uses multi-source BFS from each building to accumulate distances.
         */
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int buildingCount = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) buildingCount++;
            }
        }

        // Track total distance and reachability for each cell
        int[][] totalDistance = new int[rows][cols];
        int[][] reachableCount = new int[rows][cols];

        int buildingsProcessed = 0;

        // Process each building with BFS
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    buildingsProcessed++;

                    // BFS from this building
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{r, c, 0});
                    boolean[][] visited = new boolean[rows][cols];
                    visited[r][c] = true;

                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int currR = curr[0], currC = curr[1], dist = curr[2];

                        // Explore 4 directions
                        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                        for (int[] dir : directions) {
                            int nr = currR + dir[0];
                            int nc = currC + dir[1];

                            // Check bounds and validity
                            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                                if (!visited[nr][nc] && grid[nr][nc] == 0) {
                                    visited[nr][nc] = true;

                                    // Accumulate distance to this empty cell
                                    totalDistance[nr][nc] += dist + 1;
                                    reachableCount[nr][nc]++;

                                    // Continue BFS
                                    queue.offer(new int[]{nr, nc, dist + 1});
                                }
                            }
                        }
                    }
                }
            }
        }

        // Find minimum distance among cells reachable by all buildings
        int minDistance = Integer.MAX_VALUE;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0 && reachableCount[r][c] == buildingCount) {
                    minDistance = Math.min(minDistance, totalDistance[r][c]);
                }
            }
        }

        return minDistance != Integer.MAX_VALUE ? minDistance : -1;
    }
}
