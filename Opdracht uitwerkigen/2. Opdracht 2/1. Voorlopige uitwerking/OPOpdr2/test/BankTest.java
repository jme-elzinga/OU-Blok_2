package test;

import bank.Bank;

/*
 * Testklasse voor klasse Bank.
 */
public class BankTest {

  public static void main(String[] args) {
    int zoekNummer1 = 1111;
    int zoekNummer2 = 9999;

    Bank bank = new Bank();
    //bank.init();
    System.out.println("Naam behorend bij rekening : " + zoekNummer1 + " is " + bank.zoekRekening(zoekNummer1).getNaam());
    if (bank.zoekRekening(zoekNummer2)!= null) {
      System.out.println("Naam behorend bij rekening : " + zoekNummer2 + " is " + bank.zoekRekening(zoekNummer2).getNaam());
    } else {
      System.out.println("Rekening "+zoekNummer2+" niet gevonden");
    }
  }

}
