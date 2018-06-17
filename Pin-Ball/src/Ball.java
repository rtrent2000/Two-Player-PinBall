import java.awt.Rectangle;
import java.util.*;

public class Ball
{
		private final int XGRAV = -1, DEC = 2;
		private int x, y, dx, dy, frameWidth = 1366, frameHeight = 768, radius, xGrav = XGRAV;
	    private ArrayList<Collidable> obstacles;
	    private Rectangle circleRectangle;
	    private static Timer gravTimer;
	    
	    
	    public Ball(int radius1, int x1, int y1, ArrayList<Collidable> poops)
	    {
	    	gravTimer = new Timer();
	    	gravTimer.scheduleAtFixedRate(new TimerTask()
	    	{
				@Override
				public void run()
				{
					// TODO Auto-generated method stub
			        if(x > frameWidth/ 2 )
			        {
			        	xGrav = -XGRAV;
			        }
			        else
			        {
			        	xGrav = XGRAV;
			        }

			        dx += xGrav;
				}
	    		
	    	}, (long)150, (long)150);
	       radius = radius1;
	       x = x1;
	       y = y1; 
	       dx = 0;
	       dy = 0;
	      // obstacles = poops;
	       circleRectangle = new Rectangle( x - radius, y-radius, radius *2, radius *2);
	    }
	    
	    public int getX()
	    {
	        return x;
	    }
	    
	    public int getY()
	    {           
	        return y;
	    }
	    
	    public int getDX()
	    {
	        return dx;
	    }
	    
	    public int getDY()
	    {           
	        return dy;
	    }
	    
	    public int getRadius()
	    {           
	        return radius;
	    }
	    
	    
	    
	    public int moveX()
	    {
	        if(x + dx > frameWidth - radius)    //if the ball hits the right side of the board
	        {
	            x = frameWidth - radius -1;
	            dx =-dx;
	            if (dx < 0)
	            	dx += DEC;
	            else if (dx > 0)
	            	dx -= DEC;
	        }
	        else if(x+dx < 0)
	        {        
	            dx = -dx;
	            x = radius;
	            if (dx < 0)
	            	dx += DEC;
	            else if (dx > 0)
	            	dx -= DEC;
	        }    
	        x += dx;
	        return x;
	        
	        
	    }
	    
	    
	    public int moveY()
	    {
	        
	        
	         
	       if(y+ dy > frameHeight- radius -1)   
	        {
	            y = frameHeight - radius -1;
	            dy =-dy;
	            if (dy < 0)
	            	dy += DEC;
	            else if (dy > 0)
	            	dy -= DEC;
	        }
	        
	        else if(y+dy < 0)
	        {        
	            y = radius;
	            dy = -dy;
	            if (dy < 0)
	            	dy += DEC;
	            else if (dy > 0)
	            	dy -= DEC;
	            //f(x < frame.getWidth()/2 )
	        }     
	        
	        y += dy;
	        return y;
	    }
	    
	    
	    public void collides(GUI g)
	    {
	        
	      
	    
	    }
	    
	    /*public static void sound()
	    {
	    	
	    }*/
	}


	
	
	
	
	
	
	
	
	
	
	

