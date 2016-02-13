
public class ShipParts {
	
	int condition;
	int weight;
	int array_place;
	String name;
	String type;

	ShipParts(int condition, int weight, String name, String type, int array_place)
	{
		this.condition = condition;
		this.name = name;
		this.type = type;
		this.weight = weight;
		this.array_place = array_place;
	}
	
	void ConditionChange(int amount)
	{
		condition += amount;
	}

}
