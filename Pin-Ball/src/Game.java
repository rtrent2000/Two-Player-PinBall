import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;

public class Game
{
	 private static int secondsPassed = 0, p1Wins = 0, p2Wins = 0, p1Score = 0, p2Score = 0, pot = 0;
	    private static Timer timer = new Timer(); // game timer that pretty much controls E V E R Y T H I N G
	    
	    private static TimerTask fps = new TimerTask(){ // basic game controls which alters fps and checks user input
	        public void run() {
	            repaint();
	            //check user input
	        }
	    };
	    
	    private static TimerTask secondCounter = new TimerTask()
	    {// counts seconds passed in game
	        public void run() {
	            secondsPassed ++;
	        }
	    };
	    
	    private static TimerTask reset = new TimerTask()
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
	        startup.setSize(500,700);
	        startup.setResizable(false);
	        startup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        startup.setVisible(true);
	        
	        JButton start = new JButton("Start!");
	        start.addActionListener(new ActionListener()
	        {
	            public void actionPerformed (ActionEvent e)
	            {
	                start();
	            }
	        });
	        JLabel label = new JLabel("PINBALL VS");
	        JPanel panel = new JPanel();
	        startup.add(panel);
	        panel.add(label);
	        panel.add(start);
	        // lets put highscores here
	    }
	    
	    private static void start()
	    {
	        timer.scheduleAtFixedRate(fps,(long)17,(long)17);
	        timer.scheduleAtFixedRate(secondCounter,(long)1000,(long)1000);
	        timer.scheduleAtFixedRate(reset,120000,120000);
	        JFrame game = new JFrame("Pinball VS");
	        game.setSize(1366,768);
	        game.setResizable(false);
	        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        game.setVisible(true);
	        paint();
	    }
	    
	    
	    private static void paint()
	    {
	    }
	    
	    private static void repaint()
	    {
	        update();
	        paint();
	    }
	    
	    private static void update()
	    {
	        
	    }

	    private static void end()
	    {
	        
	    }
	    
}
