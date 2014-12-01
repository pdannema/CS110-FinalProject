// Command window interface for 
// the game of war
import java.util.Scanner;

public class WarCW
{
   private War game;
   
   // constructor
   public WarCW()
   {
      game = new War();
   }
   
   // play the game
   public void go()
   {
      Scanner input = new Scanner(System.in);
      String choices;
      // play until one deck is empty
      do
      {
         // get input
         System.out.println("Play a card? (y/n [n quits game]): ");
         choices = input.nextLine();
         if (choices.equalsIgnoreCase("y")) 
         {
            // play two cards
            game.getBoard().playCards();
            // display cards
            System.out.println(game.getBoard().toString());
            // determine winner of that round
            game.getBoard().roundWinner();
            // decide what to do now
            game.getBoard().handleWinner();
            // display winner of that round
            System.out.println(game.getBoard().roundWinnerToString());
         }
         else if (choices.equalsIgnoreCase("n"))
         {
            System.exit(0);
         }
         else 
            System.out.println("Invalid choice");
      }
      while (game.getBoard().gameWinner() == 0);
      // when game is over, display winner
      game.getBoard().gameWinner();
      System.out.println(game.getBoard().gameWinnerToString());
   }
   public static void main(String[] args)
   {
      WarCW wargame = new WarCW();
      wargame.go();
      
   }
}      