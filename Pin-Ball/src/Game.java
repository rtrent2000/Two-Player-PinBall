import java.applet.Applet;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;

public class Game extends Applet implements Runnable
{
	private static int x = -50, y = -50, dx = 1, dy = 1, radius = 20, 
	secondsPassed = 180, seconds, minutes = 3,
	pot = 0, width = 1366, height = 768;
	private Image i;
	private Graphics doubleG;
	private Dimension d = new Dimension(1366,768);
	private Label timer = new Label("" + secondsPassed);
	private Ball ball;
	private Thread thread = new Thread(this);
	

	public void init()
	{   

	}
	    
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
				x = 5 + radius;
				y = 768 - radius;
				ball = new Ball(radius,x,y);
				thread.start();
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
			ball.moveX();
			ball.moveY();
			x += ball.getDX();
			y += ball.getDY();
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
		g.setColor(Color.GRAY);
	    g.fillOval(x-radius,y-radius,radius*2,radius*2);
	    g.setColor(Color.PINK);
	    g.setFont(new Font("Comic Sans", Font.PLAIN, 18));
	    if (secondsPassed % 60 == 0)
	    	g.drawString("" + minutes + ":" + "00", width/2 - 20,20);
	    else if (seconds != 10 && seconds / 10 == 0)
	    	g.drawString("" + minutes + ":" + "0" + seconds, width/2 - 20,20);
	    else
	    	g.drawString("" + minutes + ":" + seconds, width/2 - 20,20);
	    g.setColor(Color.BLUE);
	    g.fillOval((width/2)-50, (height/2)-50, 100, 100);
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
		thread.stop();
	}
	    
	public void destroy()
	{
	    	
	}

	
}
