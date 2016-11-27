package br.com.empresa.iterators;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestandoIterador {
	public static void main(String[] args) {

		List<String> letras = new LinkedList<>();
		letras.add("A");
		letras.add("B");
		letras.add("C");
		
		Iterator<String> iterable = letras.iterator();
		
		while(iterable.hasNext()){
			String letra = iterable.next();
			System.out.println(letra);
		}

	}
}