import java.awt.Rectangle;

public class GUI extends Rectangle implements Collidable
{

	private int radius, x1, x2, y1, y2, width, height;
	boolean isCircle =false;
	boolean isTriangle = false;
	
	
	public GUI(int topLeftX, int topLeftY, int w, int h)
	{
		
		super(topLeftX,topLeftY,w,h);
	}
	
	public GUI(int centerX, int centerY, int radius1)
	{
		super(centerX - radius1,centerY - radius1,2*radius1, 2*radius1);
		isCircle = true;
		radius = radius1;
	}
	
	public GUI(int x11, int x21, int y11, int y21, boolean dog)
	{
		x1 = x11;
		x2 = x21;
		y1 = y11;
		y2 = y21;
		isTriangle = true;
	}
	
	
	
	public boolean collides(Ball b)
	{
		if(b.getX() < x)
		{
			if((b.getX() + b.getRadius() > x  ) && (b.getY() +b.getRadius() > y && b.getY() +height))
			{
				return true;
			}
		}
		else if((b.getX() - b.getRadius() < x) && (b.getY() < y && b.getY() +height))
		{
			
			return true;
			
		}
		else if(isCircle == true &&(b.getX() + b.getRadius() + radius > x        //checks if ball is close enough to the bumper to consider touching 
				&& b.getX() < x + b.getX() + radius
				&& b.getY() + b.getRadius() + radius > y 
				&& b.getY() < y + b.getRadius() + radius))
		{
			return true;
		}
		return false;
	}
	
	
	public int getHeightTri()
	{
		return height;
	}
	
	
	public int getWidthTri()
	{
		return width;
	}
	
	public int getX1()
	{
		return x1;
	}
	
	
	public int getX2()
	{
		return x2;
	}
	
	
	public int getY1()
	{
		return y1;
	}
	
	public int getY2()
	{
		return y2;
	}
	
	public int getRadius()
	{
		return radius;
	}
}
