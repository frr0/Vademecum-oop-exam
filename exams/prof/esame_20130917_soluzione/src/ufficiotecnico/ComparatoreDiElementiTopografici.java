package ufficiotecnico;

import java.util.Comparator;

public class ComparatoreDiElementiTopografici implements Comparator<ElementoTopografico>{

	public int compare(ElementoTopografico et1, ElementoTopografico et2){
		return et1.getNome().compareTo(et2.getNome());
	}

	
}



