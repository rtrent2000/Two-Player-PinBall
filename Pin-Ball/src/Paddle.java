
public class Paddle extends GUI implements Collidable
{
	private int angle;
	public Paddle(int topLeftX, int topLeftY, int w, int h) {
		super(topLeftX, topLeftY, w, h); 
		// TODO Auto-generated constructor stub
	}
	
	
	public void setAngle(int angle1)
	{
		angle = angle1;
	}
}
