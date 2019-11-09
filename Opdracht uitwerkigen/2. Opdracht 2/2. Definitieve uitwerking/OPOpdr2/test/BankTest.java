package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bank.Bank;

class BankTest {

  private static final double DELTA = 0.01;
  private Bank testBank;
  
  @BeforeEach
  void setUp() {
    testBank = new Bank();
  }

  @Test
  void testRekeningBestaat() {
    // Test op bestaande rekening
    assertEquals(true, testBank.rekeningBestaat(1111));

    // Test op niet bestaande rekening
    assertEquals(false, testBank.rekeningBestaat(9999));
  }

  @Test
  void testGetNaam() {
    // Test op bestaande rekening
    assertEquals("AKO",testBank.getNaam(1111));
    
    // Test op niet bestaande rekening
    assertEquals("", testBank.getNaam(9999));
  }

  @Test
  void testGetSaldo() {
    // Test op bestaande rekening
    assertEquals(0.0,testBank.getSaldo(1111),DELTA);
    
    // Test op niet bestaande rekening
    assertEquals(0.0,testBank.getSaldo(9999),DELTA);
  }

  @Test
  void testMaakOver() {
    // Initieel bedrag nodig op een rekening om te kunnen testen
    testBank.stort(2222, 10.00);

    // Test van bestaande rekening naar bestaande rekening met een normaal bedrag
    assertEquals(10.00,testBank.getSaldo(2222),DELTA);
    testBank.maakOver(2222, 2345, 5);
    assertEquals(5.00,testBank.getSaldo(2222),DELTA);
    assertEquals(5.00,testBank.getSaldo(2345),DELTA);
 
    // Test van bestaande rekening naar bestaande rekening met een 0 bedrag
    assertEquals(5.00,testBank.getSaldo(2222),DELTA);
    testBank.maakOver(2222, 2345, 0);
    assertEquals(5.00,testBank.getSaldo(2222),DELTA);
    assertEquals(5.00,testBank.getSaldo(2345),DELTA);

    // Test van bestaande rekening naar bestaande rekening met een negatief bedrag
    assertEquals(5.00,testBank.getSaldo(2222),DELTA);
    testBank.maakOver(2222, 2345, -5);
    assertEquals(5.00,testBank.getSaldo(2222),DELTA);
    assertEquals(5.00,testBank.getSaldo(2345),DELTA);

    // Test van bestaande rekening naar niet bestaande rekening
    testBank.maakOver(2222, 9999, 5);
    assertEquals(5.00,testBank.getSaldo(2222),DELTA);

    // Test van niet bestaande rekening naar bestaande rekening
    testBank.maakOver(9999, 2222, 5);
    assertEquals(5.00,testBank.getSaldo(2222),DELTA);
  }

  @Test
  void testStort() {
    // Controleren op 0 saldo
    assertEquals(0.00,testBank.getSaldo(1111),DELTA);

    // Stort negatief bedrag
    testBank.stort(1111, -10.00);
    assertEquals(0.00,testBank.getSaldo(1111),DELTA);

    // Stort 0
    testBank.stort(1111, 0.00);
    assertEquals(0.00,testBank.getSaldo(1111),DELTA);

    // Stort positief bedrag
    testBank.stort(1111, 10.00);
    assertEquals(10.00,testBank.getSaldo(1111),DELTA);
  }

  @Test
  void testNeemOp() {
    // Controleren op 0 saldo
    assertEquals(0.00,testBank.getSaldo(3333),DELTA);

    // Stort positief bedrag
    testBank.stort(3333, 10.00);
    assertEquals(10.00,testBank.getSaldo(3333),DELTA);

    // Probeer een te groot saldo op te nemen
    testBank.neemOp(3333, 11.00);
    assertEquals(10.00,testBank.getSaldo(3333),DELTA);

    // Test een 0 opname
    testBank.neemOp(3333, 0.00);
    assertEquals(10.00,testBank.getSaldo(3333),DELTA);

    // Test een normale opname
    testBank.neemOp(3333, 5.00);
    assertEquals(5.00,testBank.getSaldo(3333),DELTA);

    // Test een negatieve opname
    testBank.neemOp(3333, -5.00);
    assertEquals(5.00,testBank.getSaldo(3333),DELTA);
  }
}
