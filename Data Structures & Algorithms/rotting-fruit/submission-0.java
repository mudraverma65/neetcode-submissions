class Solution {
    public int orangesRotting(int[][] grid) {
        int tR = grid.length;
        int tC = grid[0].length;
        int minutes = 0;
        int fresh = 0;

        List<List<Integer>> allLevels = new ArrayList<>();

        for (int i = 0; i < tR; i++) {
            for (int j = 0; j < tC; j++) {
                if (grid[i][j] == 2) {
                    allLevels.add(new ArrayList<>(Arrays.asList(i, j)));
                } else if(grid[i][j] ==1){
                    fresh +=1;
                }
            }
        }

        while (!allLevels.isEmpty()) {
            List<List<Integer>> currLevel = new ArrayList<>();
            int[][] directions = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

            for (List<Integer> level : allLevels) {
                for (int[] dir : directions) {
                    int nR = level.get(0) + dir[0];
                    int nC = level.get(1) + dir[1];

                    if (nR >= 0 && nR < tR && nC >= 0 && nC < tC && grid[nR][nC] == 1) {
                        grid[nR][nC] = 2;
                        fresh--;
                        currLevel.add(new ArrayList<>(Arrays.asList(nR, nC)));
                    }
                }
            }

            if (!currLevel.isEmpty()) {
                minutes++;
            }

            allLevels = currLevel;
        }

        return fresh == 0 ? minutes : -1;
    }
}