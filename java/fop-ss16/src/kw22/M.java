package kw22;

public class M {

	public static void main(String[] args) {
		I x = A.make();
		System.out.println(x.m());
		A y = (A) A.make();
	}

}
