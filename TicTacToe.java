import java.util.Scanner; 
import java.util.Random;

public class TicTacToe {

    static char[][] board = new char[3][3];
    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    public static void main(String[] args) {
        initializeBoard();
        tossAndAssignSymbols();
        displayTossResult();
        printBoard();
        
        System.out.println("\n--- Player Move ---");
        int slot = getUsersSlot();
        System.out.println("Slot entered: " + slot);
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