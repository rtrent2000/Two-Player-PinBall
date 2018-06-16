import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;

public class Game extends Applet implements Runnable
{
	private static int x = -50, y = -50, dx = 1, dy = 1, radius = 20, 
	secondsPassed = 180, seconds, minutes = 3,
	pot = 10;
	private static final int WIDTH = 1366, HEIGHT = 768;
	private Image i;
	private Graphics doubleG;
	private Dimension d = new Dimension(WIDTH,HEIGHT), goalDimension = new Dimension(0,0);
	private Label timer = new Label("" + secondsPassed);
	private Ball ball;
	private Thread thread = new Thread(this);
	private boolean RTP = false,RTPM = false, RBP = false,RBPM = false, LTP = false,LTPM = false, LBP = false, LBPM = false, reset = true;
	private Scanner sc = new Scanner(System.in);
	private Timer paddles = new Timer();
	
	//FIGURE OUT A WAY TO USE GRAPHICS 2D FOR PADDLES AND JUST PADDLES

	public void start()
	{
		setSize(300,700);
		setBackground(Color.BLUE);
		Label title = new Label("Pinball VS");
		Button button1 =  new Button("Start!");
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				remove(title);
				remove(button1);
				setSize(d);
				setBackground(Color.BLACK);
				x = WIDTH/2 + 10;
				y = HEIGHT/2;
				goalDimension = new Dimension(40, 200);
				ball = new Ball(radius,x,y);
				thread.start();
			}});
		add(title);
		add(button1);
	} 
	    
	public void run()
	{
		Timer gameTimer = new Timer();
		Timer userInput = new Timer();
		
		gameTimer.schedule(new TimerTask()
		{
			@Override
			public void run() 
			{
				// TODO Auto-generated method stub\
				stop();
			}
		},(long)190000);
		
		gameTimer.scheduleAtFixedRate(new TimerTask()
		{
			@Override
			public void run() 
			{
				// TODO Auto-generated method stub
				secondsPassed --;
				minutes = secondsPassed / 60;
				seconds = secondsPassed % 60;
			}
		}, (long)1000, (long)1000);
		
		userInput.scheduleAtFixedRate(new TimerTask()
		{
			@Override
			public void run() 
			{
				keyPressed(sc.next());
			}
		}, (long)17, (long)17);
		
		while(true) {		
			x = ball.moveX();
			y = ball.moveY();
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  	
	}
	    
	public void paint(Graphics g)
	{
		//(xpos,ypos,xlength,ylength)
		
		//goals
	    g.setColor(Color.RED);
	    g.drawRect(1326, 294, (int)goalDimension.getWidth(), (int)goalDimension.getHeight());
	    g.drawRect(0, 294, (int)goalDimension.getWidth(), (int)goalDimension.getHeight());
	    
	    //goal barriers
	    g.setColor(Color.BLUE);
	    g.fillRect(1326, 0, 40, 295);
	    g.fillRect(1326, 294 + (int)goalDimension.getHeight(), 40, 294);
	    g.fillRect(0, 0, 40,295);
	    g.fillRect(0, 294 + (int)goalDimension.getHeight(), 41, 294);
	    
	    //paddles
	    
	    g.setColor(Color.WHITE);
	    g.fillRect(40, 294, 20, 65);
	    AffineTransform oldLTP = ((Graphics2D) g).getTransform();
        ((Graphics2D) g).rotate(Math.toRadians(45));
        ((Graphics2D) g).setTransform(oldLTP);
        
	    g.fillRect(40, 294 + (int)goalDimension.getHeight()-65, 20, 65);
	    AffineTransform oldLBP = ((Graphics2D) g).getTransform();
        ((Graphics2D) g).rotate(Math.toRadians(45));
        ((Graphics2D) g).setTransform(oldLBP);
        
	    g.fillRect(1366 - 60, 294, 20, 65);
	    AffineTransform oldRTP = ((Graphics2D) g).getTransform();
        ((Graphics2D) g).rotate(Math.toRadians(45));
        ((Graphics2D) g).setTransform(oldRTP);
        
	    g.fillRect(1366 - 60, 294 + (int)goalDimension.getHeight()-65, 20, 65);
	    AffineTransform oldRBP = ((Graphics2D) g).getTransform();
        ((Graphics2D) g).rotate(Math.toRadians(45));
        ((Graphics2D) g).setTransform(oldRBP);
	    g.drawLine(1366/2, 0, 1366/2, 768);
	    
	    //ball
		g.setColor(Color.GRAY);
	    g.fillOval(x-radius,y-radius,radius*2,radius*2);
	    
	    //timer
	    g.setColor(Color.YELLOW);
	    g.fillRect( WIDTH/2 - 22, 0, 40, 25);
	    g.setColor(Color.BLACK);
	    g.setFont(new Font("Comic Sans", Font.PLAIN, 18));
	    if (secondsPassed % 60 == 0)
	    	g.drawString("" + minutes + ":" + "00", WIDTH/2 - 20,20);
	    else if (seconds != 10 && seconds / 10 == 0)
	    	g.drawString("" + minutes + ":" + "0" + seconds, WIDTH/2 - 20,20);
	    else
	    	g.drawString("" + minutes + ":" + seconds, WIDTH/2 - 20,20);
	}
	    
	public void update(Graphics g)
	{
	    if(i == null)
	    {
	    	i = createImage(this.getSize().width, this.getSize().height);
	    	doubleG = i.getGraphics();
	    }
	    
	    doubleG.setColor(getBackground());
	    doubleG.fillRect(0,0,this.getSize().width,this.getSize().height);
	    doubleG.setColor(getForeground());
	    paint(doubleG);
	    g.drawImage(i,0,0,this);
	}

	@SuppressWarnings("deprecation")
	public void stop()
	{
		seconds = 0;
		thread.stop();
	}
	    
	public void destroy()
	{
	    	
	}

	public void keyPressed(String key) {
	    switch (key){
	        case "a":
	        case "A":
	            LTP = true;
	            LTPM = true;
	            break;
	        case "d":
	        case "D":
	        	LBP = true;
	        	LBPM = true;
	        	break;
	        case "j":
	        case "J":
	        	RBP = true;
	        	RBPM = true;
	        	break;
	        case "l":
	        case "L":
	        	RTP = true;
	        	RTPM = true;
	        	break;
	        default:
	        	sc = null;
	        	break;
	    }
	}
}
