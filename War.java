/**
   The War Class simulates the game of War
*/   

public class War implements WarInterface
{  
   private Board board;
   
   // constructor
   public War()
   {      
      board = new Board();      
   }
   
   /*
      roundWinner method
      @return The roundWinner of the round as an int
   */   
   public int roundWinner()
   {
      return board.roundWinner();
   }
   
   /**
      gameWinner method
      @return The gameWinner of the round as an int
   */
   public int gameWinner()
   {
      return board.gameWinner();
   }      
   
   /*
      getBoard method
      @return Board A copy of the board
   */   
   public Board getBoard()
   {
      // return a copy
      return board;
   }   
}   