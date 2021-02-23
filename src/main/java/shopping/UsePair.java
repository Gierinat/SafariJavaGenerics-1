package shopping;

import java.time.LocalDate;

public class UsePair {
  public static void main(String[] args) {
//    Pair p = new Pair("hello", LocalDate.now());
    Pair<String> p = new Pair<>("hello", "Bonjour");
//    p.setLeft(LocalDate.now());
    p.setLeft("Guten tag");
    String r = p.getRight();

    Pair<LocalDate> pld = new Pair<>(LocalDate.now(), LocalDate.now());

    ClothingPair<Shoe> ps = new ClothingPair<>(
        new Shoe(9, "Brown"), new Shoe(10, "Brown"));
    ClothingPair<Shoe> ps2 = new ClothingPair<>(
        new Shoe(9, "Brown"), new Shoe(9, "Red"));
    System.out.println(ps);
    System.out.println("Shoes match? " + ps.matched());
    System.out.println("More shoes match? " + ps2.matched());

//    System.out.println(ClothingPair.match(new Shoe(9, "Green"), new Shoe(9, "Red")));
    System.out.println(ClothingPair.<Shoe>match(new Shoe(9, "Green"), new Shoe(9, "Red")));
  }
}
