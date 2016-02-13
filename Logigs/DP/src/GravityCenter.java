
public class GravityCenter{

	double mass;
	double radius;
	
	GravityCenter(double velocity, double direction, double position_A, double position_B, double mass, double radius, GravityCenter parent) 
	{
		// TODO Auto-generated constructor stub
		this.mass = mass;
		this.radius = radius;
	}
	GravityCenter (double position_A, double position_B, double mass, double radius) 
	{
		// TODO Auto-generated constructor stub
		this.mass = mass;
		this.radius = radius;
	}

}
