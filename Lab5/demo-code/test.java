package tutorial.lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class test {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("demo-code/test.txt");
		Scanner scanner = new Scanner(file);
		int n = scanner.nextInt();
		double sum = 0;
		for(int i = 1; i <= n; i++)
			sum += scanner.nextDouble();
		System.out.println(sum);
		
		PrintWriter writer = new PrintWriter("demo-code/out.txt");
		writer.println(sum);
		writer.close();
	}
}
