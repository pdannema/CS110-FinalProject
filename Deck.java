import java.util.ArrayList;
import java.util.Collections;
/**
 * Representation of a Deck of cards.  
 * Initialized to a standard 52 card deck. 
 *
 * 
 */

import java.util.Random;
public class Deck extends CardPile implements DeckInterface
{
 
   /**
    * Constructs a regular 52-card deck.  Initially, the cards
    * are in a sorted order.  The shuffle() method can be called to
    * randomize the order.  
    */
   public Deck()
   {
      super();
      freshDeck();
   }
   /**
    * Create a new collection of 52 cards, in sorted order
    */
   public void freshDeck()
   {
      for (int r = Card.ACE; r<=Card.KING;r++)
      {
         for (int s=Card.SPADES;s<=Card.DIAMONDS;s++)
         {
            addCard(new Card(r,s));
         }
      }
   }  
   /** 
     * Randomize the order of Cards in Deck
     */
   public void shuffle()
   {
      Collections.shuffle(getCards());
   }
   
}
