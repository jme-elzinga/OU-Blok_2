/**
 * 
 */
package theater;

import theater.Plaats.Status;

/**
 * Klasse die verantwoordelijk is aanmaken van een voorstelling en het beheer van de plaatsen.
 * @author Johan Elzinga
 *
 */
public class Voorstelling {

  private String naam;
  private String datum;
  private Plaats[][] plaatsen = new Plaats[Theater.AANTALRIJEN+1][Theater.AANTALPERRIJ+1];

  /**
   * Maakt een nieuw voorstelling object aan met de gegeven naam en de gegeven datum.
   * @param naam Naam van de voorstelling.
   * @param datum Datum van de voorstelling.
   */
  public Voorstelling(String naam, String datum) {
    this.naam = naam;
    this.datum = datum;
    for (int i=1; i<=Theater.AANTALRIJEN; i++) {
      for (int j=1; j<= Theater.AANTALPERRIJ; j++) {
        plaatsen[i][j] = new Plaats(i,j);
      }
    }
  }

  /**
   * Geeft de naam van de voorstelling.
   * @return De naam van deze voorstelling.
   */
  public String getNaam() {
    return naam;
  }

  /**
   * Geeft de datum van de voorstelling.
   * @return De datum van deze voorstelling.
   */
  public String getDatum() {
    return datum;
  }

  /**
   * Verandert de status van een plaats in de gegeven status.
   * @param rij De rij waar de plaats zich op bevind.
   * @param stoel De stoel op de gegeven rij.
   * @param status De nieuwe status.<br><br>
   * Voorwaarden:<br>
   * - De <b>rij</b> en de <b>stoel</b> moet groter zijn dan <b>0</b><br>
   * - De <b>rij</b> moet kleiner of gelijk zijn aan <b>AANTALRIJEN</b><br>
   * - De <b>stoel</b> moet kleiner of gelijk zijn aan <b>AANTALPERRIJ</b><br>
   * - de bestaande status van de plaats mag niet <b>BEZET</b> zijn (in dat geval wordt er niets gewijzigd).<br>
   * - de nieuwe <b>status</b> kan alleen <b>VRIJ</b> of <b>GERESERVEERD</b> zijn
   */
  public void wijzigStatusPlaats(int rij, int stoel, Status status) {
    if(rij>0 && rij<=Theater.AANTALRIJEN && stoel>0 && stoel<=Theater.AANTALPERRIJ && !plaatsen[rij][stoel].getStatus().equals(Status.BEZET) && (status.equals(Status.VRIJ) || status.equals(Status.GERESERVEERD))) {
      plaatsen[rij][stoel].setStatus(status);
    }
  }

  /**
   * Plaatst een klant op alle plaatsen met de status GERESERVEERD
   * @param klant Het klant object.
   */
  public void plaatsKlant(Klant klant) {
    for(int i=1;i<=Theater.AANTALRIJEN; i++) {
      for (int j=1; j<=Theater.AANTALPERRIJ; j++) {
        if(plaatsen[i][j].getStatus().equals(Status.GERESERVEERD)) {
          plaatsen[i][j].plaatsKlant(klant);
        }
      }
      
    }
  }

  /**
   * Reset de status van alle plaatsen met de status GERESERVEERD naar VRIJ.
   */
  public void resetReserveringen() {
    for(int i=1;i<=Theater.AANTALRIJEN; i++) {
      for (int j=1; j<=Theater.AANTALPERRIJ; j++) {
        if(plaatsen[i][j].getStatus().equals(Status.GERESERVEERD)) {
          plaatsen[i][j].setStatus(Status.VRIJ);
        }
      }
    }
  }

  /**
   * Geeft het aantal plaatsen met de gegeven status
   * @param status De status waarvan het aantal plaatsen moet worden bepaald.
   * @return Het aantal plaatsen met de gegeven status.
   */
  public int getAantalPlaatsen(Status status) {
    int teller=0;
    for(int i=1;i<=Theater.AANTALRIJEN; i++) {
      for (int j=1; j<=Theater.AANTALPERRIJ; j++) {
        if(plaatsen[i][j].getStatus().equals(status)) {
          teller++;
        }
      }
    }
    return teller;
  }

}
