package kw22;

public class Main {

	public static void main(String[] args) {
		List<Integer> xs =
		  new Cons<Integer>(1,
				 new Cons<>(2, new Nil<>()));
		System.out.println(xs);
	}

}
