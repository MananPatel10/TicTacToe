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
        
        // --- UC4 Logic: Convert and Display ---
        int row = getRowFromSlot(slot);
        int col = getColFromSlot(slot);
        System.out.println("Slot entered: " + slot);
        System.out.println("Converted to -> Row: " + row + ", Column: " + col);
    }

    // ==========================================
    // UC4 Methods: Index Conversion
    // ==========================================
    
    /**
     * Converts slot number (1-9) into row index (0-2) using integer division.
     */
    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    /**
     * Converts slot number (1-9) into column index (0-2) using modulo operation.
     */
    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }

    // ==========================================
    // Previous Use Case Methods (UC1, UC2, UC3)
    // ==========================================
    
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