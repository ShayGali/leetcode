from typing import List


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        return self.check_rows(board) and self.check_columns(board) and self.check_cells(board)

    def check_rows(self, board):
        row = 0
        while row < 9:
            lis = [False] * 9
            for cell in board[row]:
                if cell == ".":
                    continue
                n = int(cell)
                if lis[n - 1]:
                    return False
                lis[n - 1] = True
            row += 1
        return True

    def check_columns(self, board):
        col = 0
        while col < 9:
            lis = [False] * 9
            row = 0
            while row < 9:
                if board[row][col] == ".":
                    row += 1
                    continue

                n = int(board[row][col])
                if lis[n - 1]:
                    return False
                lis[n - 1] = True
                row += 1
            col += 1
        return True

    def check_cells(self, board):
        for i in range(0, 9, 3):
            lis = [False] * 9
            for row in range(9):
                if row % 3 == 0:
                    lis = [False] * 9

                for col in range(i, i + 3):
                    if board[row][col] == ".":
                        continue
                    n = int(board[row][col])
                    if lis[n - 1]:
                        return False
                    lis[n - 1] = True
        return True


bT = [
    ["5", "3", ".", ".", "7", ".", ".", ".", "."],
    ["6", ".", ".", "1", "9", "5", ".", ".", "."],
    [".", "9", "8", ".", ".", ".", ".", "6", "."],
    ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
    ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
    ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
    [".", "6", ".", ".", ".", ".", "2", "8", "."],
    [".", ".", ".", "4", "1", "9", ".", ".", "5"],
    [".", ".", ".", ".", "8", ".", ".", "7", "9"]
]

bF = [
    [".", ".", ".", ".", "5", ".", ".", "1", "."],
    [".", "4", ".", "3", ".", ".", ".", ".", "."],
    [".", ".", ".", ".", ".", "3", ".", ".", "1"],
    ["8", ".", ".", ".", ".", ".", ".", "2", "."],
    [".", ".", "2", ".", "7", ".", ".", ".", "."],
    [".", "1", "5", ".", ".", ".", ".", ".", "."],
    [".", ".", ".", ".", ".", "2", ".", ".", "."],
    [".", "2", ".", "9", ".", ".", ".", ".", "."],
    [".", ".", "4", ".", ".", ".", ".", ".", "."]
]

print(Solution().isValidSudoku(bF))
