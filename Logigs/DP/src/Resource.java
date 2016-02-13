
public class Resource {
	
	int amount;		// m³
	double density;	// kg/m³
	String name;
	
	Resource(int amount, String name, double density)
	{
		this.amount = amount;
		this.name = name;
		this.density = density;
		++GameSet.resource_count;
	}
	
	void ChangeAmount(int amount)
	{
		this.amount += amount;
	}	
}
