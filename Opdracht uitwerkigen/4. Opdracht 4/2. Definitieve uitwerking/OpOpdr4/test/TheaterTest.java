/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import theater.Plaats.Status;
import theater.Theater;

/**
 * @author Johan Elzinga
 *
 */
public class TheaterTest {

  private Theater testTheater;
  
  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    testTheater = new Theater("Test Theater");
    testTheater.nieuweVoorstelling("testvoorstelling 1","05-03-2019");
  }

  /**
   * Test method for {@link theater.Theater#Theater(java.lang.String)}.
   */
  @Test
  public void testTheater() {
    // Controle of de start situatie aanwezig is.
    assertEquals("Test Theater", testTheater.getNaam());
    // Maak een nieuw Theater aan
    testTheater = new Theater("Test Theater 2");
    // Controle of het nieuwe theater inderdaad aanwezig is.
    assertEquals("Test Theater 2", testTheater.getNaam());
  }

  /**
   * Test method for {@link theater.Theater#nieuweVoorstelling(java.lang.String, java.lang.String)}.
   */
  @Test
  public void testNieuweVoorstelling() {
    // Controleer of de start situatie aanwezig is.
    assertEquals(150,testTheater.getAantalPlaatsen(Status.VRIJ));
    // Maak een nieuwe voorstelling
    testTheater.nieuweVoorstelling("testvoorstelling 2","21-03-2019");
    // Controleer of de zojuist aangemaakte voorstelling goed is aangemaakt.
    assertEquals(150,testTheater.getAantalPlaatsen(Status.VRIJ));
  }

  /**
   * Test method for {@link theater.Theater#reserveer(int, int)}.
   */
  @Test
  public void testReserveer() {
    // Geen juiste rij en/of stoelnummer (aantal vrije stoelen blijft 150).
    testTheater.reserveer(-1, -1);
    assertEquals(150,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.BEZET));

    // Correcte reservering
    testTheater.reserveer(1, 1);
    assertEquals(149,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(1,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.BEZET));

    // Stoel is al gereserveerd (aantal vrije stoelen blijft 149, gereserveerde stoelen blijft 1).
    testTheater.reserveer(1, 1);
    assertEquals(149,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(1,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.BEZET));

    // Maak nog een reservering
    testTheater.reserveer(1, 2);
    assertEquals(148,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(2,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.BEZET));

    // buiten het bereik van de de rij en stoelnummer (aantal vrije stoelen blijft 148, gereserveerde stoelen blijft 2)
    testTheater.reserveer(Theater.AANTALRIJEN+1, Theater.AANTALPERRIJ+1);
    assertEquals(148,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(2,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.BEZET));

    // Reserveer alle stoelen
    for(int i=1; i<=Theater.AANTALRIJEN; i++) {
      for(int j=1; j<=Theater.AANTALPERRIJ; j++) {
        testTheater.reserveer(i, j);
      }
    }
    assertEquals(0,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(150,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.BEZET));
  }

  /**
   * Test method for {@link theater.Theater#plaatsKlant(java.lang.String, java.lang.String)}.
   */
  @Test
  public void testPlaatsKlant() {
    // voorbereiding voor het plaatsen van een klant
    testTheater.reserveer(1, 1);
    testTheater.reserveer(1, 2);
    assertEquals(148,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(2,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.BEZET));

    // Testen met een nieuwe klant
    testTheater.plaatsKlant("Jan Elzinga", "06-87654321");
    assertEquals(148,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(2,testTheater.getAantalPlaatsen(Status.BEZET));

    // voorbereiding voor het plaatsen van een klant
    testTheater.reserveer(2, 1);
    testTheater.reserveer(2, 2);
    assertEquals(146,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(2,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(2,testTheater.getAantalPlaatsen(Status.BEZET));

    // Testen met een bestaande klant
    testTheater.plaatsKlant("Jan Elzinga", "06-87654321");
    assertEquals(146,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(4,testTheater.getAantalPlaatsen(Status.BEZET));

    // Testen met een bestaande klant zonder eerst plaatsen te reserveren
    testTheater.plaatsKlant("Jan Elzinga", "06-87654321");
    assertEquals(146,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(4,testTheater.getAantalPlaatsen(Status.BEZET));

    // Geen juiste rij en/of stoelnummer (aantal vrije stoelen blijft 146, bezette stoelen blijft 4).
    testTheater.reserveer(-1, -1);
    testTheater.plaatsKlant("Jan Elzinga", "06-87654321");
    assertEquals(146,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(4,testTheater.getAantalPlaatsen(Status.BEZET));

    // buiten het bereik van de de rij en stoelnummer (aantal vrije stoelen blijft 146, bezette stoelen blijft 4).
    testTheater.reserveer(Theater.AANTALRIJEN+1, Theater.AANTALPERRIJ+1);
    testTheater.plaatsKlant("Jan Elzinga", "06-87654321");
    assertEquals(146,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(4,testTheater.getAantalPlaatsen(Status.BEZET));

    // Reserveer alle stoelen
    for(int i=1; i<=Theater.AANTALRIJEN; i++) {
      for(int j=1; j<=Theater.AANTALPERRIJ; j++) {
        testTheater.reserveer(i, j);
      }
    }
    testTheater.plaatsKlant("Jan Elzinga", "06-12345678");
    assertEquals(0,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(150,testTheater.getAantalPlaatsen(Status.BEZET));
  }

  /**
   * Test method for {@link theater.Theater#resetReservering()}.
   */
  @Test
  public void testResetReservering() {
    // voorbereiding voor de test
    testTheater.reserveer(1, 1);
    testTheater.reserveer(1, 2);
    assertEquals(148,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(2,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.BEZET));

    // Test de reset van de zojuist gereserveerde plaatsen
    testTheater.resetReservering();
    assertEquals(150,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.BEZET));

    // Test de reset zonder gereserveerde plaatsen
    testTheater.resetReservering();
    assertEquals(150,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.BEZET));
  }

  /**
   * Test method for {@link theater.Theater#getAantalPlaatsen(theater.Plaats.Status)}.
   */
  @Test
  public void testGetAantalPlaatsen() {
    // Dit is al getest bij testPlaatsKlant
  }
}
