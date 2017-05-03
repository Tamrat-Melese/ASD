package strategy;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;

//swing classes


public class JGraphButton extends JButton implements Command
{
   Context context;
   public JGraphButton(ActionListener act, Context ctx)
   {
   super("Line graph");
   addActionListener(act);
   context  = ctx;
   }
   //-------------------------------
   public void Execute()
   {
      context.setPenColor(Color.red); //set color of plot
      context.setLinePlot();        //set kind of plot
      context.readData("data.txt"); //read the data
      context.plot();               //plot the data
   }
}
