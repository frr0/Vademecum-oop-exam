package advanced;
// Defines the structure of 
// possible Car objects 
// (created using new in another file)

public class Car {     
	// Attributes / Data 
	private String color; // "Internals", INFORMATION HIDING
	private String brand; // GOLDEN RULE / EURISTICS, define them as private
	private boolean turnedOn; // Important to inizialize attributes, but not here
	
	// When adding private in front of an attribute, it won't be
	// visible anymore from outside the class, it will only be
	// possible to access it via methods (defined as public)
	
	// Where should I create objects of type Car?
	// Certainly, not in the Car.java file ... 
	// Another file, e.g., CarApplication.java

	
	// Should I want to record information about the owner of the car
	// I may think about adding the owner's attributes here
	
	//String firstname
	//String lastname
	//int age
	
	// But, following the ABSTRACTION principle of OOP, it would
	// be definitely better to define a Owner class, in another file
	// and add an attribute to the Car class to define the link between the two
	
	private Owner owner; // I created a connection between the car and its owner
	
	// CONSTRUCTOR(S), PARTICULAR TYPE OF METHODS, SAME 
	// NAME OF THE CLASS, NO RETURN VALUE, MEANT TO 
	// CREATE AN OBJECT OF THAT CLASS AND INITIALIZE IT
	
	// MULTIPLE CONSTRUCTORS POSSIBLE (DIFFERENT SIGNATURES)
	
	// This is what the DEFAULT constructor
	// would look like (it is added automatically
	// by Java, I don't need to rewrite it like that)
	
	/*
	public Car(){
		color = null; // Default initializations
		brand = null;
		turnedOn = false;
	}*/
	
	
	// I can re-define it to implement different initializations 
	// E.g., all cars red, Ferrari, turned off 
	
	public Car(){
		color = "Red"; // Custom initialization
		brand = "Ferrari";
		turnedOn = false;
	}
	
	// I can also add other constructors, in OVERLOADING
	// with the same NAME, but different SIGNATURE
	public Car(String color, String brand, boolean turnedOn) {
		this.color = color;
		this.brand = brand;
		this.turnedOn = turnedOn;
		// this means THIS OBJECTS
		// Used to solve ambiguities in names
	}

	// I can also use Eclipse's wizard to automatically create
	// constructors, also choosing how many parameters to include
	
	// E.g., with less parameters
	public Car(String brand, boolean turnedOn) {
		this.brand = brand;
		this.turnedOn = turnedOn;
		// color? It is not necessary to receive parameters to 
		//        initialize all attributes, I may also initialize
		//        them in other ways, but it is advised to initialize them all
	}

	// OTHER METHODS
	
	void paint(String c) {
		// With a method, we can manage ERROR checking
		// if(String c is empty)
		// then ....
		// else
		
		color = c;   // Then, it can take parameter c
		             // and assigns it to attribute color
	}
	
	// Same name, different behavior, in this case it does
	// not receive any parameter, it "simply" sets color always to white
	
	void paint() {
		color = "White";
	}
	
	// Methor for printing in the console the state of the object
	// intended as the values of all its attributes
	
	void printState() {
		// BETTER THAN ACCESSING EACH ATTRIBUTE SEPARATELY (ASSUMED THAT
		// IT IS EVEN POSSIBLE, THEY MAY BE PRIVATE), I DELEGATE
		// TO THE OBJECT THE DUTY OF DESCRIBING ITSELF, POSSIBLY
		// RETURNING A String RATHER THAN PRINTING IN THE CONSOLE

		// With a method we can FACTORIZE common use operations 
		// (and IN CASE OF ERRORS or MAINTENAINCE NEEDS this
		// is the ONLY PLACE where we may implement CHANGES)
				
									// The method can access the object's attributes, 
		                            // they are visible, even in case they are defined as private
		System.out.println("Color: "+color+" Brand: "+brand+" Turned on/off: "+turnedOn);
		// E.g., we may change the string above to use Italian in place of English, and
		// all occurrences of this printing operation would be changed to Italian
	}
	
	// GETTER / SETTER METHODS (to provide public access to private attributes)
	
	public String getColor() { // Makes the private color attribute "readable"
		return color; 
	}
	
                      // String color
	public void setColor(String c) { // Sets the private color attribute, making it "writable"
		// this.color = color;
		color = c; // THE KEYWORD this CAN BE USE TO AVOID AMBIGUITIES
        		   // WITH this I REFER TO THIS OBJECT, TO ATTRIBUTES OF THIS OBJECT,
                   // LIKE this.color, DISTINGUISHING FROM POSSIBLE 
                   // PARAMETERS WITH THE SAME NAME   
	}
	
    public Owner getOwner(){  
	    return owner;          	
	}

	public void setOwner(Owner owner) {
		if(owner!=null)	// Example of a possible error check (any instruction)
			this.owner=owner;
	}
	
	// I can also use Eclipse's wizard also to automatically create
	// also all the getter/setter methods for all attributes
	
}
