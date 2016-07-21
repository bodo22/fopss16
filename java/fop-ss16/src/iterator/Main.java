package iterator;

import java.util.Iterator;

/**
 * Created by willi on 19.07.16.
 */
public class Main {

    public static void main(String[] args) {



        for (int x : range(3,5)) {
            System.out.println(x);
        }
        System.out.println("Quads:");
        for (int x : quads(2,5)) {
            System.out.println(x);
        }
    }

    static Iterable<Integer> range(int start, int count) {

        Iterable<Integer> nats = new Iterable<Integer>() {

            @Override
            public Iterator<Integer> iterator() {

                return new Iterator<Integer>() {
                    private int state = start;
                    public boolean hasNext() {
                        return state < count + start;
                    }
                    public Integer next() {
                        int result = this.state;
                        this.state++;
                        return result;
                    }
                };
            }
        };
        return nats;
    }


    static Iterable<Integer> quads(int start, int count) {
        Iterable<Integer> quads = new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {

                    int state = start;

                    @Override
                    public boolean hasNext() {
                        return state < start + count;
                    }

                    @Override
                    public Integer next() {
                        int result = this.state;
                        this.state++;
                        return result * result;
                    }
                };
            }
        };
        return quads;
    }
}
