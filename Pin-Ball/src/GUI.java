import java.awt.Rectangle;

public class GUI extends Rectangle implements Collidable
{

	private int angle;
	
	public GUI(int topLeftX, int topLeftY, int w, int h)
	{
		super(topLeftX,topLeftY,w,h);
	}
	
	public boolean collides(Ball b)
	{
		if(b.getX() + b.getRadius() > x  || b.getX() - b.getRadius() < x)
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
