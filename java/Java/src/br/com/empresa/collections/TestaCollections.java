package br.com.empresa.collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TestaCollections {
	
	public static void main(String[] args) {
		
		List<ContaPoupanca> contas = new LinkedList<ContaPoupanca>();
		
		Conta conta1 = new ContaPoupanca(3, "Joao");
		Conta conta2 = new ContaPoupanca(1, "Jose");
		Conta conta3 = new ContaPoupanca(4, "Jair");
		
		Random random = new Random();
		
		conta1.setSaldo(random.nextInt(1000) + random.nextDouble());
		conta2.setSaldo(random.nextInt(1000) + random.nextDouble());
		conta3.setSaldo(random.nextInt(1000) + random.nextDouble());
		
		
		contas.add((ContaPoupanca) conta1);
		contas.add((ContaPoupanca) conta2);
		contas.add((ContaPoupanca) conta3);
		
		 Collections.sort(contas);
		 
		 for(ContaPoupanca conta : contas){
			 System.out.println(conta.getNumero() + " " + conta.getSaldo());
		 }
		 
		 System.out.println(contas);
	}
}
