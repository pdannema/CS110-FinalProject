import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import javax.swing.BoxLayout;

/* 
   WARGUI class displays a JFrame that
   lets the user play WAR. When the 
   play button is clicked, the game
   plays one more move.
*/

   /**
      Constructor
   */
public class WarGUI extends JFrame implements WarGUIInterface
{      
   private ImageIcon image;
   private ImageIcon back;
   private JPanel buttonPanel;
   private JPanel gamePanel; 
   private JPanel textPanel;                    
   private JLabel cardPileTwo;
   private JLabel cardPileOne;
   private JLabel deckTwo;
   private JLabel deckOne;
   private Card card;
   private JLabel status; 
   private JLabel numOne;
   private JLabel numTwo;            
   private JButton playButton;
   private JButton newGame;                    
   private War game;
   
   public WarGUI()
   {  
      game = new War();
      // create 3 panels
      buttonPanel = new JPanel();
      gamePanel = new JPanel();
      textPanel = new JPanel(new GridLayout(2,1));
      // set nice colors for the panels
      buttonPanel.setBackground(Color.WHITE);
      gamePanel.setBackground(Color.GREEN);
      textPanel.setBackground(Color.WHITE);
      // backside of the card
      back = new ImageIcon("back.jpg");
      // each player has a grid with the number of cards
      // remaining displaying at the bottom
      JPanel playerOneGrid = new JPanel(new GridLayout(2,2));
      playerOneGrid.setBackground(Color.GREEN);
      cardPileOne = new JLabel();
      deckOne = new JLabel();
      numOne = new JLabel();
      numOne.setHorizontalAlignment(SwingConstants.RIGHT);
      numOne.setVerticalAlignment(SwingConstants.CENTER);
      numOne.setFont(new Font("HELVETICA",Font.ITALIC,36));
      numOne.setForeground(Color.WHITE);
      playerOneGrid.add(cardPileOne);
      playerOneGrid.add(deckOne);
      playerOneGrid.add(numOne);
      JPanel playerTwoGrid = new JPanel(new GridLayout(2,2));
      playerTwoGrid.setBackground(Color.GREEN);
      cardPileTwo = new JLabel();
      deckTwo = new JLabel();
      numTwo = new JLabel();
      numTwo.setHorizontalAlignment(SwingConstants.RIGHT);
      numTwo.setVerticalAlignment(SwingConstants.CENTER);
      numTwo.setFont(new Font("HELVETICA",Font.ITALIC,36));
      numTwo.setForeground(Color.WHITE);
      numTwo.setBackground(new Color (53,94,59));
      playerTwoGrid.add(cardPileTwo);
      playerTwoGrid.add(deckTwo);
      playerTwoGrid.add(numTwo);
      // add grids to gamePanel
      gamePanel.add(playerOneGrid);
      gamePanel.add(playerTwoGrid);
      // setup playButton
      JButton playButton = new JButton("Play");
      playButton.addActionListener(new ButtonListener());
      playButton.setActionCommand("Play");
      // setup newGame
      JButton newGame = new JButton("New Game");
      newGame.addActionListener(new ButtonListener());
      newGame.setActionCommand("New Game");
      // add buttons to buttonPanel
      buttonPanel.add(playButton);
      buttonPanel.add(newGame);
      // create a label telling who has won the round/game
      status = new JLabel("Game in progress");
      status.setHorizontalAlignment(SwingConstants.CENTER);
      status.setVerticalAlignment(SwingConstants.CENTER);
      status.setFont(new Font("HELVETICA",Font.ITALIC,36));
      textPanel.add(status);
      // add all panels to Frame
      add(textPanel,BorderLayout.SOUTH);
      add(buttonPanel,BorderLayout.NORTH);
      add(gamePanel,BorderLayout.CENTER);
      // set default icons
      setIcons();
      setVisible(true);
   }  
   
   /**
      Private inner class that handles the event when
      the user clicks a button
   */
   
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         String s = e.getActionCommand();
         // if you hit the new game button, start a new game
         if (s == "New Game")
         {
            game = new War();
            setIcons();
            status.setText(null);
         }   
         // otherwise, you hit play
         else 
         {  
            // if no winner yet
            if (game.gameWinner() == 0)
            {    
               // play two cards
               game.getBoard().playCards();
               setIcons();     
               // determine winner of that round
               game.roundWinner();
               if (game.roundWinner() == 0)
               {
                  status.setText("The round was a tie. WAR!");
               }   
               else if (game.roundWinner() == 1)
                  status.setText("Player One won that round");
               else if (game.roundWinner() == 2)
                  status.setText("Player Two won that round"); 
               // update images accordingly
               game.getBoard().handleWinner();
            }   
            // first check if someone won and update status 
            // and disable button if so
            if (game.gameWinner() == 3)
            {
               status.setText("The game was a tie.");
               playButton.setEnabled(false);
            }   
            else if (game.gameWinner() == 1)
            {
               status.setText("Player One won the Game!");
               playButton.setEnabled(false);
            }      
            else if (game.gameWinner() == 2)
            {
               status.setText("Player Two won the Game!"); 
               playButton.setEnabled(false);
            }      
         }
         // display number of cards remaining for each player
         numOne.setText(game.getBoard().getPileOne().size()+"");
         numTwo.setText(game.getBoard().getPileTwo().size()+"");
      }   
   } 
   /**
      setIcons method sets the icons according to
      how the cards on the table are setup
   */   
   public void setIcons()
   {
      if (game.getBoard().getHandOne().isEmpty() != true)
      {
         // if it's a tie, the card goes face down
         if (game.roundWinner() == 0)
            cardPileOne.setIcon(back); 
         // otherwise the card goes face up
         else     
            cardPileOne.setIcon(new ImageIcon(game.getBoard().getTopCard(game.getBoard().getHandOne()).toImage()));
      }
      // if it's empty, set it to null
      else
         cardPileOne.setIcon(null);
      if (game.getBoard().getHandTwo().isEmpty() != true) 
      {
         if (game.roundWinner() == 0)
            cardPileTwo.setIcon(back); 
         else       
            cardPileTwo.setIcon(new ImageIcon(game.getBoard().getTopCard(game.getBoard().getHandTwo()).toImage()));
      }
      else
         cardPileTwo.setIcon(null);
      // if the players' decks are empty, set the icon to null
      if (game.getBoard().getPileOne().isEmpty() == true)
         deckOne.setIcon(null);
      // otherwise, set it to the back of a card
      else
         deckOne.setIcon(back);   
      if (game.getBoard().getPileTwo().isEmpty() == true)
         deckTwo.setIcon(null);
      else
         deckTwo.setIcon(back);   
   }                       
}            