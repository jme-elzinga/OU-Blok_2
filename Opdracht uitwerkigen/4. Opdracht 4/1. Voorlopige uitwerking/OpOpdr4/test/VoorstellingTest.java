/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import theater.Voorstelling;
import theater.Plaats.Status;
import theater.Theater;
import theater.Klant;

/**
 * @author Johan Elzinga
 *
 */
public class VoorstellingTest {

  private Voorstelling testVoorstelling;
  private Klant testKlant;
  
  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    testVoorstelling = new Voorstelling("testvoorstelling 1","05-03-2019");
    testKlant = new Klant(10,"Johan Elzinga","06-12345678");
  }

  /**
   * Test method for {@link theater.Voorstelling#Voorstelling(java.lang.String, java.lang.String)}.
   */
  @Test
  public void testVoorstelling() {
    assertEquals("testvoorstelling 1",testVoorstelling.getNaam());
    testVoorstelling = new Voorstelling("testvoorstelling 2","21-03-2019");
    assertEquals("testvoorstelling 2",testVoorstelling.getNaam());
  }

  /**
   * Test method for {@link theater.Voorstelling#getNaam()}.
   */
  @Test
  public void testGetNaam() {
    assertEquals("testvoorstelling 1",testVoorstelling.getNaam());
  }

  /**
   * Test method for {@link theater.Voorstelling#getDatum()}.
   */
  @Test
  public void testGetDatum() {
    assertEquals("05-03-2019",testVoorstelling.getDatum());
  }

  /**
   * Test method for {@link theater.Voorstelling#wijzigStatusPlaats(int, int, theater.Plaats.Status)}.
   */
  @Test
  public void testWijzigStatusPlaats() {
    testVoorstelling.wijzigStatusPlaats(0, 0, Status.GERESERVEERD);
    assertEquals(150,testVoorstelling.getAantalPlaatsen(Status.VRIJ));
    assertEquals(0,testVoorstelling.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testVoorstelling.getAantalPlaatsen(Status.BEZET));
 
    testVoorstelling.wijzigStatusPlaats(Theater.AANTALRIJEN+1, Theater.AANTALPERRIJ+1, Status.GERESERVEERD);
    assertEquals(150,testVoorstelling.getAantalPlaatsen(Status.VRIJ));
    assertEquals(0,testVoorstelling.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testVoorstelling.getAantalPlaatsen(Status.BEZET));
 
    testVoorstelling.wijzigStatusPlaats(1, 1, Status.GERESERVEERD);
    assertEquals(149,testVoorstelling.getAantalPlaatsen(Status.VRIJ));
    assertEquals(1,testVoorstelling.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testVoorstelling.getAantalPlaatsen(Status.BEZET));
 
    testVoorstelling.wijzigStatusPlaats(1, 1, Status.VRIJ);
    assertEquals(150,testVoorstelling.getAantalPlaatsen(Status.VRIJ));
    assertEquals(0,testVoorstelling.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testVoorstelling.getAantalPlaatsen(Status.BEZET));

    testVoorstelling.wijzigStatusPlaats(1, 1, Status.GERESERVEERD);
    testVoorstelling.plaatsKlant(testKlant);
    assertEquals(149,testVoorstelling.getAantalPlaatsen(Status.VRIJ));
    assertEquals(0,testVoorstelling.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(1,testVoorstelling.getAantalPlaatsen(Status.BEZET));

    testVoorstelling.wijzigStatusPlaats(1, 1, Status.VRIJ);
    assertEquals(149,testVoorstelling.getAantalPlaatsen(Status.VRIJ));
    assertEquals(0,testVoorstelling.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(1,testVoorstelling.getAantalPlaatsen(Status.BEZET));
  }

  /**
   * Test method for {@link theater.Voorstelling#plaatsKlant(theater.Klant)}.
   */
  @Test
  public void testPlaatsKlant() {
    testVoorstelling.plaatsKlant(testKlant);
    assertEquals(150,testVoorstelling.getAantalPlaatsen(Status.VRIJ));
    assertEquals(0,testVoorstelling.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testVoorstelling.getAantalPlaatsen(Status.BEZET));

    testVoorstelling.wijzigStatusPlaats(1, 1, Status.GERESERVEERD);
    testVoorstelling.wijzigStatusPlaats(1, 2, Status.GERESERVEERD);
    testVoorstelling.plaatsKlant(testKlant);
    assertEquals(148,testVoorstelling.getAantalPlaatsen(Status.VRIJ));
    assertEquals(0,testVoorstelling.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(2,testVoorstelling.getAantalPlaatsen(Status.BEZET));
  }

  /**
   * Test method for {@link theater.Voorstelling#resetReserveringen()}.
   */
  @Test
  public void testResetReserveringen() {
    testVoorstelling.wijzigStatusPlaats(1, 1, Status.GERESERVEERD);
    testVoorstelling.wijzigStatusPlaats(1, 2, Status.GERESERVEERD);
    assertEquals(148,testVoorstelling.getAantalPlaatsen(Status.VRIJ));
    assertEquals(2,testVoorstelling.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testVoorstelling.getAantalPlaatsen(Status.BEZET));

    testVoorstelling.resetReserveringen();
    assertEquals(150,testVoorstelling.getAantalPlaatsen(Status.VRIJ));
    assertEquals(0,testVoorstelling.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testVoorstelling.getAantalPlaatsen(Status.BEZET));

    testVoorstelling.wijzigStatusPlaats(1, 1, Status.GERESERVEERD);
    testVoorstelling.wijzigStatusPlaats(1, 2, Status.GERESERVEERD);
    testVoorstelling.plaatsKlant(testKlant);
    testVoorstelling.resetReserveringen();
    assertEquals(148,testVoorstelling.getAantalPlaatsen(Status.VRIJ));
    assertEquals(0,testVoorstelling.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(2,testVoorstelling.getAantalPlaatsen(Status.BEZET));
  }

  /**
   * Test method for {@link theater.Voorstelling#getAantalPlaatsen(theater.Plaats.Status)}.
   */
  @Test
  public void testGetAantalPlaatsen() {
    assertEquals(150,testVoorstelling.getAantalPlaatsen(Status.VRIJ));
    assertEquals(0,testVoorstelling.getAantalPlaatsen(Status.GERESERVEERD));
    assertEquals(0,testVoorstelling.getAantalPlaatsen(Status.BEZET));
  }

}
