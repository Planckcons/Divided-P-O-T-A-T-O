
public class Ship {
	
	Engine engine;
	Reactor reactor;
	Tank engine_tank;
	Tank reactor_tank;
	CrewCabin cabin1;
	CrewCabin cabin2;
	
	Ship(Engine engine, Reactor reactor, Tank engine_tank, Tank reactor_tank, CrewCabin cabin1, CrewCabin cabin2) {

		this.engine = engine;
		this.reactor = reactor;
		this.engine_tank = engine_tank;
		this.reactor_tank = reactor_tank;
		this.cabin1 = cabin1;
		this.cabin2 = cabin2;
	
	}

}
