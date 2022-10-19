package practice.lab4;//package practice.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class test {
	
	public static <E> E add(E e1, E e2) {
		return e1;
	}
	
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> results = new ArrayList<>();
		for (T s : list) {
			if (p.test(s)) {
				results.add(s);
			}
		}
		return results;
	}
	
	public static <T> void forEachh(List<T> list, Consumer<T> c) {
		for (T s : list) {
			c.accept(s);
		}
	}
	
	public static <T, R> List<R> mapp(List<T> list, Function<T,R> f){
		List<R> results = new ArrayList<>();
		for(T s : list){
			results.add(f.apply(s));
		}
		return results;
	}
	
	public static void main(String[] args) {
		List <String> listOfStrings = new ArrayList<>();
		listOfStrings.add("11");
		listOfStrings.add("321");
		listOfStrings.add("faasfsd");
		Predicate<String> comp = (s) -> s.length() > 2;
		List <String> newStrings = filter(listOfStrings, comp);
//		for(String s : newStrings)
//			System.out.println(s);
		forEachh(newStrings, System.out::print);
		
		List<Integer> listStrLen2 = mapp(newStrings, String::length);
		
		System.out.println(listStrLen2);
	}
}
