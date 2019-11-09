/**
 * 
 */
package theater;

import java.util.ArrayList;
import theater.Plaats.Status;


/**
 * Klasse die verantwoordelijk is voor het aanmaken van klanten, het beheren van de klantenlijst en het beheer van de voorstellingen.
 * @author Johan Elzinga
 *
 */
public class Theater {
  /**
   * Het aantal stoelen per rij
   */
  public static final int AANTALRIJEN = 15;
  /**
   * Het aantal rijen
   */
  public static final int AANTALPERRIJ = 10;
  private int hoogsteklantnummer=0;
  private static String naam;
  private static ArrayList<Klant> klanten = new ArrayList<Klant>();
  private Voorstelling voorstelling=null;
  
  /**
   * Maakt een nieuw theater object aan met de gegeven naam.
   * @param naam De naam voor dit object.
   */
  public Theater(String naam) {
    Theater.naam=naam;
  }

  /**
   * Geeft de naam van dit object.
   * @return de naam van dit object.
   */
  public String getNaam() {
    return naam;
  }

  /**
   * Hoogt het hoogste klantnummer met 1 op en geeft dit nummer terug.
   * @return het eerstvolgende klantnummer
   */
  private int nieuwKlantnummer() {
    hoogsteklantnummer++;
    return hoogsteklantnummer;
  }
  
  /**
   * Zoek de klant met de gegeven naam en het gegeven telefoonnummer in de klantenlijst 
   * @param naam De naam van een bestaande klant
   * @param telefoon Het bijbehorende telefoonnummer van de klant
   * @return klantobject of null wanneer de klant niet is gevonden.
   */
  public Klant zoekKlant(String naam, String telefoon) {
    for(Klant k: klanten) {
      if (k.getNaam().equals(naam) && k.getTelefoon().equals(telefoon)) {
        return k;
      }
    }
    return null;
  }
  
  /**
   * Maakt een nieuwe klant met de gegeven naam en het gegeven telefoonnummer en voegt deze toe aan de klantenlijst.
   * @param naam De naam van de nieuwe klant.
   * @param telefoon Het telefoonnummer van de nieuwe klant.
   */
  public void maakKlant(String naam, String telefoon) {
    klanten.add (new Klant(nieuwKlantnummer(),naam, telefoon));
  }

  /**
   * Maakt een nieuwe voorstelling aan met de gegeven naam en datum.
   * @param naam De naam van de nieuwe voorstelling.
   * @param datum De datum van de voorstelling.
   */
  public void nieuweVoorstelling(String naam,String datum) {
    voorstelling = new Voorstelling(naam, datum);
  }

  /**
   * Reserveert een plaats voor de huidige voorstelling op de gegeven rij en stoel.
   * @param rij De rij waarop de stoel gereserveerd moet worden.
   * @param stoel De stoel op de gegeven rij.<br><br>
   * Voorwaarden:<br>
   * - De <b>rij</b> en <b>stoel</b> moet groter zijn dan <b>0</b><br>
   * - de <b>rij</b> kleiner of gelijk aan <b>AANTALRIJEN</b><br>
   * - de <b>stoel</b> kleiner of gelijk aan <b>AANTALPERRIJ</b>
   */
  public void reserveer(int rij,int stoel) {
    if(rij>=1 && rij<=AANTALRIJEN && stoel>=1 && stoel<=AANTALPERRIJ) {
      voorstelling.wijzigStatusPlaats(rij, stoel, Status.GERESERVEERD);
    }
  }

  /**
   * Plaatst een klant op alle plaatsen met de status GERESERVEERD
   * @param naam Naam van een klant
   * @param telefoon Telefoonnummer van de klant.<br><br>
   * Bijzonderheid:<br>
   * Wanneer de klant niet bestaat wordt deze aangemaakt.
   */
  public void plaatsKlant(String naam, String telefoon) {
    Klant klant=zoekKlant(naam, telefoon);
    if (klant == null) {
      maakKlant(naam, telefoon);
      klant=zoekKlant(naam, telefoon);
    }
    voorstelling.plaatsKlant(klant);
  }

  /**
   * Zet de status van alle plaatsen met de status GERESERVEERD terug naar VRIJ.
   */
  public void resetReservering() {
    voorstelling.resetReserveringen();
  }

  /**
   * Geeft het aantal plaatsen met de gegeven status
   * @param status De status waarvan het aantal plaatsen moet worden bepaald.
   * @return Het aantal plaatsen met de gegeven status.
   */
  public int getAantalPlaatsen(Status status) {
    return voorstelling.getAantalPlaatsen(status);
  }
}
