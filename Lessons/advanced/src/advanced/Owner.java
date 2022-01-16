package advanced;
public class Owner {

	private String firstname;
	private String lastname;
	private int age;

	//Car ownedCar = new Car(); // If just one Car owned

	// If more than one, array that will contain the Car objects

 							 // Number of cars possibly owned by this Owner
	private Car ownedCars[]; // = new Car[4]; 
	
	                 // Variable that keeps track of cars actually owned at a certain time
	private int num; // = 0; 
	
	public Owner(String firstname, String lastname, int age) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		               // Better to initialize the data structure and the counter variable here
		ownedCars = new Car[4]; // Once created, the array cells are all at null
		num = 0;
	}

	// I can generate the getter/setter methods using the Eclipse's wizard

	// A getter/setter methods pair for each attribute, here
	// Not mandatory, e.g., if external access not needed
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// Also the array can be made accessible via getter/setter methods
	
	public Car[] getOwnedCars() {
		return ownedCars;
	}

	public void setOwnedCars(Car[] ownedCars) {
		this.ownedCars = ownedCars;
	}
	
	// Method used to delegate to the Owner the assignment of a new Car

	// Advantage deriving from the availability of a dedicated method

	// 1) Factorize instructions
	// 2) Concentrate code in a precise, single point (maintenance)
	// 3) Possibility to introduce, e.g., controls (error checks)
	
	public void addNewCar(Car c) { 
		
		if(num==4) // Check that number of cars is not too high
			return;
		
		ownedCars[num++] = c; // If ok, insert
		
		//num++;
		
	}
	
	
	
	
}
