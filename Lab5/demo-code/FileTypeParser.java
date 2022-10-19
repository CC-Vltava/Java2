package tutorial.lab5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileTypeParser {
	public static void main(String[] args) throws IOException {
		while(true){
			Scanner scanner = new Scanner(System.in);
			String fileName = scanner.next();
			FileInputStream fileInputStream = new FileInputStream(fileName);
			byte[] header = fileInputStream.readNBytes(4);
			System.out.println("File Name: " + fileName);
			System.out.print("File Header: ");
			for(int i = 0; i < 4; i++)
				System.out.printf("%2X", header[i]);
			System.out.print("\nFile Type: " + (header[0] == -54 ? "class" : header[0] == -119 ? "png" : "zip or jar"));
		}
	}
}
