
public class PosAndMomentum {
	
	float velocity;		// relative to gravity parent
	float direction;	// angle from top
	float position_A;	// distance from parent's surface 
	float position_B;	// angle from top 
	
	PosAndMomentum(float velocity, float direction, float position_A, float position_B)
	{
		this.velocity = velocity;
		this.direction = direction;
		this.position_A = position_A;
		this.position_B = position_B;
	}
	
}
