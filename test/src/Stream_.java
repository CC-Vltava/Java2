import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_ {
	public static void main(String[] args) {
		
		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
		Stream<Integer> stream = integerList.stream();
		System.out.println(stream.max((a, b) -> a > b ? 1 : -1));
//		stream.toList();
		
		Stream<String> echos = Stream.generate(() -> "Echo").limit(20);
		System.out.println(echos.toList());
		Stream<Double> randoms = Stream.generate(Math::random).limit(5);
		randoms.forEach(e -> System.out.println(e));
		
		int[] s0 = new int[]{1, 2, 3};
		List<Double> s1 = Arrays.stream(s0).mapToDouble(a -> 1.0 / a).boxed().toList();
		System.out.println(s1);
		
		
		List<String> stringList = Arrays.asList("Java 8", "Lambdas", "In", "Action");
		List<Integer> collect = stringList.stream()
				.map(String::length).toList();
		
		List<String> wordList = Arrays.asList("Java 8", "Lambdas", "In", "Action");
		
		List<String> strList = wordList.stream()
				.map(w -> w.split(" "))
				.flatMap(Arrays::stream)
				.distinct().toList();
		System.out.println(strList);
		
		int ans = Arrays.stream(s0).reduce(1, (a, b) -> a * b);
		System.out.println(ans);
	
		
		Stream <String> s2= Stream.of("a", "bb", "ccc", "d");
		Map <String, Integer> len = s2.collect(Collectors.toMap(Function.identity(), String::length));
		System.out.println(len);
		
		s2= Stream.of("a", "bb", "ccc", "d");
		String k = s2.collect(Collectors.joining("$"));
		System.out.println(k);
		
		s2= Stream.of("a", "bb", "ccc", "d");
		List<Integer> get_map = s2.map(String::length).toList();
		
		
		s2= Stream.of("a", "bb", "ccc", "d");
		Map <String, Set<String>> s3 = s2.collect(Collectors.groupingBy(Function.identity(), Collectors.toSet()));
		System.out.println(s3);
		
		s2= Stream.of("a", "bb", "ccc", "d");
		Map <String, Set<Integer>> s4 = s2.collect(Collectors.groupingBy(Function.identity(), Collectors.mapping(String::length, Collectors.toSet())));
		System.out.println(s4);
		
	}
}
