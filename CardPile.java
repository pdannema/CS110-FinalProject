import java.util.ArrayList;
/**
   CardPile class creates a pile of cards for a player
   to use in the game of war in the form of an ArrayList
*/   

public class CardPile implements CardPileInterface
{
   private Card card;                // hold a card 
   private ArrayList<Card> cardPile; // The ArrayList to hold the cards
  
   /**
      Constructor
   */   
   public CardPile()
   {
      cardPile = new ArrayList<Card>();
   }
   
   /**
      getCards method
      @return cardPile The ArrayList of cards
   */   
   public ArrayList<Card> getCards()
   {
      return cardPile;
   }    
   /**
      getCard method
      @param i The index of the card to get
      @return Card The card
   */
   public Card getCard(int i)
   {
      return cardPile.get(i);
   }   
   
   /**
      addCard method
      Adds the card passed as an argument to the cardPile
      @param Card c The card to be added  
   */ 
   public void addCard(Card c) 
   {
      cardPile.add(c);
   }   
   
   /**
      addCardPile method
      Adds the cardPile passed as an argument to the cardPile
      @param Cardpile p The cardPile to be added
   */
   public void addCardPile(CardPile p)
   {
      for(int i = 0; i < p.cardPile.size(); i++)
      {
         addCard(p.getCard(i));
      }   
   }   
   
   /**
      clear method
      Clears all cards from the cardPile
   */
   public void clear()
   {
      cardPile.clear();
   }  
   /** 
      IsEmpty Determines if Deck is empty
      @return true if there are no more cards, false otherwise
   */
   public boolean isEmpty()
   {
      return (cardPile.size() == 0);
   }
   /** 
      dealCard Removes and returns the top Card of the deck
      @return A reference to a Card that was top on the Deck
   */
   public Card dealCard()
   {
      Card temp = getCard(0);
      cardPile.remove(0);
      return temp;
   }
   /**
      size Method
      @return size The size of the cardPile
   */   
   public int size()
   {
      return cardPile.size();
   }   
   /**
      setCard method sets the card passed as a parameter to the
      index of the cardPile ArrayList passed as a parameter
      @param int i The index to be set at
      @param Card c The card to set
   */   
   public void setCard(int i, Card c)
   {
      cardPile.set(i,c);
   }   
}   