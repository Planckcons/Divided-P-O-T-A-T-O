
public class Reactor extends ShipParts {

	int max_output;
	double efficiency;
	boolean on;
	Resource fuel_type;
	
	Reactor(int condition, int weight, String name, String type, int array_place, int max_output, double efficiency, Resource fuel_type) 
	{
		super(condition, weight, name, type, array_place);
		// TODO Auto-generated constructor stub
		this.max_output = max_output;
		this.efficiency = efficiency;
		this.fuel_type = fuel_type;
	}

	float output(float power_percent)
	{
		return (power_percent / 100) * max_output;
	}
	
	double fuel_consumption(double output)
	{
		if (on)
			return output*efficiency;
		else 
			return 0;
	}
}
