import java.util.*;

class HashMapTest {
	public static void main(String[] args) {
//		HashMap<String, Integer> map = new HashMap<>();
//		map.put("FB", 1);
//		map.put("Ea", 3);
//		map.put("LD", 2);
//		System.out.println(map);
//		map.put("FB", 4);
//		System.out.println("FB".hashCode());
//		System.out.println("LD".hashCode());
//		System.out.println("Ea".hashCode());
//		System.out.println(map);

//		String[] b = new String[2];
//		b[0] = "1";
//		b[1] = "2";
//		List<String> list = Arrays.asList(b);
//		System.out.println(list);
		
		List<String> pets = new ArrayList<>(Collections.nCopies(5, "cat"));
		System.out.println(pets);
		pets.remove("cat");
		System.out.println(pets);
//		System.out.println(Collections.singleton("cat"));
		pets.removeAll(Collections.singleton("cat"));
		System.out.println(pets);
	}
}
