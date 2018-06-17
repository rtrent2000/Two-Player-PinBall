import java.awt.Rectangle;
import java.util.*;

public class Ball
{
		private final int XGRAV = -1, DEC = 2;
		private int x, y, dx, dy, frameWidth = 1366, frameHeight = 768, radius, xGrav = XGRAV;
	    private ArrayList<GUI> obstacles;
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
	       dx = 5;
	       dy = 5;
	       obstacles = poops;
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
	           /* if (dx < 0)
	            	dx += DEC;
	            else if (dx > 0)
	            	dx -= DEC;*/
	        }
	        else if(x+dx < 0)
	        {        
	            dx = -dx;
	            x = radius;
	           /* if (dx < 0)
	            	dx += DEC;
	            else if (dx > 0)
	            	dx -= DEC; */
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
	           /* if (dy < 0)
	            	dy += DEC;
	            else if (dy > 0)
	            	dy -= DEC; 8*/
	        }
	        
	        else if(y+dy < 0)
	        {        
	            y = radius;
	            dy = -dy;
	           /* if (dy < 0)
	            	dy += DEC;
	            else if (dy > 0)
	            	dy -= DEC; */
	            //f(x < frame.getWidth()/2 )
	        }     
	        
	        y += dy;
	        return y;
	    }
	    
	    
	    public void collidesTri(GUI g)
	    {
	    	
	    	
	    	
	    }
	    
	    public void collidesCircle(GUI g)
	    {
	    	
	    	
	    	
	    }
	    
	    public void collides(GUI g)
	    {
	    		/*if(x < g.getX() && y <  &&(x + radius >= g.getX() && y + radius >= g.getY() + ))    //if the ball hits the right side of the board
	    		{
	    			dx=-dx;
	    			x = (int)g.getX();
	    		}
	    		if(y + radius >= g.getY() || )
	    		{        
	    			dy = -dy;
	    			y = (int)g.getY();
	    		}
	        */
	    	if(x < g.getX())
			{
					if((x + radius >= g.getX()) && (y + radius >= g.getY() || y-radius <= g.getY() + g.getHeight())) 
					{
						x = (int)g.getX();
						dx=-dx;
					}
			}
			else if((x - radius <= g.getX() + g.getWidth()) && (y + radius >= g.getY() || y-radius <= g.getY() + g.getHeight()))
			{
				x = (int)g.getX() + (int)g.getWidth();
				dx = -dx;
			}
					
			if(y < g.getY())
				if((x - radius <= g.getX()) && (y + radius >= g.getY()))
				{
						
				}
				else if((x - radius <= g.getX() + g.getWidth()) && (x - radius >= g.getY() + g.getHeight()))		
				{
					
				}
			}
	        
	    }
	}


	
	
	
	
	
	
	
	
	
	
	

