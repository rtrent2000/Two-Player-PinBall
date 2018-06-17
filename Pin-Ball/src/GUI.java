import java.awt.Rectangle;

public class GUI extends Rectangle implements Collidable
{

	private int angle, radius;
	
	public GUI(int topLeftX, int topLeftY, int w, int h)
	{
		super(topLeftX,topLeftY,w,h);
	}
	
	public boolean collides(Ball b)
	{
		if((b.getX() + b.getRadius() > x  || b.getX() - b.getRadius() < x) && (b.getY() < y && b.getY +height))
		{
			
			return true;
			
		}
		else if(b.getX() + b.getRadius() + radius > x        //checks if ball is close enough to the bumper to consider touching 
				&& b.getX() < x + b.getX() + radius
				&& b.getY() + b.getRadius() + radius > y 
				&& b.getY() < y + b.getRadius() + radius)
		{
			
			return true;
		}
		return false;
		
	}
	
	public int getAngle()
	{
		return angle;
	}
	
}
