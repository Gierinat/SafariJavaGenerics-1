package simple;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseList {
  public static void breakList(List/*<String>*/ l) {
    l.add(0, LocalDate.now());
  }
  public static void main(String[] args) {
//    List<String> names = new ArrayList<String>(List.of("Freddy", LocalDate.now()));
    List<String> names = new ArrayList<>(List.of("Freddy"/*, LocalDate.now()*/));
    names = Collections.checkedList(names, String.class);
    names.add("Fred");
    names.add("Jim");
    names.add("Sheila");
//    names.add(LocalDate.now());
//    breakList(names);

    String s = /*(String)*/names.get(0);
    for (String o : names) {
      System.out.println(o);
    }

    String str = "";
    Class cl = str.getClass();
    System.out.println("Class of string is " + cl.getName());

    System.out.println(str instanceof String);
    // must be class type on RHS of instanceof
//    System.out.println(str instanceof String.class);

    System.out.println(str.getClass() == String.class);

    // Non-reifiable type -- ie. does not really exist at runtime
    // value of E is gone at runtime, called type erasure
//    System.out.println(names instanceof List<String>);

    // Generics is ONLY for reference types
    List<Integer> li = List.of(1, 2, 3);
    // CANNOT use primitive as the base generic type
//    List<int> lip;
    List<int[]> lia;
  }
}
