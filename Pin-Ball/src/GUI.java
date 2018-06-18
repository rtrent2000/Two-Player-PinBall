import java.awt.Rectangle;

public class GUI extends Rectangle
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int angle, radius, x1, x2, y1, y2;
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
		radius = radius1;
	}

	public int getAngle()
	{
		return angle;
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
}
