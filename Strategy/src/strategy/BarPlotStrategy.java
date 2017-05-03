package strategy;
import java.awt.Color;

public class BarPlotStrategy extends PlotStrategy
{
   BarPlotPanel bp;
   public BarPlotStrategy()
   {
      super("Bar Plot");
      bp = new BarPlotPanel();
      getContentPane().add(bp);
   }
   //--------------------------------------
   public void plot(float xp[], float yp[])
   {
      x = xp;  y = yp;        //copy in data
      findBounds();           //find maxes and mins
      setSize(width, height);
      setVisible(true);       //show frame
      bp.setBackground(Color.white);
      bp.setBounds(minX, minY, maxX, maxY);
      bp.plot(x, y, Color.black);   //plot data
     
   }
}

