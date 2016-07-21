package strategy;

import java.util.*;
import java.util.stream.Stream;


public class M {

    public static void main(String[] args) {
        List <String> xs = Arrays.asList("foo","bar");
        List <Integer> xsi = Arrays.asList(3,2,1);
        System.out.println(xsi);

        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                //hier muesste 1 stringvgl durchgeführt werden
                return (1);
            }
        };

        Comparator<Integer> ci = new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return x-y;
            }
        };

        sortCom(xsi, ci);

        System.out.println(xsi);
    }

    static <T> void sortCom(List<T> list, Comparator<T> c) {
        Collections.sort(list,
                (T arg0, T arg1) -> c.compare(arg0,arg1));
    }

}