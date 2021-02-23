package arraystuff;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.List;

public class ArrayWrapper {

  public static <F, E extends F> F[] asArray(List<E> in, Class<F> cl) {
//    E[] result = new E[in.size()];
//    E[] result = (E[])new Object[in.size()];
//    E[] result = (E[]) Array.newInstance(cl, in.size());
    F[] result = (F[]) Array.newInstance(cl, in.size());
    for (int i = 0; i < result.length; i++) {
      result[i] = in.get(i);
    }
    return result;
  }

  public static void main(String[] args) {
    List<String> ls = List.of("Fred", "Jim", "Sheila");

//    String [] names = asArray(ls, String.class);
    CharSequence [] names = asArray(ls, CharSequence.class);
    names[0] = new StringBuilder("Frederick");
    for (CharSequence o : names) {
      System.out.println(o);
    }

    System.out.println("type of ls " + ls.getClass());
    System.out.println("type of names array " + names.getClass());
  }
}
