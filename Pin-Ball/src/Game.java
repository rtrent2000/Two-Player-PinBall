import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.util.Timer;

public class Game
{
	  private int secondsPassed = 0, p1Wins = 0, p2Wins = 0, p1Score = 0, p2Score = 0, pot = 0;
	  private Timer timer = new Timer(); // game timer that pretty much controls E V E R Y T H I N G
	    
	    private TimerTask fps = new TimerTask() 
	    { // basic game controls which alters fps and checks user input
	        public void run() {
	            repaint();
	            //check user input
	        }
	    };
	    
	    private TimerTask secondCounter = new TimerTask()
	    {// counts seconds passed in game
	        public void run() {
	            secondsPassed ++;
	        }
	    };
	    
	    private TimerTask reset = new TimerTask()
	    { // resets game at round end (2:00) and also checks for winner and adds to player score
	        public void run() 
	        {
	            if (p1Score > p2Score)
	                p1Wins++;
	            else if (p2Score > p1Score)
	                p2Wins++;
	            
	            if ((p1Wins == 2) || (p2Wins == 2))
	                end();
	        }
	    };
	        
	    public static void init()
	    {
	        JFrame startup = new JFrame("Pinball VS");
	        startup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        Container c = startup.getContentPane();
	        c.setBackground(Color.GRAY);
	        Dimension d = new Dimension(300,500);
	        c.setPreferredSize(d);
	        startup.setResizable(false);
	        startup.setVisible(true);
	    }
	    
	    public void start()
	    {
	        timer.scheduleAtFixedRate(fps,(long)17,(long)17);
	        timer.scheduleAtFixedRate(secondCounter,(long)1000,(long)1000);
	        //timer.scheduleAtFixedRate(reset,);
	        paint();
	        asdfasdf
	        
	        
	    }
	    
	    
	    public void paint()
	    {
	    
	    }
	    
	    public void repaint()
	    {
	        
	    }
	    
	    public void update()
	    {
	        
	    }

	    public void end()
	    {
	        
	    }
}
