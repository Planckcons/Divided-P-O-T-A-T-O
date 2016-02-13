
public class Game {
	
	String difficulty;
	static ShipParts[] ship;
	static Resource[] resources;
	static People[] crew;
	Ship ship_;
	ShipStatics stats;
	
	public Game(String difficulty, People[] crew, Resource[] resources, ShipParts[] ship, Ship ship_) 
	{
		// TODO Auto-generated constructor stub
		this.difficulty = difficulty;
		Game.ship = ship;
		Game.resources = resources;
		Game.crew = crew;
		this.ship_ = ship_;
	}
	
	void MainGame()
	{		
		Test test = new Test();
		test.Testest("Is there anybody in there?");
			
		Window game = new Window("Game");
		game.setVisible(true);
		
		stats = new ShipStatics(2000, 1, 1, 1, 1, ship, ship_, resources);

		System.out.println(ship_.engine_tank.fuel_type.amount);
		System.out.println(stats.velocity);
		stats.VelocityChange(6000, 100);
		System.out.println(ship_.engine_tank.fuel_type.amount);
		System.out.println(stats.velocity);
		
	}
	
}
