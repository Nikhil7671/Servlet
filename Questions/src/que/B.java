package que;

public class B {
	
	int a=0;
	static int b = 0;
	B(){
		a++;
		b++;
		System.out.print(a);
		System.out.print(b);
	}
	
	public static void main(String[] args) {
		
		B c = new B();
		B d = new B();
		B e = new B();
		
	}

}
