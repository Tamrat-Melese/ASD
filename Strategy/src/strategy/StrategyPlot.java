package strategy;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;


public class StrategyPlot extends JxFrame
   implements ActionListener
{
   Context context;
//--------------------------------------------   
   public StrategyPlot()
   {
      super("Strategy Plots");
      JPanel jp = new JPanel();
      getContentPane().add(jp);
      context  = new Context();
      jp.add(new JBarButton(this, context));
      jp.add(new JGraphButton(this, context));
      setSize(new Dimension(300, 200));
      setVisible(true);
   }
//--------------------------------------------
   public void actionPerformed(ActionEvent e)
   {
      Command comd =(Command)e.getSource();
      comd.Execute();
   }
//--------------------------------------------
   static public void main(String[] argv)
   {
      new StrategyPlot();
   }
}
