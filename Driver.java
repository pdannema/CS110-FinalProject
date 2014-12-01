import javax.swing.*;

/**
   Drive class runs the War GUI
*/   
public class Driver
{
   private static final int WINDOW_WIDTH = 800;      
   private static final int WINDOW_HEIGHT = 600;
   
   public static void main(String [] args)
   {
      JFrame frame = new WarGUI();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
      frame.validate();
      frame.setVisible(true);
   }
}