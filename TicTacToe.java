// UC3 requires the Scanner tool to read keyboard input
import java.util.Scanner; 
import java.util.Random;

public class TicTacToe {

    // --- UC1 Variables ---
    static char[][] board = new char[3][3];

    // --- UC2 Variables ---
    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    public static void main(String[] args) {
        // --- UC1 & UC2 Logic ---
        initializeBoard();
        tossAndAssignSymbols();
        displayTossResult();
        printBoard();
        
        // --- UC3 Logic (Testing the input) ---
        // For now, we will just test getting the input. 
        // Later we will loop this so the game keeps going!
        System.out.println("\n--- Player Move ---");
        int slot = getUsersSlot();
        System.out.println("Slot entered: " + slot);
    }

    /**
     * UC3: Reads an integer slot value from the user.
     * Hint: Validation (checking if it's 1-9 and empty) will be added later!
     */
    static int getUsersSlot() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a slot number (1-9): ");
        int slot = scanner.nextInt();
        return slot;
    }

    // ==========================================
    // UC2 Methods
    // ==========================================
    static void tossAndAssignSymbols() {
        Random random = new Random();
        int toss = random.nextInt(2);

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

    static void displayTossResult() {
        System.out.println("--- TOSS RESULT ---");
        if (isHumanTurn) {
            System.out.println("Human won the toss! You play first as: " + humanSymbol);
        } else {
            System.out.println("Computer won the toss! Computer plays first as: " + computerSymbol);
        }
        System.out.println("-------------------\n");
    }

    // ==========================================
    // UC1 Methods
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