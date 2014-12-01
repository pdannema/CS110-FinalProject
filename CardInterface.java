/**
   Card interface
*/

public interface CardInterface
{
   int getSuit();
   int getRank();
   String toImage();
   String toString();
   boolean equals(Card card);
}      