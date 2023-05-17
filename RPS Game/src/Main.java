import java.util.Scanner;
import java.util.Random;

public class Main
{
    private static final String rock = "rock";
    private static final String paper = "paper";
    private static final String scissors = "scissors";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        String input = "";
        while(!input.equals("end")){
            System.out.print("Choose [r]ock, [p]aper, or [s]cissors: ");

            String playerMove = "";

            boolean isValid;
            do{
                //The player chooses a move
                playerMove = scanner.nextLine().toLowerCase().trim();

                if(playerMove.toLowerCase().equals("end")) return;

                switch (playerMove){
                    case "r": case "rock":
                        playerMove = rock; isValid = true; break;
                    case "p": case "paper":
                        playerMove = paper; isValid = true; break;
                    case "s": case "scissors":
                        playerMove = scissors; isValid = true; break;

                    default: System.out.println("Invalid input. Try again...");
                        isValid = false;
                }
            } while(!isValid);

            //The computer chooses a move
            int computerChoice = rand.nextInt(3);
            String computerMove = "";

            switch (computerChoice){
                case 0: computerMove = rock; break;
                case 1: computerMove = paper; break;
                case 2: computerMove = scissors; break;
            }

            System.out.printf("%nThe computer chose %s.%n", computerMove);

            //Settling the competition...
            if ((playerMove.equals(rock) && computerMove.equals(scissors)) ||
                    (playerMove.equals(paper) && computerMove.equals(rock)) ||
                    (playerMove.equals(scissors) && computerMove.equals(paper))) {
                System.out.println("You win!");

            } else if (playerMove.equals(computerMove)){
                System.out.println("Draw!");

            } else System.out.println("You lose!");

            System.out.printf("%nPress Enter to start over or write End to quit:");
            input = scanner.nextLine().toLowerCase().trim();
        }
    }
}