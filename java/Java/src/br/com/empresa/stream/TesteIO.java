package br.com.empresa.stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TesteIO {
	public static void main(String[] args) throws IOException {
		
		InputStream inputStream = System.in;
		Scanner scanner = new Scanner(inputStream);
		
		OutputStream outputStream = new FileOutputStream("saida.txt");
		PrintStream printStream = new PrintStream(outputStream);
		
		while(scanner.hasNextLine()){
			printStream.append(scanner.nextLine());
			printStream.println();
		}
		
		scanner.close();
		printStream.close();
	}
}