import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String playerA;
        String playerB;
        String playAgain = "";

        do {

            System.out.println("Player A, enter your move [R/P/S]: ");
            playerA = in.nextLine();
            while (!isValidMove(playerA)) {
                System.out.println("Invalid move. Please enter R, P, or S: ");
                playerA = in.nextLine();
            }

            System.out.println("Player B, enter your move [R/P/S]: ");
            playerB = in.nextLine();
            while (!isValidMove(playerB)) {
                System.out.println("Invalid move. Please enter R, P, or S: ");
                playerB = in.nextLine();
            }

            displayResults(playerA, playerB);

            System.out.println("Do you want to play again? [Y/N]: ");
            playAgain = in.nextLine();

        } while (playAgain.equalsIgnoreCase("y"));

        System.out.println("Thanks for playing!");
        in.close();
    }

    private static boolean isValidMove(String move) {
        return move.equalsIgnoreCase("R") || move.equalsIgnoreCase("P") || move.equalsIgnoreCase("S");
    }

    private static void displayResults(String moveA, String moveB) {
        System.out.println("Player A chose: " + moveA);
        System.out.println("Player B chose: " + moveB);

        if (moveA.equalsIgnoreCase(moveB)) {
            System.out.println("It's a tie! " + capitalizeFirstLetter(moveA) + " vs " + capitalizeFirstLetter(moveB));
        } else if (playerAWins(moveA, moveB)) {
            System.out.println("Player A wins! " + getWinningPhrase(moveA, moveB));
        } else {
            System.out.println("Player B wins! " + getWinningPhrase(moveB, moveA));
        }
    }


    private static boolean playerAWins(String moveA, String moveB) {
        return (moveA.equalsIgnoreCase("R") && moveB.equalsIgnoreCase("S")) ||
                (moveA.equalsIgnoreCase("P") && moveB.equalsIgnoreCase("R")) ||
                (moveA.equalsIgnoreCase("S") && moveB.equalsIgnoreCase("P"));
    }


    private static String getWinningPhrase(String winningMove, String losingMove) {
        switch (winningMove.toUpperCase()) {
            case "R":
                return "Rock breaks Scissors";
            case "P":
                return "Paper covers Rock";
            case "S":
                return "Scissors cut Paper";
            default:
                return "";
        }
    }
    
    private static String capitalizeFirstLetter(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
