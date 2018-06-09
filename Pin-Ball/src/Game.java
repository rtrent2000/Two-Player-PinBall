import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.Color;
import java.util.*;
import java.util.Timer;

public class Game extends JApplet
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
	    
	    public static void main(String[] args)
	    {
	        JFrame startup = new JFrame("Pinball VS");
	        startup.setSize(500,700);
	        startup.setResizable(false);
	        startup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        
	        JButton start = new JButton("Start!");
	        start.addActionListener(new ActionListener()
	        {
	            public void actionPerformed (ActionEvent e)
	            {
	                start();
	            }
	        });
	        
	        JPanel panel = new JPanel();
	        startup.add(panel);
	        JLabel label = new JLabel("PINBALL VS");
	        panel.setBackground(Color.BLACK);
	        panel.add(label);
	        panel.add(start);
	        startup.setVisible(true);
	        
	        // lets put highscores here
	    }
	    
	    public void start()
	    {
	        timer.scheduleAtFixedRate(fps,(long)17,(long)17);
	        timer.scheduleAtFixedRate(secondCounter,(long)1000,(long)1000);
	        timer.scheduleAtFixedRate(reset,120000,120000);
	        JFrame game = new JFrame("Pinball VS");
	        JPanel panel = new JPanel();
	        game.setSize(1366,768);
	        game.setResizable(false);
	        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        game.setVisible(true);
	    }
	    
	    
	    public void paint(Graphics g)
	    {
	    	super.paint(g);
	    	g.fillOval(x-radius,y-radius,radius*2,radius*2);
	    }
	    
	    public void update()
	    {
	        
	    }

	    private static void end()
	    {
	        
	    }
	    
}
