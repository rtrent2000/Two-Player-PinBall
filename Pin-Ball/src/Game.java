//import statements
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.Arrays;

public class Game extends Applet implements Runnable
{
	private static final long serialVersionUID = 1L;
	private int rnd = (int) (Math.random() * 2 + 1);
	//Player scores are set to 0
	private int pot = 0, player1 = 0, player2 = 0;
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
	private Goals lGoal = new Goals(0, 294, (int)goalDimension.getWidth(), (int)goalDimension.getHeight()),
	rGoal = new Goals(1326, 294, (int)goalDimension.getWidth(), (int)goalDimension.getHeight());
	private GUI LTC = new GUI(381,182,40), LBC = new GUI(381, 596, 40), RTC = new GUI(1003,182,40), RBC = new GUI(1003,596,40),
	TR = new GUI(532,244,302,60), BR = new GUI(532,464,302,60), LTB = new GUI(0, 0, 60,295),LBB = new GUI(0, 294 + (int)goalDimension.getHeight(), 61, 294),
	RTB = new GUI(1306, 0, 60, 295),RBB = new GUI(1306, 294 + (int)goalDimension.getHeight(), 60, 294);
	private Paddle LT = new Paddle(40, 294, 20, 65, true, true), LB = new Paddle(40, 286 + (int)goalDimension.getHeight()+ 143, 20, 65, false, true),
	RT = new Paddle(1366 -  60, 294, 20, 65, true, false), RB = new Paddle(1366 - 60, 286 + (int)goalDimension.getHeight() +143, 20, 65, false, false);
	private ArrayList<GUI> collidables = new ArrayList<GUI>(Arrays.asList(LTB, LBB, RBB, RTB, LTC,LBC,RTC,RBC,TR,BR,LB,LT,RB,RT,lGoal,rGoal));
	private boolean gameIsOver = false, display = false;

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
				if(rnd == 1)
				{
					x = WIDTH/2 - 10;
				}
				else
				{
					x = WIDTH/2 + 10;
				}
				y = 40;
				goalDimension = new Dimension(40, 200);
				ball = new Ball(radius,x,y,collidables);
				display = true;
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
			for(int i =0; i < collidables.size() ; i++)		//goes through all collidables
			{
				if (!collidables.get(i).getIsGoal() && !collidables.get(i).getIsPaddle())		//if it is any obstacle other than goal
				{
					if(ball.getRect().getBounds().intersects(collidables.get(i).getRect().getBounds()))	//if the ball intersects with object
					{
						if(x <= collidables.get(i).getX()  )			//if the ball is coming from the left
						{
							ball.setDX(-ball.getDX());
							x = (int) collidables.get(i).getX() + ball.getDX();
							ball.setX(x);
						}
						else if(x > collidables.get(i).getX() + collidables.get(i).getWidth())	//if the ball is coming from the right
						{
							ball.setDX(-ball.getDX());
							x = (int) (collidables.get(i).getX() + collidables.get(i).getWidth() + ball.getDX());
							ball.setX(x);
						}
						else if(y <= collidables.get(i).getY()) 	//if the ball is coming from above
						{
							ball.setDY(-ball.getDY());
							y = (int) collidables.get(i).getY() + ball.getDY();
							ball.setY(y);
						}
						else //the ball is coming from below
						{
							ball.setDY(-ball.getDY());
							y = (int) (collidables.get(i).getY() + collidables.get(i).getHeight() + ball.getDY());
							ball.setY(y);
						}
						
						pot += 10;
					}	
				}
				else if(collidables.get(i).getIsGoal())
				{
					if (ball.getRect().getBounds().intersects(collidables.get(i).getRect().getBounds()))
					{
						if(x < WIDTH / 2)
						{
							player2 += pot;
							pot = 0;
							x = WIDTH/2 - 10;
							ball.setDX(0);
							ball.setDY(0);
						}
						else
						{
							player1 += pot;
							pot = 0;
							x = WIDTH/2 + 10;
							ball.setDX(0);
							ball.setDY(0);
						}
						
						pot = 0;
					
					}
				}
				else if(collidables.get(i).getIsPaddle())
				{
					if(ball.getRect().getBounds().intersectsLine(((Paddle) collidables.get(i)).getRotated()))
					{
						
						//if((Paddle)collidables.get(i).getLeft())
							x -= ball.getDX();;
							y -= ball.getDY();;
							ball.setX(x);
							ball.setY(y);
							ball.setDX(-ball.getDY());
							ball.setDY(-ball.getDX());
					}
				}
			}
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
				LT.setAngle(LTPa);
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
				LB.setAngle(LBPa);
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
				RT.setAngle(RTPa);
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
				RB.setAngle(RBPa);
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
		if(gameIsOver)
		{
			display = false;
			setBackground(Color.WHITE);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Comic Sans", Font.PLAIN, 100));
			if (player1 > player2)
			{
				g.drawString("Player 1 WINS!!", 50, HEIGHT/2);
			}
			else if (player1 < player2)
			{
				g.drawString("Player 2 WINS!!", 50, HEIGHT/2);
			}
			else
			{
				g.drawString("You Both Lose", 50, HEIGHT/2);
			}
			thread.stop();
		}
		
		if(display)
		{
			//goals
			g.setColor(Color.RED);
			g.fillRect(1326, 294, (int)goalDimension.getWidth(), (int)goalDimension.getHeight());
			g.setColor(Color.CYAN);
			g.fillRect(0, 294, (int)goalDimension.getWidth(), (int)goalDimension.getHeight());
	    
	    
			//goal barriers and other
			g.setColor(Color.BLUE);
			g.fillRect(1306, 0, 60, 295);
			g.fillRect(1306, 294 + (int)goalDimension.getHeight(), 60, 294);
			g.fillRect(0, 0, 60,295);
			g.fillRect(0, 294 + (int)goalDimension.getHeight(), 61, 294);
			g.setColor(Color.MAGENTA);
			g.fillOval((int)LTC.getX(), (int)LTC.getY(), LTC.getRadius()*2 , LTC.getRadius()*2);
			g.fillOval((int)LBC.getX(), (int)LBC.getY(), LBC.getRadius()*2 , LBC.getRadius()*2);
			g.fillOval((int)RTC.getX(), (int)RTC.getY(), RTC.getRadius()*2 , RTC.getRadius()*2);
			g.fillOval((int)RBC.getX(), (int)RBC.getY(), RBC.getRadius()*2 , RBC.getRadius()*2);
			g.setColor(Color.GREEN);
			g.fillRect((int)TR.getX(),(int)TR.getY(),(int)TR.getWidth(),(int)TR.getHeight());
			g.fillRect((int)BR.getX(),(int)BR.getY(),(int)BR.getWidth(),(int)BR.getHeight());
	    
			//paddles
			Graphics2D g2d = (Graphics2D)g;
			g.setColor(Color.WHITE);
			
			//paddles rotate
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
			g.fillRect( 1240, 0, 100, 25);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Comic Sans", Font.PLAIN, 18));
			if (secondsPassed % 60 == 0)
				g.drawString("" + minutes + ":" + "00", WIDTH/2 - 20,20);
			else if (seconds != 10 && seconds / 10 == 0)
				g.drawString("" + minutes + ":" + "0" + seconds, WIDTH/2 - 20,20);
			else
				g.drawString("" + minutes + ":" + seconds, WIDTH/2 - 20,20);
			g.drawString("Pot: " + pot,  1240 , 20 );
		}
		
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
		gameIsOver = true;
	}
	   

}
