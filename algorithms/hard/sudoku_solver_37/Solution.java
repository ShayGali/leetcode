package algorithms.hard.sudoku_solver_37;

public class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    public boolean solve(char[][] board, int row, int col) {
        if (col == 9) { // אם הגענו לסוף של שורה אפשר להגיע לשורה הבאה
            col = 0;
            row += 1;
        }

        if (row == 9) { // אם סיימנו את כל השורות אז סיימנו
            return true;
        }

        if (board[row][col] != '.') // אם בתא יש כבר מספר, אז אפשר לעבור לתא הבא
            return solve(board, row, col + 1);

        for (char n = '1'; n <= '9'; n++) { // עוברים מ 1 ל 9
            if (isFeet(board, row, col, n)) { // אם המספר יכול להיכנס בנתיים
                board[row][col] = n; // מסמנים אותו
                if (solve(board, row, col + 1)) // עוברים לתא הבא
                    return true; // אם הגענו לסוף זה יגיע לפה, ובעצם יש לנו פתרון
            }
        }
        board[row][col] = '.'; // אם סיימנו את הלולאה אז נמחק את התא

        return false; // נחזיר שקר שהלולאה תמשיך לפעם הקודמת
    }

    boolean isFeet(char[][] board, int row, int col, char n) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == n) return false; // לבדוק את העמודה
            if (board[i][col] == n) return false; // לבדוק את השורה
        }

        // לבדוק את העמודה
        int cell_x = row / 3;
        int cell_y = col / 3;
        for (int i = cell_x * 3; i < (cell_x + 1) * 3; i++) {
            for (int j = cell_y * 3; j < (cell_y + 1) * 3; j++) {
                if (board[i][j] == n) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        printBoard(board);
        System.out.println(new Solution().solve(board, 0, 0));
        printBoard(board);
    }

    static void printBoard(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("\n──────────┼───────────┼───────────");
            } else {
                System.out.println();
            }
            for (int j = 0; j < board[i].length; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print(" │ ");
                }
                System.out.printf(" %c ", board[i][j]);
            }
        }
        System.out.println("\n");
    }
}
