package advanced;
public class CarApplication {

	// This is the application class, with a main()
	
	public static void main(String[] args) {

		// If I want to use the Car class, I need to create in another
		// class (e.g., this one) objects/instances of that class
		
		Car c1 = new Car(); // I am using the "empty" constructor of Car

		// How to print object's "content"?
		
		System.out.println(c1); // With this instruction, I am printing the 
								// reference, e.g., Car@2f0e140b

		// In order to print values of attributes, I need to access them ...

		// ... though they may not be accessible, for reading, with dot notation
		
		//System.out.println(c1.color);
		//System.out.println(c1.brand);
		//System.out.println(c1.turnedOn);
		
		// I can use the (public) method defined to that purpose, e.g.,

		System.out.println(c1.getColor());

		// Printing object's values accessing each attribute individually
		// is correct, SYNTACTICALLY, BUT CONCEPTUALLY I should FACTORIZE
		// accesses in a single point, a method, and call that method to
		// DELEGATE to the object the task of printing itself ("who better
		// than the object is able to ..."
		
		c1.printState();

		// As expected, attributes received an initialization
		// it can be the default one or the programmer-defined
		// one, depending on the constructor that is used
		
		// Same for setting the attributes (writing access), it may not be possible with 
		// dot notation ... and I SHOULDN'T DO THAT WAY, I SHALL USE CONSTRUCTORS
		
		// c1.color="Orange";
		
		// I can also use (public) methods to set attributes' value
		c1.setColor("Yellow");
		
		c1.paint("Orange");

		// I have more than one method for setting the color
		
		// c1.paint();

		// Now, printing again the object's content I should see different values
		
		//System.out.println(c1.color);
		//System.out.println(c1.brand);
		//System.out.println(c1.turnedOn);
		c1.printState();

		// I can create other objects of type Car

		Car c2 = new Car("Green","Fiat",true); // Here I am using the constructor that initializes 
		                                       // attributes using parameters received
		
		c2.printState(); // We DELEGATE to object c2  the operation of printing itself
		                 // through the invocation of a METHOD (better than accessing
		                 // all its attributes by myself using dot notation)
		
		Car c3 = new Car("Pink","Lamborghini",true);
		
		// Now, how to create a collection of Car objects
		
		                          // When created, it is a set of cell at null
		Car cars[] = new Car[10]; // [null][null][null][null][null]..[null]
		
		cars[0] = c1;
		cars[1] = c2;
		cars[2] = c3;
		cars[3] = new Car(); // new Car("Yellow","Porsche",true);
		
		// Printing of the arry using a for cycle
		
		System.out.println("-------- FOR ---------");
		for(int i=0;i<cars.length;i++) {
			//System.out.println(cars[i]);
			if(cars[i]!=null)	       // Better to check first that cell is not at null to avoid a NullPointerException
				cars[i].printState();  // If cell is not null, then I print it
		}
		
		// Alternative way for iterating, e.g., on an array, using a for-each cycle
		
		System.out.println("-------- FOR EACH ---------");
		
		// This construct allows me to iterate on arrays, without using counter variables
		
		// How to read it?
		
		for( Car c : cars ) { // For each Car c in cars (till the end of the array)
			// When in the cycle, in c we do have one of the objects in the cars array
			if(c!=null) // Here c "corresponds" to one temporary cell of the array
				c.printState();			
		}
		
		// How to manage RELATIONS between objects, e.g., car owned by a owner (and viceversa)
		
		// I can represent owners with a class (e.g., Owner), and create objects of that class
		
		Owner o1 = new Owner("John","Doe",99);

		// Then, define an attribute of type Owner in car and set it to create "connections"
		
		// c3.owner = o1; // Sets the Owner John Doe as owner of Car c3
		
		c3.setOwner(o1); // Using the setter method, if the attribute is not accessible because private
		
		// How to say, viceversa, that John Doe owns a car, c3 in this case?

		// I could create an attribute of type Car in the Owner, to define the connection

		// o1.ownedCar = c3;
		
		// If a owner can own more than one car, I should define an array of Car objects rather than a single variable

		// But then, in order to know where to insert the car (which index 
		// in the array of cars of the Owner) I need to known how many cars are there already

		// o1.ownedCars[0] = c3; // Which index to use?

		// I may try avoiding the index by searching for the first empty cell in the array of cars
		
		/*for(int i=0;i<4;i++) {
			if(o1.ownedCars[i]==null) { // This cell is empty, I can insert the car here
				o1.ownedCars[i] = c3;
				break; // Leave the iteration as soon as one cell has been set
			}
		}*/

		// But, still, I need to know how many cell the array has, and I need to
		// be able to access the array, which may (should have been) be defined as private
		
		// Even with getter/setter methods, working on the array of ownedCars
		// would be complex, difficult to read, and inefficient
		
		o1.getOwnedCars()[0]=c3;
		o1.setOwnedCars(o1.getOwnedCars());
		
		// THIS IS BECAUSE / THE INTUITION IS THAT ...
		// ... IT IS NOT MY JOB "TOUCHING" THIS ARRAY, I SHOULD USE
		// DELEGATION, IT SHOULD BE THE JOB OF THE OWNER TO DO THAT
		
		// I can define a method, in the Owner class, that takes 
		// the received Car object and manages to insert it in the array
		
		o1.addNewCar(c3);
		
		// Similarly, should I want to print the cars owned by an owner
		
		// I can write something like this ... it works ...
		
		for(int i=0; i<o1.getOwnedCars().length;i++) {
			if(o1.getOwnedCars()[i]!=null)
				o1.getOwnedCars()[i].printState();
		}
		
		// ... but, much better delegate the printing to the Owner object
	    // which of course should provide a method to that purpose
		
		
		
		
	}

}
