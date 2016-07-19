package kw21;

import java.util.*;
import java.util.stream.Stream;


public class M {

	public static void main(String[] args) {
		List <String> xs = Arrays.asList("foo","bar");

		System.out.println(xs);

		Collections.sort(xs, (String arg0, String arg1) -> arg0.compareTo(arg1));

		System.out.println(xs);

	}

}
