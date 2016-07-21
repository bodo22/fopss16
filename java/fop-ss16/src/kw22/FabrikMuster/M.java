package kw22.FabrikMuster;

public class M {

    public void main(String[] args) {
        I a = A.make();
        System.out.println("I a: " + a.m());
        A y = (A) A.make();

        I b = B.make();
        System.out.println("I b: " + b.m());
    }

}
