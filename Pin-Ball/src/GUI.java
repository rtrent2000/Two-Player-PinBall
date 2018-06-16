
public class GUI 
{

	private int x, y, height, width, angle;
	
	public GUI(int topLeftX, int topLeftY, int w, int h)
	{
		x = topLeftX;
		y = topLeftY;
		width =w;
		height = h;
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
