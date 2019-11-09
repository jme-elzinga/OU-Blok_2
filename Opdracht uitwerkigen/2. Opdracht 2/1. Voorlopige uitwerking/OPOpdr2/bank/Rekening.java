package bank;

/**
 * Klasse die verantwoordelijk is voor het aanmaken en beheren van het saldo van een bankrekening
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
  public String getNaam() {
    return naam;
    
  }

  /**
   * Geeft het bankrekeningnummer van deze Rekening terug.
   * @return het bankrekeningnummer.
   */
  public int getRekeningNummer() {
    return rekeningNummer;
  }

  /**
   * Geeft het actuele saldo van deze Rekening terug.
   * @return Het actuele saldo.
   */
  public double getSaldo() {
    return saldo;
  }

  /**
   * Voeg het gegeven bedrag aan het saldo van deze Rekening toe.
   * @param bedrag Het toe te voegen bedrag
   * <br>Voorwaarde: Het bedrag met groter of gelijk aan 0 zijn.
   */
  public void stort(double bedrag) {
    if (bedrag>=0) {
      saldo=saldo+bedrag;
    }
  }

  /**
   * Verminderd het saldo van deze Rekening met het gegeven bedrag.
   * @param bedrag Het af te schrijven bedrag
   * <br>Voorwaarde: Het gegeven bedrag moet groter of gelijk aan 0 zijn en kan niet meer zijn dan het actuele saldo.
   */
  public void neemOp(double bedrag) {
    if (bedrag>=0 && bedrag<=saldo) {
      saldo=saldo-bedrag;
    }
  }
}
