import java.util.Scanner; 
import java.util.Random;

public class TicTacToe {

    // --- Variables ---
    static char[][] board = new char[3][3];
    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    public static void main(String[] args) {
        // --- Setup ---
        initializeBoard();
        tossAndAssignSymbols();
        displayTossResult();
        printBoard();
        
        // --- Play ---
        System.out.println("\n--- Player Move ---");
        int slot = getUsersSlot();
        
        // Convert to indices (UC4)
        int row = getRowFromSlot(slot);
        int col = getColFromSlot(slot);
        
        // --- UC5 Logic: Validate ---
        if (isValidMove(row, col)) {
            System.out.println("Move is valid! (Symbol placement coming in the next UC)");
        } else {
            System.out.println("Invalid move! That slot is out of bounds or already taken.");
        }
    }

    // ==========================================
    // UC5 Method: Move Validation
    // ==========================================
    
    /**
     * Checks if the given row and column are within bounds
     * and if the target cell is empty.
     */
    static boolean isValidMove(int row, int col) {
        // 1. Check if out of bounds (less than 0 or greater than 2)
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        
        // 2. Check if the cell is already occupied
        if (board[row][col] != '-') {
            return false;
        }
        
        // If both checks pass, it's a good move!
        return true;
    }

    // ==========================================
    // Previous Use Case Methods (UC1 - UC4)
    // ==========================================
    
    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }

    static int getUsersSlot() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a slot number (1-9): ");
        return scanner.nextInt();
    }

    static void tossAndAssignSymbols() {
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            isHumanTurn = true;
            humanSymbol = 'X';
            computerSymbol = 'O';
        } else {
            isHumanTurn = false;
            computerSymbol = 'X';
            humanSymbol = 'O';
        }
    }

    static void displayTossResult() {
        System.out.println("--- TOSS RESULT ---");
        if (isHumanTurn) {
            System.out.println("Human won the toss! You play first as: " + humanSymbol);
        } else {
            System.out.println("Computer won the toss! Computer plays first as: " + computerSymbol);
        }
        System.out.println("-------------------\n");
    }

    static void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    static void printBoard() {
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}