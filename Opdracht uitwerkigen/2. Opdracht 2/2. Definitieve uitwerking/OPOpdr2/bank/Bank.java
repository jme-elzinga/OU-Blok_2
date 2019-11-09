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

  /*
   * Zoekt het gegeven rekeningNummer.
   * @param rekeningNummer Het op te zoeken bankrekeningnummer.
   * @return Rekening object of null (wanneer het bankrekeningnummer niet bestaat).
   */
  private Rekening zoekRekening(int rekeningNummer) {
    for (Rekening r: rekeningen) {
      if(r.getRekeningNummer() == rekeningNummer) {
        return r;
      }
    }
    return null;
  }
  
  /**
   * Maakt een nieuw bank object aan en voegt de 5 initiele rekeningen aan de arraylist rekeningen toe.
   */
  public Bank() {
    init();
  }

  /**
   * Controleert of het gegeven rekeningNummer bestaat.
   * @param rekeningNummer Het te controleren bankrekeningnummer.
   * @return true (als het bankrekeningnummer bestaat) of false (wanneer het bankrekeningnummer niet bestaat).
   */
  public boolean rekeningBestaat(int rekeningNummer) {
    if (zoekRekening(rekeningNummer)==null) {
      return false;
    } else {
      return true;
    }
  }
  
  /**
   * Geeft de naam van de rekeninghouder van rekeningNummer terug.
   * @param rekeningNummer Het bankrekeningnummer van de rekening waar de naam van gewenst is.
   * @return de naam van de rekeninghouder of een lege string (wanneer het opgegeven rekeningnummer niet bestaat).
   */
  public String getNaam(int rekeningNummer) {
    Rekening rekening = this.zoekRekening(rekeningNummer);
    if (rekening != null) {
      return rekening.getNaam();
    } else {
      return "";
    }
  }

  /**
   * Geeft het actuele saldo van rekeningNummer terug.
   * @param rekeningNummer Bankrekeningnummer waarvan het saldo gewenst is.
   * @return Het actuele saldo.
   */
  public double getSaldo(int rekeningNummer) {
    Rekening rekening = this.zoekRekening(rekeningNummer);
    if (rekening != null) {
      return rekening.getSaldo();
    } else {
      return 0.0;
    }
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
  
  /**
   * Voeg het gegeven bedrag aan het saldo van het gegeven bankrekeningnummer toe.
   * @param rekeningNummer Het bankrekeningnummer
   * @param bedrag Het toe te voegen bedrag
   * @return True wanneer de storting gelukt is, false wanneer het rekeningnummer niet bestaat.
   * <br>Voorwaarde: Het bedrag met groter of gelijk aan 0 zijn.
   */
  public boolean stort(int rekeningNummer, double bedrag) {
    Rekening rekening = this.zoekRekening(rekeningNummer);
    if (rekening != null && bedrag>=0.0) {
      return rekening.stort(bedrag);
    } else {
      return false;
    }
  }

  /**
   * Verminderd het saldo van het gegeven bankrekeningnummer met het gegeven bedrag.
   * @param rekeningNummer Het bankrekeningnummer
   * @param bedrag Het af te schrijven bedrag
   * @return True wanneer de afboeking gelukt is, false wanneer het rekeningnummer niet bestaat of het bedrag te hoog of negatief is.
   * <br>Voorwaarde: Het gegeven bedrag moet groter of gelijk aan 0 zijn en kan niet hoger zijn dan het actuele saldo.
   */
  public boolean neemOp(int rekeningNummer, double bedrag) {
    Rekening rekening = this.zoekRekening(rekeningNummer);
    if (rekening != null && bedrag >= 0.0) {
      return rekening.neemOp(bedrag);
    } else {
      return false;
    }
  }
}
