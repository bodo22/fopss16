package kw21;

public interface Tree<K> {

	interface Visitor<K,R> {
		R  leaf (K k);
		R  branch (R x, R y);
	}
	
	<R>  R receive (Visitor<K,R> v);
	
	int leaves();

}
