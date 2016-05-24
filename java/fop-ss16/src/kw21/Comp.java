package kw21;

public class Comp {

	public static void main(String[] args) {
		Tree<Integer> t =
				new Branch<Integer>(new Leaf<Integer>(3),new Leaf<Integer>(4));
		System.out.println(t);
		System.out.println(t.receive(new Tree.Visitor<Integer, Integer>() {

			@Override
			public Integer leaf(Integer k) {
				return 1;
			}

			@Override
			public Integer branch(Integer x, Integer y) {
				return x+y;
			}
		}));
	}

}
