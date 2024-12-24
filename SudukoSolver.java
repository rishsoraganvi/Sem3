import java.util.Scanner;

public class SudokuSolver {

    // Function to check if placing a digit is valid
    public static boolean isSafe(int[][] sudoku, int row, int col, int digit) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == digit || sudoku[row][i] == digit) {
                return false;
            }
        }
        int sr = (row / 3) * 3, sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    // Recursive backtracking solver
    public static boolean solveSudoku(int[][] sudoku, int row, int col) {
        if (row == 9) return true;
        int nextRow = row + (col + 1) / 9;
        int nextCol = (col + 1) % 9;

        if (sudoku[row][col] != 0) {
            return solveSudoku(sudoku, nextRow, nextCol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (solveSudoku(sudoku, nextRow, nextCol)) return true;
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    // Print Sudoku grid
    public static void printSudoku(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Predefined puzzles for difficulty levels
    public static int[][] getPuzzle(int level) {
        if (level == 1) { // Easy
            return new int[][] {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
            };
        } else if (level == 2) { // Medium
            return new int[][] {
                {0, 0, 0, 6, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {0, 0, 0, 0, 6, 0, 0, 0, 0},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 0, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 0, 9}
            };
        } else { // Hard
            return new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 8, 0, 3, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 0, 0},
                {0, 0, 0, 4, 0, 9, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 0}
            };
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the Sudoku Solver!");
            System.out.println("Select Difficulty Level:");
            System.out.println("1. Easy\n2. Medium\n3. Hard\n4. Enter your own puzzle\n5. Exit");
            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Thank you for using Sudoku Solver. Goodbye!");
                break;
            }

            int[][] sudoku;
            if (choice == 4) {
                sudoku = new int[9][9];
                System.out.println("Enter your Sudoku puzzle row by row (use 0 for empty cells):");
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        sudoku[i][j] = scanner.nextInt();
                    }
                }
            } else {
                sudoku = getPuzzle(choice);
            }

            System.out.println("Original Sudoku:");
            printSudoku(sudoku);

            if (solveSudoku(sudoku, 0, 0)) {
                System.out.println("Solved Sudoku:");
                printSudoku(sudoku);
            } else {
                System.out.println("This Sudoku puzzle cannot be solved.");
            }
        }
        scanner.close();
    }
}        