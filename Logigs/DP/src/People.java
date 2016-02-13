public class People 
{

	private String name;
	private String job;
	private int age;
	private int crew_num;

	People(String name, String job, int age, int crew_num) 
	{
		this.name = name;
		this.job = job;
		this.age = age;
		this.crew_num = crew_num;
	}

	void TestRun()
	{
		System.out.print("name: " + name + " ");
		System.out.print("  age: " + age + " ");
		System.out.print("  job: " + job + " ");
		System.out.println("  crew number: " + crew_num);
	}
	
	public int getAge() {
		return age;
	}
	public int getCrew_num() {
		return crew_num;
	}
	public String getJob() {
		return job;
	}
	public String getName() {
		return name;
	}
	
}
