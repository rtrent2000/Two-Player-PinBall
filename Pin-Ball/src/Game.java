import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;

public class Game extends Applet implements Runnable
{
	private static final long serialVersionUID = 1L;
	private static int x = -50, y = -50, radius = 20, 
	secondsPassed = 180, seconds, minutes = 3,
	LTPa = -10, LBPa = -10, RTPa = -10, RBPa = -10,
	LTPma = -10, LBPma = -10, RTPma = -10, RBPma = -10,
	LTinc = 3, LBinc = 3, RTinc = 3, RBinc = 3;
	private static final int WIDTH = 1366, HEIGHT = 768;
	private Image i;
	private Graphics doubleG;
	private Dimension d = new Dimension(WIDTH,HEIGHT), goalDimension = new Dimension(0,0);
	private Ball ball;
	private Thread thread = new Thread(this);
	//private GUI lGoal = new GUI(), GUI rGoal = new GUI();
	private Paddle LT = new Paddle(40, 294, 20, 73), LB = new Paddle(40, 286 + (int)goalDimension.getHeight()+ 135, 20, 73),
	RT = new Paddle(1366 -  60, 294, 20, 73), RB = new Paddle(1366 - 60, 286 + (int)goalDimension.getHeight() +135, 20, 73);

	public void start()
	{
		setSize(300,700);
		setBackground(Color.BLUE);
		setFocusable(true);
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
		addKeyListener(new KeyListener() 
		{
		public void keyPressed(KeyEvent e)
		{
			// TODO Auto-generated method stub
			switch(e.getKeyCode())
			{
			case KeyEvent.VK_A:
				LTPma = 30;
				break;
			case KeyEvent.VK_D:
				LBPma = 30;
				break;
			case KeyEvent.VK_RIGHT:
				RTPma = 30;
				break;
			case KeyEvent.VK_LEFT:
				RBPma = 30;
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
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
		
		while(true) {		
			x = ball.moveX();
			y = ball.moveY();
			for(int i =0; collidables.size()-1; i++)//if this doesnt work delete this part until the next comment
			{
				if(collidables.get(i).getIsTriangle())
				{
					if(collidables.get(i).collidesTri())
						ball.collidesTri(collidables.get(i));
				}
				else if(collidables.get(i).getIsCircle())
				{
					if(collidables.get(i).collidesCircle())
						ball.collidesCircle(collidables.get(i));
				}
				else
				{
					if(collidables.get(i).collides())
						ball.collides(collidables.get(i));
				}
			}									//
			if (LTPma != -10)
			{
				LTPa += LTinc;
				if (LTPa >= LTPma)
				{
					LTinc *= -1;
				}
				else if(LTPa == -10 && LTinc < 0)
				{
					LTinc *= -1;
					LTPma = -10;
				}
			}
			else if(LBPma != -10)
			{
				LBPa += LBinc;
				if (LBPa >= LBPma)
				{
					LBinc *= -1;
				}
				else if(LBPa == -10 && LBinc < 0)
				{
					LBinc *= -1;
					LBPma = -10;
				}
			}
			else if(RTPma != -10) 
			{
				RTPa += RTinc;
				if (RTPa >= RTPma)
				{
					RTinc *= -1;
				}
				else if(RTPa == -10 && RTinc < 0)
				{
					RTinc *= -1;
					RTPma = -10;
				}
			}
			else if(RBPma != -10)
			{
				RBPa += RBinc;
				if (RBPa >= RBPma)
				{
					RBinc *= -1;
				}
				else if(RBPa == -10 && RBinc < 0)
				{
					RBinc *= -1;
					RBPma = -10;
				}
			}
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
		//goals
	    g.setColor(Color.RED);
	    g.drawRect(1326, 294, (int)goalDimension.getWidth(), (int)goalDimension.getHeight());
	    g.drawRect(0, 294, (int)goalDimension.getWidth(), (int)goalDimension.getHeight());
	    
	    //goal barriers
	    g.setColor(Color.BLUE);
	    g.fillRect(1306, 0, 60, 295);
	    g.fillRect(1306, 294 + (int)goalDimension.getHeight(), 60, 294);
	    g.fillRect(0, 0, 60,295);
	    g.fillRect(0, 294 + (int)goalDimension.getHeight(), 61, 294);
	    
	    //paddles
	    Graphics2D g2d = (Graphics2D)g;
	    g.setColor(Color.WHITE);
	    
	    //paddles rotate test
	    AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(-LTPa),LT.getX() + LT.getWidth(), LT.getY());
        g2d.fillRect((int) LT.getX(),(int) LT.getY(),(int) LT.getWidth(),(int) LT.getHeight());
        g2d.setTransform(old);
        
        old = g2d.getTransform();
        g2d.rotate(Math.toRadians(LBPa),LB.getX() + LB.getWidth(), LB.getY() + LB.getHeight());
        g2d.fillRect((int) LB.getX(),(int) LB.getY(),(int) LB.getWidth(),(int) LB.getHeight());
        g2d.setTransform(old);
        
        old = g2d.getTransform();
        g2d.rotate(Math.toRadians(RTPa),RT.getX(), RT.getY());
        g2d.fillRect((int) RT.getX(),(int) RT.getY(),(int) RT.getWidth(),(int) RT.getHeight());
        g2d.setTransform(old);
        
        old = g2d.getTransform();
        g2d.rotate(Math.toRadians(-RBPa),RB.getX(), RB.getY() + RB.getHeight());
        g2d.fillRect((int) RB.getX(),(int) RB.getY(),(int) RB.getWidth(),(int) RB.getHeight());
        g2d.setTransform(old);
        
        //center line
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

}
