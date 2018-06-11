import java.awt.Rectangle;
import java.util.*;

public class Ball
{
		private final int XGRAV = -2;
		private int x, y, dx, dy, frameWidth = 1366, frameHeight = 768, radius, xGrav = XGRAV;
	    //private ArrayList<Rectangle> obstacles;
	    private Rectangle circleRectangle;
	    private static Timer gravTimer;
	    
	    
	    
	    public Ball(int radius, int x1, int y1)//ArrayList<Rectangle> poops)
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
	    		
	    	}, (long)100, (long)100);
	       x = x1;
	       y = y1; 
	       dx = 0;
	       dy = 0;
	      // obstacles = poops;
	       circleRectangle = new Rectangle( x - radius, y-radius, radius *2, radius *2);
	    }
	        
	    public int getDX()
	    {
	        return dx;
	    }
	    
	    public int getDY()
	    {           
	        return dy;
	    }
	    
	    
	    
	    public int moveX()
	    {
	    	
	        
	        if(x + dx > frameWidth - radius)    //if the ball hits the right side of the board
	        {
	            x = frameWidth - radius -1;
	            dx =-dx;
	        }
	        else if(x+dx < 0)
	        {        
	            dx = -dx;
	            x = radius;
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
	        }
	        
	        else if(y+dy < 0)
	        {        
	            y = radius;
	            dy = -dy;
	            //f(x < frame.getWidth()/2 )
	        }     
	        
	        y += dy;
	        return y;
	    }
	    
	    
	   // public rectangle collides()
	    //{
	        
	      //  for(int i = 0; i < obstacles.size() -1; i++)
	      //  {
	      //      if(.intersects(obstacles.get(i));)
	      //      {
	      //          obstacles.get(i);
	            
	            
	      //      }
	     //   }
	    
	    //}
	}


	
	
	
	
	
	
	
	
	
	
	

