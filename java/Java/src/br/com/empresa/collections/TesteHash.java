package br.com.empresa.collections;

import java.util.ArrayList;
import java.util.TreeSet;

public class TesteHash {
	public static void main(String[] args) {
		TreeSet<Integer> tree = new TreeSet<>();

		for (int i = 0; i < 1000; i++) {
			tree.add(i);
		}

		for (Integer x : tree.descendingSet()) {
			System.out.print(x + " ");
		}

		ArrayList<Integer> array = new  ArrayList<Integer>();

		for (int i = 1000; i > 0; i--) {
			array.add(i);
		}

		System.out.println();
		
		for (Integer x : array) {
			System.out.print(x + " ");
		}
	}
}
