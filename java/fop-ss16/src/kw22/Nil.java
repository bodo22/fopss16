package kw22;

public class Nil<A> implements List<A> {

	@Override
	public String toString() {
		return "Nil []";
	}


	@Override
	public <R> R receive(Visitor<A, R> v) {
		return v.nil();
	}
}
