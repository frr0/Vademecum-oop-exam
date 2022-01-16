package myList;

public class LogLista {
	protected Object array[];
	protected int contatore;
	protected int moltiplicatore;
	protected boolean monoType;
	protected Class type;
	
	public LogLista() {
		this.array = new Object[1];
		this.contatore = 0;
		this.moltiplicatore = 2;
		this.monoType = false;
	}
	
	public LogLista(int moltiplicatore) {
		this.array = new Object[1];
		this.contatore = 0;
		this.moltiplicatore = moltiplicatore;
		this.monoType = false;
	}
	
	public LogLista(int moltiplicatore, Class type) {
		this.array = new Object[1];
		this.contatore = 0;
		this.moltiplicatore = moltiplicatore;
		this.monoType = true;
		this.type = type;
	}
	
	public boolean add(Object newObject) {
		//Create new array
		if (this.monoType && this.type != newObject.getClass()) {
			return false;
		}
		if (this.contatore + 1 > this.array.length) {
			int newLength = this.moltiplicatore * this.array.length;
			Object newArray[] = new Object[newLength];
			System.arraycopy(this.array, 0, newArray, 0, this.array.length);
			this.contatore++;
			newArray[this.contatore - 1] = newObject;
			this.array = newArray;
			return true;
		} else {
			this.contatore++;
			this.array[this.contatore - 1] = newObject;
			return true;
		}
	}
	
	public int totalLength() {
		return this.array.length;
	}
	
	public boolean add(Object[] newObjectList) {
		for (Object newObject: newObjectList) {
			if (this.monoType && this.type != newObject.getClass()) {
				return false;
			}
			if (this.contatore + 1 > this.array.length) {
				int newLength = this.moltiplicatore * this.array.length;
				Object newArray[] = new Object[newLength];
				System.arraycopy(this.array, 0, newArray, 0, this.array.length);
				this.contatore++;
				newArray[this.contatore - 1] = newObject;
			} else {
				this.contatore++;
				this.array[this.contatore - 1] = newObject;
			}
		}
		return true;
	}


//descriviti
	public String toString() {
		String res = "[";
		for (int i=0; i<this.contatore; i++) {
			res += " " + array[i].toString() + ",";
		}
		res = res.substring(0, res.length() - 1);
		res += "]";
		return res;
	}

//dimensione
	public int length(){
		return this.contatore;
	}

//contiene
	public boolean contains(Object otherObject) {
		for (int i=0; i<this.contatore; i++) {
			if (this.array[i].equals(otherObject)) {
				return true;
			}
		}
		return false;
	}
	
	public int index(Object otherObject) {
		for (int i=0; i<this.contatore; i++) {
			if (this.array[i].equals(otherObject)) {
				return i;
			}
		}
		return -1;
	}
	
	public Object getElement(int index) {
		if(index < this.contatore) {
			return this.array[index];
		} else {
			return null;
		}
	}
	
}





