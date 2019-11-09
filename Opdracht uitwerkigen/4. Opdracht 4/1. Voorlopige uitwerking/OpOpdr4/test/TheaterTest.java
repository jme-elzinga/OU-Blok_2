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
    testTheater.maakKlant("Johan Elzinga", "06-12345678");
    testTheater.nieuweVoorstelling("testvoorstelling 1","05-03-2019");
  }

  /**
   * Test method for {@link theater.Theater#Theater(java.lang.String)}.
   */
  @Test
  public void testTheater() {
    assertEquals("Test Theater", testTheater.getNaam());
    testTheater = new Theater("Test Theater 2");
    assertEquals("Test Theater 2", testTheater.getNaam());
  }

  /**
   * Test method for {@link theater.Theater#getNaam()}.
   */
  @Test
  public void testGetNaam() {
    assertEquals("Test Theater", testTheater.getNaam());
  }

  /**
   * Test method for {@link theater.Theater#zoekKlant(java.lang.String, java.lang.String)}.
   */
  @Test
  public void testZoekKlant() {
    assertEquals(1,testTheater.zoekKlant("Johan Elzinga", "06-12345678").getKlantnummer());
  }

  /**
   * Test method for {@link theater.Theater#maakKlant(java.lang.String, java.lang.String)}.
   */
  @Test
  public void testMaakKlant() {
    testTheater.maakKlant("Jan Elzinga", "06-87654321");
    assertEquals(2,testTheater.zoekKlant("Jan Elzinga", "06-87654321").getKlantnummer());
  }

  /**
   * Test method for {@link theater.Theater#nieuweVoorstelling(java.lang.String, java.lang.String)}.
   */
  @Test
  public void testNieuweVoorstelling() {
    testTheater.nieuweVoorstelling("testvoorstelling 2","21-03-2019");
    assertEquals(150,testTheater.getAantalPlaatsen(Status.VRIJ));
  }

  /**
   * Test method for {@link theater.Theater#reserveer(int, int)}.
   */
  @Test
  public void testReserveer() {
    // Geen juiste rij en/of stoelnummer
    testTheater.reserveer(-1, -1);
    assertEquals(150,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.BEZET));

    // Correcte reservering
    testTheater.reserveer(1, 1);
    assertEquals(149,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(1,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.BEZET));

    // Stoel is al gereserveerd.
    testTheater.reserveer(1, 1);
    assertEquals(149,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(1,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.BEZET));

    // Maak nog een reservering
    testTheater.reserveer(1, 2);
    assertEquals(148,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(2,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.BEZET));

    // // buiten het bereik van de de rij en stoelnummer
    testTheater.reserveer(Theater.AANTALRIJEN+1, Theater.AANTALPERRIJ+1);
    assertEquals(148,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(2,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.BEZET));
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
    testTheater.plaatsKlant("Johan Elzinga", "06-12345678");
    assertEquals(146,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(4,testTheater.getAantalPlaatsen(Status.BEZET));
  }

  /**
   * Test method for {@link theater.Theater#resetReservering()}.
   */
  @Test
  public void testResetReservering() {
    testTheater.reserveer(1, 1);
    testTheater.reserveer(1, 2);
    assertEquals(148,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(2,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.BEZET));
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
    testTheater.reserveer(1, 1);
    testTheater.reserveer(1, 2);
    assertEquals(148,testTheater.getAantalPlaatsen(Status.VRIJ));
    assertEquals(2,testTheater.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testTheater.getAantalPlaatsen(Status.BEZET));
  }

}
