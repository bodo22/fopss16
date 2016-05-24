package kw21;

public class Branch<K> implements Tree<K> {
	final Tree<K> left;
	final Tree<K> right;
	public Branch(Tree<K> left, Tree<K> right) {
		this.left = left;
		this.right = right;
	}
	@Override
	public String toString() {
		return "Branch [left=" + left + ", right=" + right + "]";
	}
	@Override
	public int leaves() {
		return this.left.leaves() + this.right.leaves();
	}
	@Override
	public <R> R receive(kw21.Tree.Visitor<K, R> v) {
		return v.branch(  this.left.receive(v)  , this.right.receive(v) );
	}
	
}
