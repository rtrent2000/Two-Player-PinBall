import java.awt.Rectangle;

public class Ball
{


		private int x, y, dx, dy, frameWidth = 1366, frameHeight = 768;
	    private final int radius =  20 , xGrav =  2;
	    //private ArrayList<Rectangle> obstacles;
	    private Rectangle circleRectangle;
	    public Ball()//ArrayList<Rectangle> poops)
	    {
	       x =50;
	       y =25; 
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
	    
	    
	    
	    public int moveX()
	    {
	        
	        if(x+ dx > frameWidth- radius)    //if the ball hits the right side of the board
	        {
	            x =frameWidth - radius -1;
	            dx =-dx; 
	            return x;
	        }
	        
	        else if(x+dx < 0)
	        {        
	            
	            dx = -dx;
	            x = radius;
	            return x;
	            //f(x < frame.getWidth()/2 )
	        }    
	        
	        return x + dx;
	    }
	    
	    
	    public int moveY()
	    {
	        
	        
	            
	       if(y+ dy > frameHeight- radius)   
	        {
	            y =frameHeight - radius -1;
	            dy =-dy;    
	            return y;
	        }
	        
	        else if(y+dy < 0)
	        {        
	            y = radius;
	            dy = -dy;
	            return y;
	            //f(x < frame.getWidth()/2 )
	        }     
	        
	        return y + dy;
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


	
	
	
	
	
	
	
	
	
	
	
	
}
