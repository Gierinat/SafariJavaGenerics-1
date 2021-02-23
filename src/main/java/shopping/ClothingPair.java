package shopping;

//public class ClothingPair<E extends Sized, String> extends Pair<E> {
//  java.lang.String x = "Hello";
public class ClothingPair<E extends Sized & Colored> extends Pair<E> {
  public ClothingPair(E left, E right) {
    super(left, right);
  }

  public boolean matched() {
    // THIS DOESN"T WORK
//    Sized & Colored aLeft = left;

    // BUT, this DOES :)
    // x is Serializable & Comparable<...> & Constable (constable in newer Java)
//    var x
//        = Math.random() > 0.5 ? "Hello" : 99;

    return getLeft().getSize() == getRight().getSize()
        && getLeft().getColor().equals(getRight().getColor());
  }

  public static <F extends Sized & Colored> boolean match(F left, F right) {
    return left.getSize() == right.getSize()
        && left.getColor().equals(right.getColor());
  }
}
