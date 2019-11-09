package theater;

import theater.Plaats.Status;

/**
 * Voorbeeldprogramma voor de theaterapplicatie.
 */
public class TheaterApplicatie {

  /**
   * Main programma.
   * @param args niet gebruikt
   */
  public static void main(String[] args) {
    
    Theater theater = new Theater("Chassé Theater");
    theater.nieuweVoorstelling("War Horse", "26-12-2014");
    printInfo(theater);
    // reserveer een aantal plaatsen
    theater.reserveer(3, 3);
    theater.reserveer(3, 4);
    theater.reserveer(3, 5);
    theater.reserveer(3, 6);
    theater.reserveer(-1, 1); //  buiten grenzen
    theater.reserveer(100, 200); // buiten grenzen
    printInfo(theater);
    // plaats klant op gereserveerde plaatsen
    theater.plaatsKlant("Kok", "0678912345");
    printInfo(theater);
    // reserveer een aantal plaatsen
    theater.reserveer(3, 3); // is al bezet
    theater.reserveer(4, 3);
    theater.reserveer(4, 4);
    printInfo(theater);
    // plaats klant op gereserveerde plaatsen
    theater.plaatsKlant("Pootjes", "0654321987");
    printInfo(theater);
    // reserveer een aantal plaatsen
    theater.reserveer(5, 1);
    theater.reserveer(5, 2);
    theater.reserveer(5, 3);
    printInfo(theater);
    // cancel reserveringen
    theater.resetReservering();
    printInfo(theater);
  }

  
  private static void printInfo(Theater theater) {
    System.out.println("VRIJ: " + theater.getAantalPlaatsen(Status.VRIJ) +
        " / GERESERVEERD: " + theater.getAantalPlaatsen(Status.GERESERVEERD) +
        " / BEZET: " + theater.getAantalPlaatsen(Status.BEZET));
  }
}
