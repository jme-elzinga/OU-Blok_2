package test;

import bank.Bank;
import bank.Rekening;

/*
 * Testklasse voor klasse Rekening.
 */
public class RekeningTest {

   public static void main(String[] args) {
    int nummer = 1111;
    double storting1 = 12.50;
    double storting2 = 0.0;
    double storting3 = -10.0;
    double opname1 = 7.0;
    double opname2 = 0.0;
    double opname3 = -7.0;
    double opname4 = 5.5;
    double opname5 = 1.0;
    Bank mijnBank = new Bank();
    Rekening mijnRekening = mijnBank.zoekRekening(nummer);
    
    System.out.println("naam  : " + mijnRekening.getNaam());
    System.out.println("nummer: " + mijnRekening.getRekeningNummer());
    System.out.println("saldo : " + mijnRekening.getSaldo()+"\n");
    
    mijnRekening.stort(storting1);
    System.out.println("saldo na storting van  " + storting1 + ": " + mijnRekening.getSaldo());
    
    mijnRekening.stort(storting2);
    System.out.println("saldo na storting van   " + storting2 + ": " + mijnRekening.getSaldo());

    mijnRekening.stort(storting3);
    System.out.println("saldo na storting van " + storting3 + ": " + mijnRekening.getSaldo()+"\n");

    mijnRekening.neemOp(opname1);
    System.out.println("saldo na opname van     " + opname1 + ":  " + mijnRekening.getSaldo());

    mijnRekening.neemOp(opname2);
    System.out.println("saldo na opname van     " + opname2 + ":  " + mijnRekening.getSaldo());
 
    mijnRekening.neemOp(opname3);
    System.out.println("saldo na opname van    " + opname3 + ":  " + mijnRekening.getSaldo());
    
    mijnRekening.neemOp(opname4);
    System.out.println("saldo na opname van     " + opname4 + ":  " + mijnRekening.getSaldo());
    
    mijnRekening.neemOp(opname5);
    System.out.println("saldo na opname van     " + opname5 + ":  " + mijnRekening.getSaldo());

  }

}
