public class Test 
{
	
	void Testest(String woords) 
	{
		System.out.println(woords);
		for (int i = 0; i < GameSet.crew_amount; i++) 
		{
			Game.crew[i].TestRun();
		}
		
	}
}
