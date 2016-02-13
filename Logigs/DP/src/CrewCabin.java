
public class CrewCabin extends ShipParts{

	int crew_amount;
	
	CrewCabin(int condition, int weight, String name, String type, int array_place, int crew_amount) {
		super(condition, weight, name, type, array_place);
		// TODO Auto-generated constructor stub
		this.crew_amount = crew_amount;
	}
}
