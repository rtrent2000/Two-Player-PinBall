import java.awt.Rectangle;
import java.util.*;


public class Ball
{
		private final int XGRAV = -1, DEC = 0;
		private int x, y, dx, dy, frameWidth = 1366, frameHeight = 768, radius, xGrav = XGRAV;
	    private static Timer gravTimer;
	    private Rectangle circleRect;
	    
	    
	    public Ball(int radius1, int x1, int y1, ArrayList<GUI> poops)
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
	       dx = 20;
	       dy = 20;
	       circleRect = new Rectangle(x -radius, y - radius, 2*radius, 2 *radius);
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
	    
	    public Rectangle getRect()
	    {
	    	return circleRect;
	    	
	    	
	    }
	    
	    public boolean canAccelerate()
		{
	    	return  (dx < 30   &&  dx >20) && (dy < 30 && dy > 20);
		}

	    public int moveX()
	    {

	    	if(x + dx > frameWidth - radius)    //if the ball hits the right side of the board
	   		{
	   			x = frameWidth - radius -1;
	   			dx =-dx;
	   			if(canAccelerate())
    			{		    			
	   				if (dx < 0)
		    			dx += DEC;
		   			else if (dx > 0)
		   				dx -= DEC;
	    		}
	   		}
	   		else if(x+dx < 0)
	   		{        
	   			dx = -dx;
    			x = radius;	 
    			if(canAccelerate())
    			{
    				if (dx < 0)
    					dx+= DEC;
    				else if (dx > 0)
    					dx -= DEC; 
    			}
	   		}
	    	x += dx;
	    	circleRect = new Rectangle(x -radius, y - radius, 2*radius, 2 *radius);
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
		          
		    }
	        y += dy;
	        circleRect = new Rectangle(x -radius, y - radius, 2*radius, 2 *radius);
	        return y;
	    }
	    
	    public void setX(int x1)
	    {
	    	x = x1;
	    }
	    
	    public void setY(int y1)
	    {
	    	y = y1;
	    }
	    
	    public void setDX(int x1)
	    {
	    	dx = x1;
	    }
	    
	    public void setDY(int y1)
	    {
	    	dy = y1;
	    }
	 
}


	
	
	
	
	
	
	
	
	
	
	

