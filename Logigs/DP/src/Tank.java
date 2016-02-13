
public class Tank extends ShipParts {

	int volume;				// m³
	Resource fuel_type;
	
	Tank(int condition, int weight, String name, String type, int array_place, int volume, Resource fuel_type) {
		super(condition, weight, name, type, array_place);
		// TODO Auto-generated constructor stub
		this.fuel_type = fuel_type;
		this.volume = volume;
	}
	
	
	
}
