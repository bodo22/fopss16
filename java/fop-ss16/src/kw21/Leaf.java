package kw21;

public class Leaf<K> implements Tree<K> {
	final K key;

	@Override
	public String toString() {
		return "Leaf [key=" + key + "]";
	}

	public Leaf(K key) {
		this.key = key;
	}

	@Override
	public int leaves() {
		return 1;
	}

	@Override
	public <R> R receive(kw21.Tree.Visitor<K, R> v) {
		return v.leaf(this.key);
	}
}
