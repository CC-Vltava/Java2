import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class lambda {
	public interface MyInterface{
		int a = 22;
		int b = 21;
		double getPi();
	}
	public static class test{
		int a;
		test(String s){
			a = s.length();
		}
	}
	public static void main(String[] args) {
		MyInterface ref = () -> 3.14;
		System.out.println(ref.getPi());
		System.out.println(ref.a);
		List <test> s = new ArrayList<>();
		test aa = new test("123");
		test bb = new test("2");
		s.add(aa);
		s.add(bb);
//		s.sort((a, b) -> Integer.compare(a.a, b.a));
		s.sort(Comparator.comparingInt(a -> a.a));
		s.forEach(elem -> System.out.println(elem.a));
		//注意这里不能直接写a.a < b.a, 因为java里面返回值是1，0，-1不是boolean值
		for(test out : s)
			System.out.println(out.a);
		Comparator<String> comparator = (s1, s2) -> (s1.length() < s2.length() ? 1 : -1);
		
		Supplier<String> ce = () -> {System.out.print("hello\n"); return "123"; };
		System.out.println(ce.get());
		
	}
}
