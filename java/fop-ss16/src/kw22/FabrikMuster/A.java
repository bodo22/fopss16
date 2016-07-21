package kw22.FabrikMuster;

public class A implements I {

    private A() {}

    static I make() {
        return new A();
    }

    @Override
    public int m() {
        return 0;
    }

    public int p() {
        return 0;
    }

}
