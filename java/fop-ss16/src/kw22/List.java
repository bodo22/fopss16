package kw22;

public interface List<A> {

    interface Visitor<A,R> {
        R nil();
        R cons(A head, R tail);
    }

    <R> R receive (Visitor<A,R> v);



}
