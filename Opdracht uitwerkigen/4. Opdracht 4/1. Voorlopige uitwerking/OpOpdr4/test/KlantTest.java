/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import theater.Klant;

/**
 * @author Johan Elzinga
 *
 */
public class KlantTest {
  private Klant testKlant;
  private int klantnummer=10;
  private String naam="Johan Elzinga";
  private String telefoon="06-12345678";

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    testKlant=new Klant(klantnummer,naam,telefoon);
  }

  /**
   * Test method for {@link theater.Klant#Klant(int, java.lang.String, java.lang.String)}.
   */
  @Test
  public void testKlant() {
    testKlant=new Klant(klantnummer,naam,telefoon);
  }

  /**
   * Test method for {@link theater.Klant#getKlantnummer()}.
   */
  @Test
  public void testGetKlantnummer() {
    assertEquals(10,testKlant.getKlantnummer());
  }

  /**
   * Test method for {@link theater.Klant#getNaam()}.
   */
  @Test
  public void testGetNaam() {
    assertEquals("Johan Elzinga",testKlant.getNaam());
  }

  /**
   * Test method for {@link theater.Klant#telefoon()}.
   */
  @Test
  public void testTelefoon() {
    assertEquals("06-12345678",testKlant.getTelefoon());
  }

  /**
   * Test method for {@link theater.Klant#klantGegevens()}.
   */
  @Test
  public void testToString() {
    assertEquals("klantnummer=10,naam=Johan Elzinga,telefoon=06-12345678",testKlant.toString());
  }

}
