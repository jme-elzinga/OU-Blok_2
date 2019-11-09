package bank;

/**
 * Klasse die verantwoordelijk is voor het aanmaken en beheren van een bankrekening
 * @author Johan Elzinga
 *
 */
public class Rekening {

  private String naam;
  private int rekeningNummer;
  private double saldo;
  
  /**
   * Maakt een nieuwe Rekening aan met gegeven naam en gegeven nummer.
   * <br>Bijzonderheden:<br> - Deze methode is protected en kan alleen aangeroepen worden binnen het package bank.<br> - Het begin saldo wordt 0 gemaakt.
   * @param naam de naam van de rekeninghouder.
   * @param rekeningNummer het bankrekeningnummer.
   */
  protected Rekening(String naam, int rekeningNummer) {
    this.naam=naam;
    this.rekeningNummer=rekeningNummer;
    this.saldo=0.0;
  }

  /**
   * Geeft de naam van de rekeninghouder van deze Rekening terug.
   * @return de naam van de rekeninghouder.
   */
  protected String getNaam() {
    return this.naam;
  }

  /**
   * Geeft het bankrekeningnummer van deze Rekening terug.
   * @return het bankrekeningnummer.
   */
  protected int getRekeningNummer() {
    return this.rekeningNummer;
  }

  /**
   * Geeft het actuele saldo van deze Rekening terug.
   * @return Het actuele saldo.
   */
  protected double getSaldo() {
    return this.saldo;
  }

  /**
   * Voeg het gegeven bedrag aan het saldo van deze Rekening toe.
   * @param bedrag Het toe te voegen bedrag
   * <br>Voorwaarde: Het bedrag met groter of gelijk aan 0 zijn.
   * @return True als de storting gelukt is, false wanneer de storting niet gelukt is.
   */
  protected boolean stort(double bedrag) {
    if (bedrag>=0) {
      this.saldo+=bedrag;
      return true;
    } else {
      return false;
    }
  }

  /**
   * Verminderd het saldo van deze Rekening met het gegeven bedrag.
   * @param bedrag Het af te schrijven bedrag
   * <br>Voorwaarde: Het gegeven bedrag moet groter of gelijk aan 0 zijn en kan niet hoger zijn dan het actuele saldo.
   * @return True als de opname gelukt is, false wanneer de opname niet gelukt is.
   */
  protected boolean neemOp(double bedrag) {
    if (bedrag>=0 && bedrag<=saldo) {
      this.saldo-=bedrag;
      return true;
    } else {
      return false;
    }
  }
}
