package strategy;
import java.awt.event.ActionListener;

import javax.swing.JButton;

//swing classes

public class JBarButton extends JButton implements Command
{
   Context context;

   public JBarButton(ActionListener act, Context ctx)
   {
   super("Bar graph");
   addActionListener(act);
   context = ctx;
   }
   public void Execute()
   {
      context.readData("data.txt");
      context.setBarPlot();
      context.plot();
   }
}
