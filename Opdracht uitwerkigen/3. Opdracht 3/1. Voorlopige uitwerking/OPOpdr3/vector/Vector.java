/**
 * 
 */
package vector;
import java.lang.Math;

/**
 * Klasse met diverse vector berekeningen
 * @author Johan
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
    return this.x;
  }
  
  /**
   * Geeft de y waarde van deze vector terug.
   * @return de y waarde van deze vector.
   */
  public double getY() {
    return this.y;
  }

   /**
   * Geeft de lengte van deze vector terug.
   * @return de lengte van de vector.
   */
  public double getLength() {
    return Math.sqrt(Math.pow(this.x,2.0)+Math.pow(this.y,2.0));
  }
  
  /**
   * Geeft de afstand terug tussen deze vector en de gegeven vector.
   * @param v De vector waarnaar de afstand moet worden gemeten.
   * @return De afstand tussen deze vector en de gegeven vector.
   */
  public double getAfstand(Vector v) {
    return Math.sqrt(Math.pow(this.x-v.getX(), 2)+Math.pow(this.y-v.getY(), 2));
  }

  /**
   * Geeft een vector terug welke de som is van deze vector en de gegeven vector.
   * @param v De vector die bij deze vector opgeteld moet worden.
   * @return Een nieuwe vector welke de som is van de twee vectoren.
   */
  public Vector plus(Vector v) {
    return new Vector(this.x+v.getX(),this.y+v.getY());
  }

  /**
   * Geeft een kloon van deze vector terug.
   * @return Een kloon van deze vector.
   */
  public Vector copy() {
    return new Vector(this.x, this.y);
  }

  /**
   * Controleert of deze vector gelijk is aan de gegeven vector.
   * @param v De te controleren vector.
   * @return true als beide vectoren gelijk aan elkaar zijn anders false.
   */
  public boolean equals(Vector v) {
    if(Math.abs(this.x-v.getX())<EPSILON && Math.abs(this.y-v.getY())<EPSILON) {
      return true;
    } else {
      return false;
    }
  }
  
  /**
   * Geeft een nieuwe vector gelijk aan deze vector vermenigvuldigd met de opgegeven waarde.
   * @param d Vemenigvuldig waarde.
   * @return de nieuwe vector.
   */
  public Vector maal(double d) {
    return new Vector(this.x*d, this.y*d);
  }

  /**
   * Controleert of deze vector dezelfde richting heeft als de gegeven vector.
   * @param v De te controleren vector.
   * @return true als beide vectoren dezelfde richting hebben anders false.
   */
  public boolean heeftZelfdeRichting(Vector v) {
    if (this.x==0.0 && v.getX()==0.0 && this.y/v.getY()>=0.0) {
      // Wanneer de X waarde van beide vectoren gelijk aan 0 is EN wanneer de y waarden gedeeld door elkaar gelijk of groter dan 0 is dan is de richting gelijk
      return true;
    } else if (this.y==0.0 && v.getY()==0.0 && this.x/v.getX()>=0.0) {
      // Wanneer de Y waarde van beide vectoren gelijk aan 0 is EN wanneer de x waarden gedeeld door elkaar gelijk of groter dan 0 is dan is de richting gelijk
      return true;
    } else if ((this.x/v.getX())-(this.y/v.getY()) < EPSILON && this.x/v.getX()>=0.0) {
      // Wanneer de X waarden gedeeld door elkaar minus de y waarden gedeeld door elkaar gelijk aan 0 is EN de X waarden gedeeld door elkaar gelijk of groter dan 0 is dan is de richting gelijk 
      return true;
    } else if ((this.x==0.0 & this.y==0.0) || (v.getX()==0.0 && v.getY()==0.0)) {
      // wanneer 1 van beide vectoren [0,0] is dan is de richting altijd gelijk.
      return true;
    } else {
      // de richtingen zijn ongelijk.
      return false;
    }
  }
  
  /**
   * Geeft het inwendige product van deze vector en de gegeven vector.
   * @param v De vector waarmee het inwendige product moet worden berekend.
   * @return Het inwendige product van deze vector en de gegeven vector.
   */
  public double getInproduct(Vector v) {
    return (this.x*v.getX()+(this.y*v.getY()));
  }

  /**
   * Geeft het de hoek van deze vector.
   * @return De hoek van deze vector in radialen.
   * <br>Bijzonderheid: Wanneer de x waarde van de vector 0 is geeft deze methode 0.0 terug.
   */
  public double getHoek() {
    if (this.x!=0.0) {
      return (Math.atan(this.y/this.x));
    } else {
      return 0.0;
    }
  }
}
