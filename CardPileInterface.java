import java.util.ArrayList;
/**
   CardPile interface
*/

public interface CardPileInterface
{
   ArrayList<Card> getCards();
   Card getCard(int i);
   void addCard(Card c);
   void addCardPile(CardPile p);
   void clear();
   boolean isEmpty();
   Card dealCard();
   int size();
   void setCard(int i, Card c);
}    