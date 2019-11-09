/**
 * 
 */
package theater;

/**
 * Klasse die verantwoordelijk is aanmaken van een klant.
 * @author Johan Elzinga
 *
 */

public class Klant {
  
  private int klantnummer;
  private String naam;
  private String telefoon;
  
  /**
   * Maakt een klant object met het gegeven klantnummer, naam en telefoonnummer.
   * @param klantnummer Het klantnummer.
   * @param naam De naam.
   * @param telefoon Het telefoonnummer.
   */
  protected Klant(int klantnummer, String naam, String telefoon) {
    this.klantnummer = klantnummer;
    this.naam = naam;
    this.telefoon = telefoon;
  }

  /**
   * Geeft het klantnummer terug.
   * @return Het klantnummer van dit object.
   */
  protected int getKlantnummer() {
    return klantnummer;
  }

  /**
   * Geeft de naam terug.
   * @return De naam van dit object.
   */
  protected String getNaam() {
    return naam;
  }

  /**
   * Geeft het telefoon nummer terug.
   * @return HEt telefoonnummer van dit object.
   */
  protected String getTelefoon() {
    return telefoon;
  }

  /**
   * Geeft een string met klantgegevens terug.
   * @return Een string met klantgegevens.
   */
  public String toString() {
    return "klantnummer=" + klantnummer + ",naam=" + naam + ",telefoon=" + telefoon;
  }
  
}
