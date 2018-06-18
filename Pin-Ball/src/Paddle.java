import java.awt.geom.Line2D;

public class Paddle extends GUI
{
	private int angle = 0, xCenter, yCenter;
	private double xRotate, yRotate, x, y;
	private Line2D rotated;
	private boolean top, left;
	
	public Paddle(int xCenter1, int yCenter1, int w, int h, boolean t, boolean l) {
		super(xCenter1, yCenter1, w, h); 
		top = t;
		setIsPaddle(true);
		
		
		if(top && left)
		{
			xCenter = xCenter1 + w;
			yCenter = yCenter1;
			y = yCenter + h;
		}
		else if (top)
		{
			xCenter = xCenter1;
			yCenter = yCenter1;
			y = yCenter + h;
		}
		else if (left)
		{
			xCenter = xCenter1;
			yCenter = yCenter1 + h;
			y = yCenter;
		}
		else
		{
			xCenter = xCenter1 + w;
			yCenter = yCenter1 + h;
			y = yCenter;
		}
		
		xRotate = xCenter + Math.cos(angle) * (x - xCenter) - Math.sin(angle) * (y - yCenter);
		yRotate = yCenter + Math.sin(angle) * (x - xCenter) + Math.cos(angle) * (y - yCenter);
		rotated = new Line2D.Double(x,y,xRotate,yRotate);
		// TODO Auto-generated constructor stub
	}
	
	public Line2D getRotated()
	{
		x = xRotate;
		y = yRotate;
		xRotate = xCenter + Math.cos(angle) * (x - xCenter) - Math.sin(angle) * (y - yCenter);
		yRotate = yCenter + Math.sin(angle) * (x - xCenter) + Math.cos(angle) * (y - yCenter);
		rotated = new Line2D.Double(x,y,xRotate,yRotate);
		return rotated;
	}
	
	public boolean getTop()
	{
		return top;
	}
	
	public boolean getLeft()
	{
		return left;
	}
	
	public void setAngle(int angle1)
	{
		angle = angle1;
	}
}
