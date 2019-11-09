/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vector.Vector;

/**
 * @author Johan
 *
 */
class VectorTest {

  private static final double DELTA = 0.01;
  private Vector testVector1;
  private Vector testVector2;
  private Vector testVector3;
  private Vector testVector4;
  private Vector testVector5;
  private Vector testVector6;
  private Vector testVector7;
  private Vector testVector8;
  private Vector testVector9;
  private Vector testVector10;
  private Vector testVector11;
  private Vector testVector12;
  private Vector testVector13;

  /**
   * @throws java.lang.Exception
   */
  @BeforeEach
  void setUp() throws Exception {
    testVector1=new Vector(3.0,4.0);
    testVector2=new Vector(3.0,-4.0);
    testVector3=new Vector(-3.0,-4.0);
    testVector4=new Vector(-3.0,4.0);
    testVector5=new Vector(0.0,0.0);
    testVector6=new Vector(6.0,8.0);
    testVector7=new Vector(6.0,-8.0);
    testVector8=new Vector(-6.0,-8.0);
    testVector9=new Vector(-6.0,8.0);
    testVector10=new Vector(0.0,10.0);
    testVector11=new Vector(10.0,0.0);
    testVector12=new Vector(0.0,20.0);
    testVector13=new Vector(20.0,0.0);
}

  /**
   * Test method for vector.getLength
   */
  @Test
  void testGetLength() {
    assertEquals(5.0, testVector1.getLength(), DELTA);
    assertEquals(5.0, testVector2.getLength(), DELTA);
    assertEquals(5.0, testVector3.getLength(), DELTA);
    assertEquals(5.0, testVector4.getLength(), DELTA);
    assertEquals(0.0, testVector5.getLength(), DELTA);
    assertEquals(10.0, testVector10.getLength(), DELTA);
    assertEquals(10.0, testVector11.getLength(), DELTA);
  }

  /**
   * Test method for vector.getAfstand
   */
  @Test
  void testGetAfstand() {
    assertEquals(8.0, testVector1.getAfstand(testVector2), DELTA);
    assertEquals(10.0, testVector1.getAfstand(testVector3), DELTA);
    assertEquals(6.0, testVector1.getAfstand(testVector4), DELTA);
    assertEquals(5.0, testVector1.getAfstand(testVector5), DELTA);
    assertEquals(6.71, testVector1.getAfstand(testVector10), DELTA);
    assertEquals(8.06, testVector1.getAfstand(testVector11), DELTA);
    assertEquals(6.0, testVector2.getAfstand(testVector3), DELTA);
    assertEquals(10.0, testVector2.getAfstand(testVector4), DELTA);
    assertEquals(5.0, testVector2.getAfstand(testVector5), DELTA);
    assertEquals(14.32, testVector2.getAfstand(testVector10), DELTA);
    assertEquals(8.06, testVector2.getAfstand(testVector11), DELTA);
    assertEquals(8.0, testVector3.getAfstand(testVector4), DELTA);
    assertEquals(5.0, testVector3.getAfstand(testVector5), DELTA);
    assertEquals(14.32, testVector3.getAfstand(testVector10), DELTA);
    assertEquals(13.60, testVector3.getAfstand(testVector11), DELTA);
    assertEquals(5.0, testVector4.getAfstand(testVector5), DELTA);
    assertEquals(6.71, testVector4.getAfstand(testVector10), DELTA);
    assertEquals(13.60, testVector4.getAfstand(testVector11), DELTA);
  }

  /**
   * Test method for vector.plus
   */
  @Test
  void testPlus() {
    assertEquals(6,testVector1.plus(testVector1).getX(), DELTA);
    assertEquals(8,testVector1.plus(testVector1).getY(), DELTA);
    assertEquals(6,testVector1.plus(testVector2).getX(), DELTA);
    assertEquals(0,testVector1.plus(testVector2).getY(), DELTA);
    assertEquals(0,testVector1.plus(testVector3).getX(), DELTA);
    assertEquals(0,testVector1.plus(testVector3).getY(), DELTA);
    assertEquals(0,testVector1.plus(testVector4).getX(), DELTA);
    assertEquals(8,testVector1.plus(testVector4).getY(), DELTA);
    assertEquals(3,testVector1.plus(testVector5).getX(), DELTA);
    assertEquals(4,testVector1.plus(testVector5).getY(), DELTA);
    assertEquals(3,testVector1.plus(testVector10).getX(), DELTA);
    assertEquals(14,testVector1.plus(testVector10).getY(), DELTA);
    assertEquals(13,testVector1.plus(testVector11).getX(), DELTA);
    assertEquals(4,testVector1.plus(testVector11).getY(), DELTA);
    assertEquals(6.0, testVector2.plus(testVector2).getX(), DELTA);
    assertEquals(-8.0, testVector2.plus(testVector2).getY(), DELTA);
    assertEquals(0.0, testVector2.plus(testVector3).getX(), DELTA);
    assertEquals(-8.0, testVector2.plus(testVector3).getY(), DELTA);
    assertEquals(0.0, testVector2.plus(testVector4).getX(), DELTA);
    assertEquals(0.0, testVector2.plus(testVector4).getY(), DELTA);
    assertEquals(3.0, testVector2.plus(testVector5).getX(), DELTA);
    assertEquals(-4.0, testVector2.plus(testVector5).getY(), DELTA);
    assertEquals(3.0, testVector2.plus(testVector10).getX(), DELTA);
    assertEquals(6, testVector2.plus(testVector10).getY(), DELTA);
    assertEquals(13.0, testVector2.plus(testVector11).getX(), DELTA);
    assertEquals(-4.0, testVector2.plus(testVector11).getY(), DELTA);
    assertEquals(-6.0, testVector3.plus(testVector3).getX(), DELTA);
    assertEquals(-8.0, testVector3.plus(testVector3).getY(), DELTA);
    assertEquals(-6.0, testVector3.plus(testVector4).getX(), DELTA);
    assertEquals(0.0, testVector3.plus(testVector4).getY(), DELTA);
    assertEquals(-3.0, testVector3.plus(testVector5).getX(), DELTA);
    assertEquals(-4.0, testVector3.plus(testVector5).getY(), DELTA);
    assertEquals(-3.0, testVector3.plus(testVector10).getX(), DELTA);
    assertEquals(6.0, testVector3.plus(testVector10).getY(), DELTA);
    assertEquals(7.0, testVector3.plus(testVector11).getX(), DELTA);
    assertEquals(-4.0, testVector3.plus(testVector11).getY(), DELTA);
    assertEquals(-6.0, testVector4.plus(testVector4).getX(), DELTA);
    assertEquals(8.0, testVector4.plus(testVector4).getY(), DELTA);
    assertEquals(-3.0, testVector4.plus(testVector5).getX(), DELTA);
    assertEquals(4.0, testVector4.plus(testVector5).getY(), DELTA);
    assertEquals(-3.0, testVector4.plus(testVector10).getX(), DELTA);
    assertEquals(14.0, testVector4.plus(testVector10).getY(), DELTA);
    assertEquals(7.0, testVector4.plus(testVector11).getX(), DELTA);
    assertEquals(4.0, testVector4.plus(testVector11).getY(), DELTA);
    assertEquals(0.0, testVector5.plus(testVector5).getX(), DELTA);
    assertEquals(0.0, testVector5.plus(testVector5).getY(), DELTA);
    assertEquals(0.0, testVector5.plus(testVector10).getX(), DELTA);
    assertEquals(10.0, testVector5.plus(testVector10).getY(), DELTA);
    assertEquals(10.0, testVector5.plus(testVector11).getX(), DELTA);
    assertEquals(0.0, testVector5.plus(testVector11).getY(), DELTA);
    assertEquals(0.0, testVector10.plus(testVector10).getX(), DELTA);
    assertEquals(20.0, testVector10.plus(testVector10).getY(), DELTA);
    assertEquals(10.0, testVector10.plus(testVector11).getX(), DELTA);
    assertEquals(10.0, testVector10.plus(testVector11).getY(), DELTA);
    assertEquals(20.0, testVector11.plus(testVector11).getX(), DELTA);
    assertEquals(0.0, testVector11.plus(testVector11).getY(), DELTA);
  }

  /**
   * Test method for vector.copy
   */
  @Test
  void testCopy() {
    assertEquals(3.0,testVector1.copy().getX(), DELTA);
    assertEquals(4.0,testVector1.copy().getY(), DELTA);
  }

  /**
   * Test method for vector.equals
   */
  @Test
  void testEquals() {
    assertTrue(testVector1.equals(testVector1));
    assertFalse(testVector1.equals(testVector2));
    assertFalse(testVector1.equals(testVector3));
    assertFalse(testVector1.equals(testVector4));
    assertFalse(testVector1.equals(testVector5));
    assertFalse(testVector1.equals(testVector10));
    assertFalse(testVector1.equals(testVector11));
    assertTrue(testVector2.equals(testVector2));
    assertFalse(testVector2.equals(testVector3));
    assertFalse(testVector2.equals(testVector4));
    assertFalse(testVector2.equals(testVector5));
    assertFalse(testVector2.equals(testVector10));
    assertFalse(testVector2.equals(testVector11));
    assertTrue(testVector3.equals(testVector3));
    assertFalse(testVector3.equals(testVector4));
    assertFalse(testVector3.equals(testVector5));
    assertFalse(testVector3.equals(testVector10));
    assertFalse(testVector3.equals(testVector11));
    assertTrue(testVector4.equals(testVector4));
    assertFalse(testVector4.equals(testVector5));
    assertFalse(testVector4.equals(testVector10));
    assertFalse(testVector4.equals(testVector11));
    assertTrue(testVector5.equals(testVector5));
    assertTrue(testVector10.equals(testVector10));
    assertFalse(testVector10.equals(testVector11));
    assertTrue(testVector11.equals(testVector11));
  }

  /**
   * Test method for vector.maal
   */
  @Test
  void testMaal() {
    assertEquals(6.0,testVector1.maal(2.0).getX(), DELTA);
    assertEquals(8.0,testVector1.maal(2.0).getY(), DELTA);
    assertEquals(0.0,testVector1.maal(0.0).getX(), DELTA);
    assertEquals(0.0,testVector1.maal(0.0).getY(), DELTA);
    assertEquals(-6.0,testVector1.maal(-2.0).getX(), DELTA);
    assertEquals(-8.0,testVector1.maal(-2.0).getY(), DELTA);
    assertEquals(6.0,testVector2.maal(2.0).getX(), DELTA);
    assertEquals(-8.0,testVector2.maal(2.0).getY(), DELTA);
    assertEquals(0.0,testVector2.maal(0.0).getX(), DELTA);
    assertEquals(0.0,testVector2.maal(0.0).getY(), DELTA);
    assertEquals(-6.0,testVector2.maal(-2.0).getX(), DELTA);
    assertEquals(8.0,testVector2.maal(-2.0).getY(), DELTA);
    assertEquals(-6.0,testVector3.maal(2.0).getX(), DELTA);
    assertEquals(-8.0,testVector3.maal(2.0).getY(), DELTA);
    assertEquals(0.0,testVector3.maal(0.0).getX(), DELTA);
    assertEquals(0.0,testVector3.maal(0.0).getY(), DELTA);
    assertEquals(6.0,testVector3.maal(-2.0).getX(), DELTA);
    assertEquals(8.0,testVector3.maal(-2.0).getY(), DELTA);
    assertEquals(-6.0,testVector4.maal(2.0).getX(), DELTA);
    assertEquals(8.0,testVector4.maal(2.0).getY(), DELTA);
    assertEquals(0.0,testVector4.maal(0.0).getX(), DELTA);
    assertEquals(0.0,testVector4.maal(0.0).getY(), DELTA);
    assertEquals(6.0,testVector4.maal(-2.0).getX(), DELTA);
    assertEquals(-8.0,testVector4.maal(-2.0).getY(), DELTA);
    assertEquals(0.0,testVector5.maal(2.0).getX(), DELTA);
    assertEquals(0.0,testVector5.maal(2.0).getY(), DELTA);
    assertEquals(0.0,testVector5.maal(0.0).getX(), DELTA);
    assertEquals(0.0,testVector5.maal(0.0).getY(), DELTA);
    assertEquals(-0.0,testVector5.maal(-2.0).getX(), DELTA);
    assertEquals(-0.0,testVector5.maal(-2.0).getY(), DELTA);
    assertEquals(0.0,testVector10.maal(2.0).getX(), DELTA);
    assertEquals(20.0,testVector10.maal(2.0).getY(), DELTA);
    assertEquals(0.0,testVector10.maal(0.0).getX(), DELTA);
    assertEquals(0.0,testVector10.maal(0.0).getY(), DELTA);
    assertEquals(-0.0,testVector10.maal(-2.0).getX(), DELTA);
    assertEquals(-20.0,testVector10.maal(-2.0).getY(), DELTA);
    assertEquals(20.0,testVector11.maal(2.0).getX(), DELTA);
    assertEquals(0.0,testVector11.maal(2.0).getY(), DELTA);
    assertEquals(0.0,testVector11.maal(0.0).getX(), DELTA);
    assertEquals(0.0,testVector11.maal(0.0).getY(), DELTA);
    assertEquals(-20.0,testVector11.maal(-2.0).getX(), DELTA);
    assertEquals(-0.0,testVector11.maal(-2.0).getY(), DELTA);
  }

  /**
   * Test method for vector.heeftZelfdeRichting
   */
  @Test
  void testHeeftZelfdeRichting() {
    // Vector met zichzelf vergelijken in alle 4 kwadranten
    // Regel 6
    assertTrue(testVector1.heeftZelfdeRichting(testVector1));
    assertTrue(testVector2.heeftZelfdeRichting(testVector2));
    assertTrue(testVector3.heeftZelfdeRichting(testVector3));
    assertTrue(testVector4.heeftZelfdeRichting(testVector4));
    
    // Vector vergelijken met een vector met b.v. een dubble lengte in alle 4 kwadranten
    // Regel 6
    assertTrue(testVector1.heeftZelfdeRichting(testVector6));
    assertTrue(testVector2.heeftZelfdeRichting(testVector7));
    assertTrue(testVector3.heeftZelfdeRichting(testVector8));
    assertTrue(testVector4.heeftZelfdeRichting(testVector9));

    // Vector vergelijken met [0,0] vector in alle 4 kwadranten
    // Regel 1
    assertFalse(testVector1.heeftZelfdeRichting(testVector5));
    assertFalse(testVector2.heeftZelfdeRichting(testVector5));
    assertFalse(testVector3.heeftZelfdeRichting(testVector5));
    assertFalse(testVector4.heeftZelfdeRichting(testVector5));

    // beide vectors hebben een X gelijk aan 0
    // Regel 2
    assertTrue(testVector10.heeftZelfdeRichting(testVector12));
    // beide vectors hebben een Y gelijk aan 0
    // Regel 2
    assertTrue(testVector11.heeftZelfdeRichting(testVector13));

    // Vector10 heeft een x gelijk aan 0 en Vector1 heeft een x ongelijk aan 0
    // Regel 3
    assertFalse(testVector1.heeftZelfdeRichting(testVector10));
    // Vector11 heeft een y gelijk aan 0 en Vector1 heeft een y ongelijk aan 0
    // Regel 3
    assertFalse(testVector1.heeftZelfdeRichting(testVector11));

    // Vector10 heeft een x gelijk aan 0 en Vector1 heeft een x ongelijk aan 0
    // Regel 4
    assertFalse(testVector10.heeftZelfdeRichting(testVector1));
    // Vector11 heeft een y gelijk aan 0 en Vector1 heeft een y ongelijk aan 0
    // Regel 5
    assertFalse(testVector11.heeftZelfdeRichting(testVector1));

 
    // Vector1 (kwadrant 1) vergelijken met Vector2 (kwadrant 2)
    // Regel 5
    assertFalse(testVector1.heeftZelfdeRichting(testVector2));
    // Vector1 (kwadrant 1) vergelijken met Vector3 (kwadrant 3)
    // Regel 5
    assertFalse(testVector1.heeftZelfdeRichting(testVector2));
    // Vector1 (kwadrant 1) vergelijken met Vector4 (kwadrant 4)
    // Regel 4
    assertFalse(testVector1.heeftZelfdeRichting(testVector4));
  }

  /**
   * Test method for vector.getInproduct
   */
  @Test
  void testGetInproduct() {
    assertEquals(-7.0, testVector1.getInproduct(testVector2), DELTA);
    assertEquals(-25.0, testVector1.getInproduct(testVector3), DELTA);
    assertEquals(7.0, testVector1.getInproduct(testVector4), DELTA);
    assertEquals(0.0, testVector1.getInproduct(testVector5), DELTA);
    assertEquals(40.0, testVector1.getInproduct(testVector10), DELTA);
    assertEquals(30.0, testVector1.getInproduct(testVector11), DELTA);
    assertEquals(7.0, testVector2.getInproduct(testVector3), DELTA);
    assertEquals(-25.0, testVector2.getInproduct(testVector4), DELTA);
    assertEquals(0.0, testVector2.getInproduct(testVector5), DELTA);
    assertEquals(-40.0, testVector2.getInproduct(testVector10), DELTA);
    assertEquals(30.0, testVector2.getInproduct(testVector11), DELTA);
    assertEquals(-7.0, testVector3.getInproduct(testVector4), DELTA);
    assertEquals(0.0, testVector3.getInproduct(testVector5), DELTA);
    assertEquals(-40.0, testVector3.getInproduct(testVector10), DELTA);
    assertEquals(-30.0, testVector3.getInproduct(testVector11), DELTA);
    assertEquals(0.0, testVector4.getInproduct(testVector5), DELTA);
    assertEquals(40.0, testVector4.getInproduct(testVector10), DELTA);
    assertEquals(-30.0, testVector4.getInproduct(testVector11), DELTA);
    assertEquals(0.0, testVector5.getInproduct(testVector10), DELTA);
    assertEquals(0.0, testVector5.getInproduct(testVector11), DELTA);
    assertEquals(0.0, testVector10.getInproduct(testVector11), DELTA);
    assertEquals(100.0, testVector11.getInproduct(testVector11), DELTA);
  }

  /**
   * Test method for vector.getHoek
   */
  @Test
  void testGetHoek() {
    assertEquals(0.93, testVector1.getHoek(), DELTA);
    assertEquals(-0.93, testVector2.getHoek(), DELTA);
    assertEquals(0.93, testVector3.getHoek(), DELTA);
    assertEquals(-0.93, testVector4.getHoek(), DELTA);
    assertEquals(0.0, testVector5.getHoek(), DELTA);
    assertEquals(0.0, testVector10.getHoek(), DELTA);
    assertEquals(0.0, testVector11.getHoek(), DELTA);
  }
}
