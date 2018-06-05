import java.awt.*;
import javax.swing.*;

public class Game extends Thread
{
	
	public void init()
	{
		JFrame f = new JFrame("Pinball VS");
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container c = f.getContentPane();
		c.setBackground(Color.GRAY);
		Dimension d = new Dimension(200,500);
		c.setPreferredSize(d);
		f.setResizable(false);
		f.setVisible(true);
	}
	
	public void start()
	{
	
	}
	
	public void run()
	{
		
	}
	
	public void paint()
	{
	
	}
	
	public void update()
	{
		
	}
	
	}

	public void end()
	{
		
	}
	
}
