package kw21;

public class Comp {

	public static void main(String[] args) {
		Tree<Integer> t = new Branch<>(
				new Leaf<>(2),new Branch<>(new Branch<>(new Leaf<>(8), new Leaf<>(2)), new Leaf<>(5)));

		System.out.println(t);

		// anzahl leaves
		System.out.println(t.receive(new Tree.Visitor<Integer, Integer>() {

			@Override
			public Integer leaf(Integer k) {
				return 1;
			}

			@Override
			public Integer branch(Integer x, Integer y) {
				return x + y;
			}
		}));

        // summe schlüssel
        System.out.println(t.receive(new Tree.Visitor<Integer, Integer>() {

            @Override
            public Integer leaf(Integer integer) {
                return integer;
            }

            @Override
            public Integer branch(Integer x, Integer y) {
                return x + y;
            }
        }));

        //größter schlüssel
        System.out.println(t.receive(new Tree.Visitor<Integer, Integer>() {
            @Override
            public Integer leaf(Integer integer) {
                return integer;
            }

            @Override
            public Integer branch(Integer x, Integer y) {
               return x > y ? x : y;
            }
        }));

		// maximale tiefe
		System.out.println(t.receive(new Tree.Visitor<Integer, Integer>() {

			@Override
			public Integer leaf(Integer k) {
				return 1;
			}

			@Override
			public Integer branch(Integer x, Integer y) {

				if (x > y) {
					return ++x;
				} else {
					return ++y;
				}
			}
		}));

		// spiegelbild
		System.out.println(t.receive(new Tree.Visitor<Integer, Tree<Integer>>() {

			@Override
			public Tree<Integer> leaf(Integer k) {
				return new Leaf<Integer>(k);
			}

			@Override
			public Tree<Integer> branch(Tree<Integer> x, Tree<Integer> y) {
				return new Branch<Integer>(y, x);
			}
		}));

		Tree<Boolean> booltree = new Branch<>(
				new Leaf<>(true),new Branch<>(new Branch<>(new Leaf<>(true), new Leaf<>(true)), new Leaf<>(true)));

		System.out.println(booltree);


		//and
		System.out.println(booltree.receive(new Tree.Visitor<Boolean, Boolean>() {


			@Override
			public Boolean leaf(Boolean k) {
				return k;
			}

			@Override
			public Boolean branch(Boolean x, Boolean y) {
				return x && y;
			}
		}));
	}

}
