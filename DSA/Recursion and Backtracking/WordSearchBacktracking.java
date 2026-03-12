public class WordSearchBacktracking {

    static int[] rowDir = {-1,-1,-1,0,0,1,1,1};
    static int[] colDir = {-1,0,1,-1,1,-1,0,1};

    public static boolean search(char[][] grid, String word) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == word.charAt(0)) {
                    if (backtrack(grid, word, i, j, 0, visited))
                        return true;
                }
            }
        }

        return false;
    }

    public static boolean backtrack(char[][] grid, String word,
                                    int row, int col,
                                    int index, boolean[][] visited) {

        if (index == word.length())
            return true;

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
            return false;

        if (visited[row][col] || grid[row][col] != word.charAt(index))
            return false;

        visited[row][col] = true;

        for (int d = 0; d < 8; d++) {
            if (backtrack(grid, word,
                    row + rowDir[d],
                    col + colDir[d],
                    index + 1,
                    visited)) {
                return true;
            }
        }

        visited[row][col] = false; // backtrack
        return false;
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'C','A','T','S'},
                {'O','R','E','A'},
                {'D','E','A','M'},
                {'E','L','L','S'}
        };

        String word = "DREAM";

        if (search(grid, word))
            System.out.println("Word Found!");
        else
            System.out.println("Word Not Found!");
    }
}
