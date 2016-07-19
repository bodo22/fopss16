package kw22;

public class Main {

	public static void main(String[] args) {
		List<Integer> xs = new Cons<Integer>(8,new Cons<>(2, new Nil<>()));
		System.out.println(xs);


		// summe
		System.out.println(xs.receive(new List.Visitor<Integer, Integer>() {
			@Override
			public Integer nil() {
				return 0;
			}

			@Override
			public Integer cons(Integer head, Integer tail) {
				return head + tail;
			}
		}));

		// produkt
		System.out.println(xs.receive(new List.Visitor<Integer, Integer>() {

			@Override
			public Integer nil() {
				return 1;
			}

			@Override
			public Integer cons(Integer head, Integer tail) {
				return head * tail;
			}
		}));

		// nur gerade zahlen?
		System.out.println(xs.receive(new List.Visitor<Integer, Boolean>() {
			@Override
			public Boolean nil() {
				return true;
			}

			@Override
			public Boolean cons(Integer head, Boolean tail) {
				return head % 2 == 0 && tail;
			}
		}));

		List<Boolean> xs2 = new Cons<>(true, new Cons<>(true, new Cons<>(true, new Cons<>(true, new Nil<>()))));


		// and
		System.out.println(xs2.receive(new List.Visitor<Boolean, Boolean>() {
			@Override
			public Boolean nil() {
				return true;
			}

			@Override
			public Boolean cons(Boolean head, Boolean tail) {
				return head && tail;
			}
		}));

		// or
		System.out.println(xs2.receive(new List.Visitor<Boolean, Boolean>() {
			@Override
			public Boolean nil() {
				return false;
			}

			@Override
			public Boolean cons(Boolean head, Boolean tail) {
				return head || tail;
			}
		}));
	}
}
