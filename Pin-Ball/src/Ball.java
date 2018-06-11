import java.awt.Rectangle;

public class Ball
{
		private final int XGRAV = -1;
		private int x, y, dx, dy, frameWidth = 1366, frameHeight = 768, radius, xGrav = XGRAV;
	    //private ArrayList<Rectangle> obstacles;
	    private Rectangle circleRectangle;
	    
	    
	    
	    
	    
	    public Ball(int radius, int x1, int y1)//ArrayList<Rectangle> poops)
	    {
	       x = x1;
	       y = y1; 
	       dx = 10;
	       dy = 10;
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
	    
	    
	    
	    public void moveX()
	    {
	    	
	        //if(x > frameWidth/ 2 )
	        //{
	       // 	xGrav += -XGRAV;
	     //   }
	        //xGrav 
	        
	        if(x+ dx > frameWidth- radius)    //if the ball hits the right side of the board
	        {
	            x =frameWidth - radius -1;
	            dx =-dx; 
	            
	        }
	        else if(x+dx < 0)
	        {        
	            
	            dx = -dx;
	            x = radius;
	        }    
	        x += dx;
	    }
	    
	    
	    public void moveY()
	    {
	        
	        
	         
	       if(y+ dy > frameHeight- radius -1)   
	        {
	            y =frameHeight - radius -1;
	            dy =-dy;    
	        }
	        
	        else if(y+dy < 0)
	        {        
	            y = radius;
	            dy = -dy;
	            //f(x < frame.getWidth()/2 )
	        }     
	        
	        y += dy;
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


	
	
	
	
	
	
	
	
	
	
	

