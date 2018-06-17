import java.awt.Rectangle;

public class GUI extends Rectangle implements Collidable
{

	private int angle, radius, x1, x2, y1, y2, width, height;
	private boolean isCircle =false;
	private boolean isTriangle = false;
	private boolean isGoal = false;
	private boolean isPaddle = false;
	private Rectangle hitbox;
	
	public GUI(int topLeftX, int topLeftY, int w, int h)
	{
		super(topLeftX,topLeftY,w,h);
		hitbox = new Rectangle(topLeftX,topLeftY,w,h);
	}
	
	public GUI(int centerX, int centerY, int radius1)
	{
		super(centerX - radius1,centerY - radius1,2*radius1, 2*radius1);
		hitbox = new Rectangle(centerX - radius1,centerY - radius1,2*radius1, 2*radius1);
		isCircle = true;
		radius = radius1;
	}
	
	public GUI(int x11, int x21, int y11, int y21,boolean doggo)
	{
		//hitbox = new Rectangle()			//figure out how to rotate later
		x1 = x11;
		x2 = x21;
		y1 = y11;
		y2 = y21;
		isTriangle = true;
	}
	
	//public void collides(Ball b) //rectangle
	//{
		/*if(b.getX() < x)
		{
			if(b.getY() < y)
				if((b.getX() + b.getRadius() >= x) && (b.getY() + b.getRadius() >= y))
				{
					return true;
				}
			else if((b.getX() + b.getRadius() >= x) && (b.getY() - b.getRadius() >= y + height))		
			{
				return true;
			}
		}
		else
		{
			if(b.getY() < y)
				if((b.getX() - b.getRadius() <= x +width) && (b.getY() + b.getRadius() >= y))
				{
					return true;
				}
			else if((b.getX() - b.getRadius() <= x + width) && (b.getY() - b.getRadius() >= y + height))		
			{
				return true;
			}
		}
		return false; */
	
		
		
	//}
	
		
	public boolean collidesCircle(Ball b)
	{
		if(b.getX() + b.getRadius() + radius > x        //checks if ball is close enough to the bumper to consider touching 
				&& b.getX() < x + b.getX() + radius
				&& b.getY() + b.getRadius() + radius > y 
				&& b.getY() < y + b.getRadius() + radius)
		{
			return true;
		}
		return false;
	}
	
	public boolean collidesTri(Ball b)
	{
		//if()
		//{
		//	return true;
		//}
		return false;
	}
	
	
	public int getAngle()
	{
		return angle;
	}
	
	
	public int getHeightTri()
	{
		return height;
	}
	
	
	public int getWidthTri()
	{
		return width;
	}
	
	public void setAngle(int angle1)
	{
		angle = angle1;
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
	
	public boolean getIsCircle()
	{
		return isCircle;
	}
	
	public boolean getIsTriangle()
	{
		return isTriangle;
	}
	
	public boolean getIsGoal()
	{
		return isGoal;
	}
	
	public void setIsGoal(boolean doggo)
	{
		isGoal = doggo;
	}
	
	public boolean getIsPaddle()
	{
		return isPaddle;
	}
	
	public void setIsPaddle(boolean doggo)
	{
		isPaddle = doggo;
	}

	public Rectangle getRect()
	{
		return hitbox;
	}

	@Override
	public boolean collides(Ball b) {
		// TODO Auto-generated method stub
		return false;
	}
}
