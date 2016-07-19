package kw22.FabrikMuster;

public class B implements I {

    public B() {
    }

    static I make() {
        return new B();
    }

    @Override
    public int m() {
        return 1;
    }


}
