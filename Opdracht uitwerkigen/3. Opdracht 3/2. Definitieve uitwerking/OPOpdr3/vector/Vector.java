/**
 * 
 */
package vector;
import java.lang.Math;

/**
 * Klasse met diverse vector berekeningen
 * @author Johan Elzinga
 *
 */
public class Vector {

  private double x=0.0;
  private double y=0.0;
  private static final double EPSILON=1e-16;
  
  /**
   * Maakt een nieuwe vector aan met als startpunt 0,0 naar het gegeven eindpunt x,y 
   * @param x de x waarde van het eindpunt.
   * @param y de y waarde van het eindpunt.
   */
  public Vector(double x, double y)
  {
    this.x=x;
    this.y=y;
  }

  /**
   * Geeft de x waarde van deze vector terug.
   * @return de x waarde van deze vector.
   */
  public double getX() {
    return x;
  }
  
  /**
   * Geeft de y waarde van deze vector terug.
   * @return de y waarde van deze vector.
   */
  public double getY() {
    return y;
  }

   /**
   * Geeft de lengte van deze vector terug.
   * @return de lengte van de vector.
   */
  public double getLength() {
    return Math.sqrt(Math.pow(x,2.0)+Math.pow(y,2.0));
  }
  
  /**
   * Geeft de afstand terug tussen deze vector en de gegeven vector.
   * @param v De vector waarnaar de afstand moet worden gemeten.
   * @return De afstand tussen deze vector en de gegeven vector.
   */
  public double getAfstand(Vector v) {
    return Math.sqrt(Math.pow(x-v.x, 2)+Math.pow(y-v.y, 2));
  }

  /**
   * Geeft een vector terug welke de som is van deze vector en de gegeven vector.
   * @param v De vector die bij deze vector opgeteld moet worden.
   * @return Een nieuwe vector welke de som is van de twee vectoren.
   */
  public Vector plus(Vector v) {
    return new Vector(x+v.x,y+v.y);
  }

  /**
   * Geeft een kloon van deze vector terug.
   * @return Een kloon van deze vector.
   */
  public Vector copy() {
    return new Vector(x, y);
  }

  /**
   * Controleert of deze vector gelijk is aan de gegeven vector.
   * @param v De te controleren vector.
   * @return true als beide vectoren gelijk aan elkaar zijn anders false.
   */
  public boolean equals(Vector v) {
//    if(Math.abs(this.x-v.getX())<EPSILON && Math.abs(this.y-v.getY())<EPSILON) {
//      return true;
//    } else {
//      return false;
//    }
    return Math.abs(x-v.x)<EPSILON && Math.abs(y-v.y)<EPSILON;
  }
  
  /**
   * Geeft een nieuwe vector gelijk aan deze vector vermenigvuldigd met de opgegeven waarde.
   * @param d Vemenigvuldig waarde.
   * @return de nieuwe vector.
   */
  public Vector maal(double d) {
    return new Vector(x*d, y*d);
  }

  /**
   * Controleert of deze vector dezelfde richting heeft als de gegeven vector.
   * @param v De te controleren vector.
   * @return true als beide vectoren dezelfde richting hebben anders false.
   */
  public boolean heeftZelfdeRichting(Vector v) {
    if ((x == 0.0 && y == 0.0) || (v.x == 0.0 && v.y == 0.0)) {
      // Regel 1
      // 1 van de vectoren is [0,0] aanname is dat de vectoren dan altijd gelijk zijn.
      return false;
    } else if ((x==0.0 && v.x==0.0) || (y==0.0 && v.y==0.0)) {
      //  Regel 2
      // x1 en x2 zijn beide 0 dus doet y1/y2 er niet meer toe
      // y1 en y2 zijn beide 0 dus doet x1/x2 er niet meer toe
      // richtingen zijn gelijk
      return true;
    } else if ((v.x==0.0 && x!=0.0) || (v.y==0.0 && y!=0.0)) {
      // Regel 3
      // Deling door 0 afgevangen (vector2 x of y is 0 en waarbij vector1 x of y ongelijk aan 0. Dan zijn de richtingen niet gelijk).
      return false;
    } else {
      if ((x / v.x)-(y / v.y) < (0.0-EPSILON)) {
        // regel 4
        // waarde van gx-gy onder 0 dus ongelijke richting (vector1 x = 0 valt hier ook onder)
        return false;
      } else if ((x / v.x)-(y / v.y) > EPSILON) {
        // regel 5
        // waarde van gx-gy boven 0 dus ongelijke richting (vector1 y = 0 valt hier ook onder)
        return false;
      } else {
        // Regel 6
        // waarde gx-gy gelijk aan 0 (binnen de marge + en - van EPSILON) dus Gelijke richting
        return true;
      }
    }
  }
  
  /**
   * Geeft het inwendige product van deze vector en de gegeven vector.
   * @param v De vector waarmee het inwendige product moet worden berekend.
   * @return Het inwendige product van deze vector en de gegeven vector.
   */
  public double getInproduct(Vector v) {
    return (x*v.x+(y*v.y));
  }

  /**
   * Geeft het de hoek van deze vector.
   * @return De hoek van deze vector in radialen.
   * <br>Bijzonderheid: Wanneer de x waarde van de vector 0 is geeft deze methode 0.0 terug.
   */
  public double getHoek() {
    if (x!=0.0) {
      return (Math.atan(y/x));
    } else {
      return 0.0;
    }
  }
}
