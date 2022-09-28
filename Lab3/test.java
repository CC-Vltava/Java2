package tutorial.lab3;

import java.util.Arrays;
import java.util.List;

public class test {
	interface A {
		
		int aMethod(String s);
		
	}
	public static void main(String[] args) {
		List<String> words = Arrays.asList("Java", "Python", "C", "C++", "JavaScript");
		String x = words.stream()
				.reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2) .orElse("");
		System.out.println(x);
	}
	
}
