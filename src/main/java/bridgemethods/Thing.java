package bridgemethods;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Thing implements Comparable<Thing> {
  private int value;

  // SAME METHOD due to type erasure
//  public static void doStuff(List<String> ls) {}
//  public static void doStuff(List<LocalDate> ls) {}

  @Override
  public String toString() {
    return "Thing{" +
        "value=" + value +
        '}';
  }

  public Thing(int value) {
    this.value = value;
  }

  public static void main(String[] args) {
    List<Thing> things = new ArrayList<>(
        List.of(new Thing(9), new Thing(2), new Thing(7), new Thing(3))
    );

    things.stream().sorted().forEach(t -> System.out.println(t));

    Class<?> cl = Thing.class;
    Method [] methods = cl.getDeclaredMethods();
    for (Method m : methods) {
      System.out.println(m);
    }
  }

//  @Override
//  public int compareTo(Object o) {
//    Thing other = (Thing)o;
//    return Integer.compare(this.value, other.value);
//  }

  @Override
  public int compareTo(Thing o) {
    return Integer.compare(this.value, o.value);
  }
}
