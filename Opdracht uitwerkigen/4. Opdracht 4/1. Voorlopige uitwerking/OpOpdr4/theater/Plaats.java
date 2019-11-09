/**
 * 
 */
package theater;

/**
 * Klasse die verantwoordelijk is aanmaken van een plaats, de status van een plaats en het koppelen van een klant.
 * @author Johan Elzinga
 *
 */
public class Plaats {
  
  /**
   * Status waarden welke gebruikt kunnen worden om de status van plaats aan te geven. 
   */
  public static enum Status {
    /**
     * Status van een vrije plaats
     */
    VRIJ,
    /**
     * Status van een plaats waaraan een klant is gekoppeld.
     */
    BEZET,
    /**
     * Status van een plaats met een lopende reservering waar nog geen klant aan gekoppeld is.
     */
    GERESERVEERD};
  private int rijnummer=0;
  private int stoelnummer=0;
  private Status status=null;
  private Klant klant=null;

  /**
   * Maakt een plaats object aan op de gegeven rij nummer en het stoel nummer.
   * @param rijnummer Het rij nummer waarop de stoel zich bevind
   * @param stoelnummer Het stoel nummer op de gegeven rij.<br><br>
   * Voorwaarden:<br>
   * - rijnummer en stoelnummer moet groter zijn dan 0.<br><br>
   * Bijzonderheden:<br>
   * - De status van de plaats wordt VRIJ.
   */
  public Plaats(int rijnummer, int stoelnummer) {
    if (rijnummer>0 && stoelnummer>0) {
      this.rijnummer = rijnummer;
      this.stoelnummer = stoelnummer;
      status = Status.VRIJ;
    }
  }

  /**
   * Geeft een string terug met de gegevens van dit object.
   * @return De string met gegevens.
   */
  public String toString() {
    if (status.equals(Status.BEZET)) {
      return "rijnummer=" + rijnummer + ",stoelnummer=" +stoelnummer + ",status=" + status + ",klantnummer="+ klant.getKlantnummer() + ",naam=" + klant.getNaam() + ",telefoon=" + klant.getTelefoon();
    } else {
      return "rijnummer=" +rijnummer + ",stoelnummer=" + stoelnummer + ",status=" + status;
    }
  }

  /**
   * Geeft de status van dit object.
   * @return De status.
   */
  public Status getStatus() {
    return status;
  }

  /**
   * Stelt de status van dit object in.
   * @param status De nieuwe status van dit object<br><br>
   * Voorwaarden:<br>
   * - De nieuwe status kan alleen VRIJ of GERESERVEERD zijn.<br>
   * - De huidige status mag niet BEZET zijn (in dat geval wijzigt er niets).
   */
  public void setStatus(Status status) {
    if(!this.status.equals(Status.BEZET) && (status.equals(Status.VRIJ) || status.equals(Status.GERESERVEERD))) {
      this.status=status;
    }
  }

  /**
   * Koppelt een klant object aan dit object
   * @param klant Het te koppelen klant object.<br><br>
   * Bijzonderheid:<br>
   * - de status van dit object wordt op BEZET gezet.
   */
  public void plaatsKlant(Klant klant) {
    this.klant = klant;
    status = Status.BEZET;
  }

}
