
public class ShipStatics extends PosAndMomentum {

	float velocity;			// relative to gravity parent
	float direction; 		// angle of velocity from top (rad)
	float ship_direction;	// angle of ship from top (rad)
	float position_A;		// distance from parent's surface 
	float position_B;		// angle from top 
	int weight;				// in kg
	Ship ship_;
	ShipParts[] ship;
	Resource[] resources;
	
	ShipStatics(float velocity, float direction, float position_A, float position_B, float ship_direction,ShipParts[] ship, Ship ship_, Resource[] resources) {
		super(velocity, direction, position_A, position_B);
		// TODO Auto-generated constructor stub
		this.velocity = velocity;
		this.direction = direction;
		this.position_A = position_A;
		this.position_B = position_B;
		this.ship_direction = ship_direction;
		this.ship_ = ship_;
		this.ship = ship;
		this.resources = resources;
		
		weight = Weight(0, 100);
	}
	
	int Weight(int thrust_time, int power_percent)
	{
		for(int i = 0; i < ship.length; i++)
		{
			weight += ship[i].weight;
		}

		int resource_weight = 0;
		
		for(int i = 0; i < resources.length; i++)
		{			
			if(resources[i].name == ship_.engine.fuel_type.name)
			{
				int weight_begin = (int) (resources[i].amount * resources[i].density);
				int weight_end = (int) ((resources[i].amount - ship_.engine.fuel_consumption(ship_.engine.thrust(power_percent)) * thrust_time) * resources[i].density);
								
				resource_weight += (weight_begin + weight_end)/2; 
			}
			resource_weight += resources[i].amount * resources[i].density;
		}
		
		weight += resource_weight;
		
		return weight;
	}
	
	float VelocityChange(int thrust_time, int power_percent)  //m/s
	{
		float velocity_change;
		
		velocity_change = (ship_.engine.thrust(power_percent)/Weight(thrust_time, power_percent))*thrust_time;
		
		for(int i = 0; i < resources.length; i++)
		{
			if(resources[i].name == ship_.engine.fuel_type.name)
			{
				Game.resources[i].amount -= ship_.engine.fuel_consumption(ship_.engine.thrust(power_percent)) * thrust_time;
			}
		}		
		
		return velocity_change;
	}
	
	Resource ResourceGet(String name)
	{
		Resource a = null;
		
		for(int i = 0; i < resources.length; i++)
		{
			if(resources[i].name == name)
			{
				a = resources[i];
			}
		}
		return a;
	}

}
