package bank;

import java.util.ArrayList;
import bank.Rekening;

/**
 * Klasse die verantwoordelijk is voor het aanmaken van de rekeningen en het beheren van de rekeningenlijst.
 * @author Johan Elzinga
 *
 */
public class Bank {

  private static ArrayList<Rekening> rekeningen = new ArrayList<Rekening>();
  
  /**
   * Maakt een nieuw bank object aan en voegt de 5 initiele rekeningen aan de arraylist rekeningen toe.
   */
  public Bank() {
    init();
  }

  /**
   * Voegt 5 rekeningen toe aan de arraylist rekeningen.
   */
  private static void init() {
    // Maakt vijf rekeningen aan
    rekeningen.add(new Rekening("AKO", 1111));
    rekeningen.add(new Rekening("AHN", 1234));
    rekeningen.add(new Rekening("HJO", 2222));
    rekeningen.add(new Rekening("FVB", 2345));
    rekeningen.add(new Rekening("JME", 3333));
  }

  /**
   * Zoekt Rekening met het gegeven rekeningNummer.
   * <br>Bijzonderheid:<br> Wanneer het rekeningnummer niet bestaat wordt een null resultaat terug gegeven.
   * @param rekeningNummer Het te zoeken bankrekeningnummer.
   * @return een Rekening object of null.
   */
  public Rekening zoekRekening(int rekeningNummer) {
    Rekening rekObj = null;
    for (Rekening r: rekeningen) {
      if(r.getRekeningNummer() == rekeningNummer) {
        rekObj=r;
      }
    }
    return rekObj;
  }
  
  /**
   * Boekt bedrag over van Rekening met vanRekeningNummer naar Rekening met naarRekeningNummer.
   * @param vanRekeningNummer Rekeningnummer van de rekening waar het bedrag afgeboekt moet worden.
   * @param naarRekeningNummer Rekeningnummer van de rekening waar het bedrag bij geboekt moet worden.
   * @param bedrag Het bedrag wat overgeboekt moet worden
   * <br>Voorwaarde:<br>- Het bedrag moet groter of gelijk aan 0 zijn<br>- Wanneer het saldo op vanRekeningNummer onvoldoende is dan wordt er niets overgeboekt.
   */
  public void maakOver(int vanRekeningNummer, int naarRekeningNummer, double bedrag) {
    Rekening vanRekening = this.zoekRekening(vanRekeningNummer);
    Rekening naarRekening = this.zoekRekening(naarRekeningNummer);
    if (vanRekening != null && naarRekening != null) {
      if(bedrag>=0 && vanRekening.getSaldo() >= bedrag) {
        vanRekening.neemOp(bedrag);
        naarRekening.stort(bedrag);
      }
    }
  }
}
