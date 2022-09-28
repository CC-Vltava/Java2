package tutorial.lab3.tutorial.lab3;

interface eat {
	public static final int number = 10;
	
	public abstract void name();
}
class CC implements eat{
	public static int age = 0;
	public static void add(){
		age += 1;
	}
	@Override
	public void name() {
		System.out.println("Hello CC!");
	}
}
class SmallCC extends CC{
	@Override
	public void name() {
		System.out.println("Hello SmallCC!");
	}
}
public class test_interface {
	public static void main(String[] args) {
		CC ss = new CC();
		ss.name();
		CC cc = new SmallCC();
		cc.name();
	}
}
