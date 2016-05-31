package kw22;

public class Cons<A> implements List<A> {
	final A head;
	final List<A> tail;
	public Cons(A head, List<A> tail) {
		this.head = head;
		this.tail = tail;
	}
	@Override
	public String toString() {
		return "Cons [head=" + head + ", tail=" + tail + "]";
	}
}
