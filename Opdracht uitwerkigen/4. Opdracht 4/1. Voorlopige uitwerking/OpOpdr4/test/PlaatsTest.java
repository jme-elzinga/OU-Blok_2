package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import theater.Klant;
import theater.Plaats;
import theater.Plaats.Status;

public class PlaatsTest {

  private Plaats testPlaats;
  private Klant testKlant;

  @Before
  public void setUp() throws Exception {
    testPlaats=new Plaats(1,1);
    testKlant=new Klant(10,"Johan Elzinga","06-12345678");
  }

  @Test
  public void testPlaats() {
    assertEquals(Status.VRIJ,testPlaats.getStatus());
    testPlaats=new Plaats(2,2);
    assertEquals(Status.VRIJ,testPlaats.getStatus());
    testPlaats=new Plaats(0,0);
    assertEquals(null,testPlaats.getStatus());
  }

  @Test
  public void testToString() {
    assertEquals("rijnummer=1,stoelnummer=1,status=VRIJ",testPlaats.toString());
    testPlaats.setStatus(Status.GERESERVEERD);
    assertEquals("rijnummer=1,stoelnummer=1,status=GERESERVEERD",testPlaats.toString());
    testPlaats.plaatsKlant(testKlant);
    assertEquals("rijnummer=1,stoelnummer=1,status=BEZET,klantnummer=10,naam=Johan Elzinga,telefoon=06-12345678",testPlaats.toString());
  }

  @Test
  public void testGetStatus() {
    assertEquals(Status.VRIJ,testPlaats.getStatus());

    testPlaats.setStatus(Status.GERESERVEERD);
    assertEquals(Status.GERESERVEERD,testPlaats.getStatus());

    testPlaats.plaatsKlant(testKlant);
    assertEquals(Status.BEZET,testPlaats.getStatus());
  }

  @Test
  public void testSetStatus() {
    assertEquals(Status.VRIJ,testPlaats.getStatus());

    testPlaats.setStatus(Status.GERESERVEERD);
    assertEquals(Status.GERESERVEERD,testPlaats.getStatus());

    testPlaats.plaatsKlant(testKlant);
    assertEquals(Status.BEZET,testPlaats.getStatus());

    testPlaats.setStatus(Status.VRIJ);
    assertEquals(Status.BEZET,testPlaats.getStatus());

    testPlaats.setStatus(Status.GERESERVEERD);
    assertEquals(Status.BEZET,testPlaats.getStatus());
}

  @Test
  public void testPlaatsKlant() {
    assertEquals(Status.VRIJ,testPlaats.getStatus());

    testPlaats.plaatsKlant(testKlant);
    assertEquals(Status.BEZET,testPlaats.getStatus());
  }

}
