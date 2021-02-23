package taxation;

import java.util.ArrayList;
import java.util.List;

public class TaxPreparer {
  public static void prepareTaxes(Taxable t) {}

  // ? is the type of the CALLER's list
  // we don't know what it is, but we want to "constrain it"
  // such that assigning ? into a Taxable t, is definitely safe
//  public static <E extends Taxable> void prepareBulkTaxes(List<E> lt) {
  public static void prepareBulkTaxes(List<? extends Taxable> lt) {
//    lt.add(new Corporation()); // NOT SAFE FOR A LIST<INDIVIDUAL>
//    lt.add(new Individual()); // NOT SAFE FOR A LIST<corporation>
//    lt.add(new Taxable()); // NOT SAFE FOR A LIST<corp or indivi>

    Taxable t1 = lt.get(0);

    for (Taxable t : lt) {
      prepareTaxes(t);
    }
  }

  // could have been <Individual extends ?> But is isn't ;)
  public static void collectJoesClients(List<? super Individual> lc) {
//    Individual i = lc.get(0);
    lc.add(new Individual());
    lc.add(new Individual());
  }

  public static void main(String[] args) {
    List<Taxable> clients = List.of(
        new Corporation(),
        new Individual(),
        new Individual(),
        new Corporation());
    collectJoesClients(clients);
    prepareBulkTaxes(clients);

    List<Individual> joesClients =
        new ArrayList<>(List.of(new Individual(), new Individual()));
    collectJoesClients(joesClients);
    prepareBulkTaxes(joesClients);

    /*
    List<?> is a shorthand for List<? extends Object>
    NOT the same as List, nor as List<Object>
     */


    // Can't work...
//    List<Corporation> corpClients = null;
//    collectJoesClients(corpClients);
  }

}
