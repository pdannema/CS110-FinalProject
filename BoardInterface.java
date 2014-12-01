/**
   Board interface
*/
public interface BoardInterface 
{
   Card getTopCard(CardPile c);
   CardPile getPileOne();
   CardPile getPileTwo();
   CardPile getHandOne();
   CardPile getHandTwo();
   int gameWinner();
   int roundWinner();
   void handleWinner();
   void playCards();
   String toString();
   String roundWinnerToString();
   String gameWinnerToString();
}     