/**
   The Board class creates a playing board for
   the game of War
*/

public class Board implements BoardInterface
{
   // create two hands for each player
   private CardPile handOne = new CardPile();
   private CardPile handTwo = new CardPile();
   
   // create two CardPiles decks for each player
   private CardPile deckOne = new CardPile(); 
   private CardPile deckTwo = new CardPile();
   
   // holds a number representing the winner of that round
   private int roundWinner;
   
   // holds a number representing the winner of the game
   private int gameWinner;
   
   // holds a string to display output
   String s;
   
   /** Constructor
       Adds all the cards from the deck to the player's decks
   */
   public Board() 
   {
      Deck deck = new Deck(); // create deck
      deck.shuffle(); // shuffle deck
      // add all the cards from the deck into the two CardPiles
      do
      {
         deckOne.addCard(deck.dealCard());
         deckTwo.addCard(deck.dealCard());
      }   
      while(deck.isEmpty() != true);
   }
   
   /** deep copy constructor
       Creates a copy of the board passed as an argument
       @param Board b The board to copy
   */   
   public Board(Board b)
   {
      this.deckOne = deckOne;
      this.deckTwo = deckTwo;
   }
   
   /**
      getTopCard method
      @param CardPile The cardPile to take the card from
      @return Card The top card
   */
   public Card getTopCard(CardPile c)
   {  
      return c.getCard(c.size()-1); 
   }      
   
   /**
      getPileOne method
      @return CardPile Player one's cardPile
   */
   public CardPile getPileOne()
   {
      return deckOne;  
   } 
   
   /**
      getPileTwo method
      @return CardPile Player two's cardPile
   */
   public CardPile getPileTwo()
   {
      return deckTwo;  
   }  
   
   /**
      getHandOne method
      @return CardPile Player one's hand
   */
   public CardPile getHandOne()
   {
      return handOne;
   }
   
   /**
      getHandTwo method
      @return CardPile Player two's hand
   */
   public CardPile getHandTwo()
   {
      return handTwo;
   }             
   
   /**
      gameWinner method determines if someone has won the
      game, and if so, who won
      @return int gameWinner 0 if no winner yet, 1 if playerOne won,
      2 if playerTwo won, 3 if tie
   */ 
   public int gameWinner()
   {
      // if both are out of cards
      if (deckOne.size() == 0 && deckTwo.size() == 0)
         return gameWinner = 3;
      // playerOne wins
      else if (deckTwo.size() == 0)
         return gameWinner = 1;
      // playerTwo wins
      else if (deckOne.size() == 0)
         return gameWinner = 2;
      // no winner yet
      else
         return gameWinner = 0;
   }            
         
   /**
      winner method determines the winner of that round
      @return int Winner 0 if tie, 1 if playerOne won, 2 if playerTwo won
   */
   public int roundWinner()
   { 
      // if player one wins, add hands to his/her deck
      if (getTopCard(handOne).getRank() > getTopCard(handTwo).getRank())
         return roundWinner = 1;  
      // if player two wins, add hands to his/her deck
      else if (getTopCard(handOne).getRank() < getTopCard(handTwo).getRank()) 
         return roundWinner = 2; 
      // if it's a tie, put another card down in each person's hand
      else
         return roundWinner = 0;
   }  
   
   /**
      handleWinner decides what action to take after a player has won
      a round
   */
   public void handleWinner()
   {
      if (roundWinner == 1)
      {
         deckOne.addCardPile(handOne);
         deckOne.addCardPile(handTwo);
         // clear hands
         handOne.clear();
         handTwo.clear();
      }   
      else if (roundWinner == 2) 
      {
         deckTwo.addCardPile(handOne);
         deckTwo.addCardPile(handTwo);
         // clear hands
         handOne.clear();
         handTwo.clear();
      }     
      else if (roundWinner == 0)
         playCards();
   }          
   /**
      playCards deals a card from each players deck and adds them to their hand
   */
   public void playCards()
   {
      if (deckOne.size() != 0 || deckTwo.size() != 0)
      {
         handOne.addCard(deckOne.dealCard());
         handTwo.addCard(deckTwo.dealCard());
      }   
   }
   
   /**
      toString method
      @return s A string that states the cards on the table
   */   
   public String toString()
   {        
      s = "\nPlayer One played a " + getTopCard(handOne).toString() +
          "\nPlayer Two played a " + getTopCard(handTwo).toString();       
      return s;
   }
   
   /**
      winnerToString method
      @return s A string that states who won that round (or if it was a tie) 
      and the number of cards in each persons deck
   */
   public String roundWinnerToString()
   {
      if (roundWinner == 1)
         s = "Player One won that round.";
      else if (roundWinner == 2)
         s = "Player Two won that round.";
      else
         s = "It was a tie. WAR!!!";
      s += "\n#Cards In Deck- P1:" + deckOne.size() + " P2:" + deckTwo.size();
      return s;
   } 
   
   /**
      gameWinnerToString method
      @return s A string that states who won the game
   */
   public String gameWinnerToString()
   {        
      if (gameWinner() == 3)
         s = "The game was a tie!";
      else if (gameWinner() == 1)
         s = "Player one won the game!";
      else if (gameWinner() == 2)
         s = "Player two won the game!"; 
      return s;     
   }  
}     