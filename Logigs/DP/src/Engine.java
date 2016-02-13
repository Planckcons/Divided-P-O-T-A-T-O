
public class Engine extends ShipParts {

	float max_thrust;			// N
	float specific_impulse;		// m/s
	Resource fuel_type;		
	boolean on;
	
	Engine(int condition, int weight, String name, String type, int array_place, float max_thrust, float specific_impulse, Resource fuel_type) 
	{
		super(condition, weight, name, type, array_place);
		// TODO Auto-generated constructor stub
		this.specific_impulse = specific_impulse; 	
		this.max_thrust = max_thrust;				
		this.fuel_type = fuel_type;
	}
	
	float thrust(float power_percent)		//Ulos moottorista
	{	
		if (power_percent < 0)
			return 0;
		else if (power_percent > 100)
			return 0;
		else
			return (power_percent / 100) * max_thrust;
	}
	
	float fuel_consumption(float thrust)	//kg/s
	{
		return thrust/specific_impulse;
	}
}
