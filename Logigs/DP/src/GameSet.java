import java.util.Random;

public class GameSet {
	
	boolean setted = false;
	static int part_count;
	static int max_parts = 6;
	static int resource_amount = 2;
	static int resource_count;	
	static int basic_resources = 0;
	static int crew_amount;
	static int min_age = 10;
	static int age_range = 40;
	static String[] names = 
		{
		"James", "Douglas", "Otto", "John", "Sarah",
		"Ann", "Ellen", "Marie", "Kyle", "Jess" 
		};
	static String[] jobs = 
		{
		"Pilot", "Scientist", "Engineer", "Doctor" 
		};
	String part_type;
	static ShipParts[] ship = new ShipParts[max_parts];
	static People[] crew;
	
	static Resource engine_fuel = new Resource(-1, "Xenon", 29);
	static Resource reactor_fuel = new Resource(-1, "Hydrogen", 7);
	static Resource[] resources = {
			engine_fuel, reactor_fuel
	};
	
	Engine engine = new Engine(100, 100, "Frecking warp drive", "Engine", 0, 100000, 2000, resources[0]);
	Engine[] engines = {
			engine
	};
	Reactor reactor = new Reactor(100, 100, "Fusion-man", "Reactor", 0, 100000, 0.9, resources[1]);
	Reactor[] reactors = {
			reactor
	};
	Tank engine_tank = new Tank(100, 100, "Engine fuel tank", "Tank", 0, 50, engine.fuel_type);
	Tank reactor_tank = new Tank(100, 100, "Reactor fuel tank", "Tank", 1, 1000, reactor.fuel_type);
	Tank[] tanks = {
		engine_tank, reactor_tank
	};
	CrewCabin cabin1 = new CrewCabin(100, 30, "Basic cabin n.1", "Crew cabin", 0, 20);
	CrewCabin cabin2 = new CrewCabin(100, 30, "Basic cabin n.2", "Crew cabin", 1, 20);
	CrewCabin[] cabins = {
			cabin1, cabin2
	};
		
	public void setPart_type(String part_type) {
		this.part_type = part_type;
	}
	public String getPart_type() {
		return part_type;
	}

	void ShipSet()
	{
		if(part_count < max_parts)
		{	
			if(part_type == "Cab")
			{
				int a = 0;
				switch(a)
				{
				case 0:
					ship[part_count] = cabins[0];
					part_count++;
					crew_amount += cabins[0].crew_amount;
					a++;
					break;
				case 1:
					ship[part_count] = cabins[1];
					part_count++;
					crew_amount += cabins[1].crew_amount;
					a++;
					break;
				}
				part_type = null;
				System.out.println("Part added");
			}
			else if(part_type == "Engine")
			{
				ship[part_count] = engines[0];
				part_count++;
				
				ship[part_count] = tanks[0];
				part_count++;
				
				resources[0].amount = engine_tank.volume;

				part_type = null;
				System.out.println("Part added");
			}
			else if(part_type == "Reactor")
			{
				ship[part_count] = reactors[0];
				part_count++;
				
				ship[part_count] = tanks[1];
				part_count++;
				
				resources[1].amount = reactor_tank.volume;

				System.out.println("Here" + this.reactor.name);
				
				part_type = null;
				System.out.println("Part added");
			}
		}
		else
		{
			setted = true;
		}
		
		if (setted)
		{
			CrewSet();
			StartGame();
		}
	}
	
	void CrewSet()
	{
		crew = new People[crew_amount];
		
		for (int i = 0; i < crew_amount; i++) 
		{
			People person = new People(NameSet(), JobSet(), AgeSet(), i);
			crew[i] = person;
		}	
		System.out.println("CS");
	}
	
	void StartGame()
	{
		Ship ship_;
		
		ship_ = shipSet(ship);
		
		System.out.print(ship[1].name + " " + ship[1].type + " " + ship_.cabin1.name + " ");
		Game game_main = new Game("A lot", crew, resources, ship, ship_);
		
		game_main.MainGame();
	}
	
	Ship shipSet(ShipParts[] ship)
	{
		Engine engine = null;
		Reactor reactor = null;
		CrewCabin cabin1 = null;
		CrewCabin cabin2 = null;
		Tank engine_tank = null;
		Tank reactor_tank = null;
		
		for(int i = 0; i < ship.length; i++)
		{
			switch(ship[i].type)
			{
			case "Engine":
				engine = engines[ship[i].array_place];
				break;
			case "Reactor":
				reactor = reactors[ship[i].array_place];
				break;
			case "Tank":
				if(ship[i].array_place == 0)
				{
					engine_tank = tanks[ship[i].array_place];
					break;
				}
				else if(ship[i].array_place == 1)
				{
					reactor_tank = tanks[ship[i].array_place];
					break;
				}
			case "Crew cabin":
				if(ship[i].array_place == 0)
				{
					cabin1 = cabins[ship[i].array_place];
					break;
				}
				else if(ship[i].array_place == 1)
				{
					cabin2 = cabins[ship[i].array_place];
					break;
				}
			}
		}
		Ship s = new Ship(engine, reactor, engine_tank, reactor_tank, cabin1, cabin2);
		
		return s;
	}
	
	static String NameSet() 
	{
		String name;
		Random rn = new Random();
		name = names[rn.nextInt(names.length)];
		return name;
	}
	
	static String JobSet()
	{
		String job;
		Random rn = new Random();
		job = jobs[rn.nextInt(jobs.length)];
		return job;	
	}

	static Integer AgeSet() 
	{
		int age;
		Random rn = new Random();
		age = rn.nextInt(age_range) + min_age;
		return age;
	}
}
