import java.awt.*;
import javax.swing.*;
import java.util.Timer;

public class Game
{
	
	private int secondsPassed = 0;
	private Timer timer = new Timer(); // game timer that pretty much controls E V E R Y T H I N G
	
	private TimerTask fps = new TimerTask() // basic game controls which alters fps and checks user input
		public void run() {
			repaint();
			//check user input
		}
	
	private TimerTask secondCounter = new TimerTask() // counts seconds passed in game
		public void run() {
			secondsPassed ++;
		}
	
	private TimerTask reset = new TimerTask() // resets game at round end (2:00) and also checks for winner
		public void run() {
			
		}
		
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
		timer.scheduleAtFixedRate(fps,17);
		timer.scheduleAtFixedRate(secondCounter,1000);
		timer.scheduleAtFixedRate(reset,);
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
