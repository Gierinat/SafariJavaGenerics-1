package cocontra;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Example {

  public static <E, F> List<F> map(List<E> in, Function<? super E, ? extends F> function) {
    List<F> result = new ArrayList<>();
    for (E e : in) {
      F f = function.apply(e);
      result.add(f);
    }
    return result;
  }
  public static void main(String[] args) {
    List<String> names = List.of("Fred", "Jim", "Sheila");
    Function<String, String> op1 = e -> e.toUpperCase();
    System.out.println("op1.apply(\"Fred\") gives " + op1.apply("Fred") );

    Function<CharSequence, String> op2 = e -> e.subSequence(1, e.length()).toString();
    List<CharSequence> results = map(names, op2);
    System.out.println(results);

    List<String> namesAgain = new ArrayList<>(names);
    Predicate<CharSequence> longNameTest = s -> s.length() > 3;
    System.out.println("names Again is " + namesAgain);
    namesAgain.removeIf(longNameTest);
    System.out.println("names Again is " + namesAgain);
  }
}
