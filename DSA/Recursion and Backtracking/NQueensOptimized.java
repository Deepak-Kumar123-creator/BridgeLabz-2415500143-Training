// File Name: NQueensOptimized.java

public class NQueensOptimized {

    static int N;
    static int[] board;
    static boolean[] column;
    static boolean[] diag1;
    static boolean[] diag2;

    public static void solve(int n) {
        N = n;
        board = new int[N];
        column = new boolean[N];
        diag1 = new boolean[2*N];
        diag2 = new boolean[2*N];

        placeQueen(0);
    }

    public static boolean placeQueen(int row) {

        if (row == N) {
            printBoard();
            return true; // stop after first solution
        }

        for (int col = 0; col < N; col++) {

            if (!column[col] &&
                !diag1[row + col] &&
                !diag2[row - col + N]) {

                board[row] = col;
                column[col] = true;
                diag1[row + col] = true;
                diag2[row - col + N] = true;

                if (placeQueen(row + 1))
                    return true;

                // Backtrack
                column[col] = false;
                diag1[row + col] = false;
                diag2[row - col + N] = false;
            }
        }

        return false;
    }

    public static void printBoard() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i] == j)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve(8);
    }
}
