package tutorial.lab3.tutorial.lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P3 {
	public static boolean check(int val){
		for(int i = 2; i * i <= val; i++)
			if(val % i == 0)
				return false;
		return true;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true){
		System.out.println("Please input the function No:\n" +
				"1 - Get even numbers\n" +
				"2 - Get odd numbers\n" +
				"3 - Get prime numbers\n" +
				"4 - Get prime numbers that are bigger than 5\n" +
				"0 - Quit\n");
		int type = scanner.nextInt();
		if(type == 0)
			return ;
		System.out.println(
				"Input size of the list:\n");
		int len = scanner.nextInt();
		System.out.println(
				"Input elements of the list:\n");
		ArrayList<Integer> ans = new ArrayList<>();
		int[] array = new int[len];
		for(int i = 0; i < len; i++)
			array[i] = scanner.nextInt();
		if(type <= 2)
		{
			type--;
			int cnt = 0;
			for(int i = 0; i < len; i++)
				if(array[i] % 2 == type)
					ans.add(array[i]);
		}
		else
		{
			int cnt = 0;
			for(int i = 0; i < len; i++)
				if(check(array[i]) && (type == 3 || array[i] > 5))
					ans.add(array[i]);
		}
		System.out.println(
				"Filter results:\n" );
		System.out.println(ans);
	}}
}

