import java.util.Random;

public class TicTacToe {

    // --- UC1 Variables ---
    static char[][] board = new char[3][3];

    // --- UC2 Variables ---
    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    /**
     * Entry point of the program. 
     */
    public static void main(String[] args) {
        // From UC1
        initializeBoard();
        
        // From UC2
        tossAndAssignSymbols();
        displayTossResult();
        
        // From UC1
        printBoard();
    }

    /**
     * UC2: Uses random logic to decide the first player and assigns symbols.
     * Generates a 0 or 1. If 0, Human is X and goes first. If 1, Computer is X and goes first.
     */
    static void tossAndAssignSymbols() {
        Random random = new Random();
        int toss = random.nextInt(2); // Generates either 0 or 1

        if (toss == 0) {
            isHumanTurn = true;
            humanSymbol = 'X';
            computerSymbol = 'O';
        } else {
            isHumanTurn = false;
            computerSymbol = 'X';
            humanSymbol = 'O';
        }
    }

    /**
     * UC2: Displays the toss result to the console.
     */
    static void displayTossResult() {
        System.out.println("--- TOSS RESULT ---");
        if (isHumanTurn) {
            System.out.println("Human won the toss!");
            System.out.println("Human plays first as: " + humanSymbol);
            System.out.println("Computer is: " + computerSymbol);
        } else {
            System.out.println("Computer won the toss!");
            System.out.println("Computer plays first as: " + computerSymbol);
            System.out.println("Human is: " + humanSymbol);
        }
        System.out.println("-------------------\n"); // Extra newline for neatness
    }

    // ==========================================
    // UC1 Methods (Kept exactly the same)
    // ==========================================

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