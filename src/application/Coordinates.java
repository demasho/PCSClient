package application;

public class Coordinates {
	int x,y,z;
	
	public Coordinates(int xx,int yy,int zz)
	{
		x=xx;
		y=yy;
		z=zz;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int getZ()
	{
		return z;
	}
	public void setX(int xx)
	{
		x=xx;
	}
	public void setY(int yy)
	{
		y=yy;
	}
	public void setZ(int zz)
	{
		z=zz;
	}
}
