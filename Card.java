/* Peter Dannemann\
CS 110\
Card Class */

/*
   Card class represents a single playing card from a standard 52	card deck.		
   Each card has a rank and a suit. All ranks and suits are public constants in the class 
   (Card.SPADES, Card.ACE, etc). A Card object is created with a rank and suit and it cannot	
   be	modified	after	creation. For this design, two cards	are equal if they contain the	
   same rank.
   
   Each card has the option to hold an image of the card
*/

public class Card implements CardInterface
{
   public static final int SPADES = 1;
   public static final int CLUBS = 2;
   public static final int HEARTS = 3;
   public static final int DIAMONDS = 4;
   
   public static final int JACK = 11;
   public static final int QUEEN = 12;
   public static final int KING = 13;
   public static final int ACE = 1;
      
   private int rank;
   private int suit;
   
   private String rankString, suitString;          
   
   /** Constructor 
       @param r The rank
       @param s The suit
   */    
   
   public Card(int r, int s)
   {
      rank = r;
      suit = s;
   }
   
   /*
      getSuit method
      @return suit The suit
   */
   public int getSuit()
   {
      return suit;
   }
   
   /*
      getRank method
      @return rank The rank
   
   */
   public int getRank()
   {
      return rank;
   }
  
   /**
      toImage method
      @return str The card in image string format
   */
   public String toImage()
   {
      String str;
      if(rank == Card.ACE)
         rankString = "ace";
      else if(rank == Card.JACK)
         rankString = "jack";
      else if(rank == Card.QUEEN)
         rankString = "queen";
      else if(rank == Card.KING)
         rankString = "king";
      else if(rank > 1 && rank < 11)
         rankString = Integer.toString(rank); 
      if(suit == Card.SPADES)
         suitString = "s";
      else if(suit == Card.CLUBS)
         suitString = "c";
      else if(suit == Card.HEARTS)
         suitString = "h";
      else if(suit == Card.DIAMONDS)
         suitString = "d";  
      str = rankString + suitString +".jpg";
      return str;
   }   
         
   /**
      toString method
      @return str The value of the card as a String
   */   
   public String toString()
   {
      String str;
      if(rank == Card.ACE)
         rankString = "Ace";
      else if(rank == Card.JACK)
         rankString = "Jack";
      else if(rank == Card.QUEEN)
         rankString = "Queen";
      else if(rank == Card.KING)
         rankString = "King";
      else if(rank > 1 && rank < 11)
         rankString = Integer.toString(rank); 
      if(suit == Card.SPADES)
         suitString = "SPADES";
      else if(suit == Card.CLUBS)
         suitString = "CLUBS";
      else if(suit == Card.HEARTS)
         suitString = "HEARTS";
      else if(suit == Card.DIAMONDS)
         suitString = "DIAMONDS";  
      str = rankString + " of " + suitString;
      return str;
   }
   
   /*
      equals method
      @param Card card The card to test equality with
      @return true If months are same
      @return false If months are different
   */
   
   public boolean equals(Card card)
   {
      // See if this first cards's rank is
      // equal to second card's rank
      if (rank == card.getRank())
         return true;
      else
         return false; 
   }      
}   