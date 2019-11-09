import java.util.ArrayList;

import croho.Croho;
import croho.Instelling;
import croho.Instellingssoort;
import croho.Plaats;

public class CrohoSysteem {


  public static void main(String[] args) {
    Croho universiteit = new Croho();
    universiteit.init();
    
    // Opdracht 1.3a
    universiteit.voegtoeInstelling("Rijksuniversiteit Groningen", Instellingssoort.WO, "Groningen", 7654);
    
    // de volgende ArrayList wordt gebruikt voor opdrachten 1.3b + 1.3c + 1.3d
    ArrayList<Instelling> univeristeitenlijst = universiteit.getInstellingen();
    
    // de volgende twee variabelen worden gebruikt voor opdracht 1.3c
    int totaalWO = 0;
    int totaalHBO = 0;

    // Opdracht 1.3b
    for (Instelling i: univeristeitenlijst) {
      Plaats plaats = i.getPlaats();
      System.out.println(i.getNaam()+"("+i.getSoort()+") te "+plaats.getNaam());
    
      // Opdracht 1.3c
      if (i.getSoort().equals(Instellingssoort.WO)) {
        totaalWO = totaalWO + i.getAantalStudenten();
      } else {
        totaalHBO = totaalHBO + i.getAantalStudenten();
      }
    }
    
    // Output opdracht 1.3c
    System.out.println("Totaal aantal WO-studenten is "+totaalWO);
    System.out.println("Totaal aantal HBO-studenten is "+totaalHBO);

    // Opdracht 1.3d
    ArrayList<Plaats> plaatsenlijst = universiteit.getPlaatsen();
    for (Plaats p: plaatsenlijst) {
      int totaalAantalStudenten=0;
      
      for (Instelling i: univeristeitenlijst) {

// Alternatieve manier: (deze manier zal vermoedelijk meer tijd en geheugenruimte vergen?)
//        Plaats plaats = i.getPlaats();
//        if (plaats.getNaam().contentEquals(p.getNaam())) {
        if (i.getPlaats().getNaam().contentEquals(p.getNaam())) {
          totaalAantalStudenten = totaalAantalStudenten + i.getAantalStudenten();
        }
      }
      
      System.out.println("In "+p.getNaam()+" studeren "+totaalAantalStudenten+" studenten");
    }
  }

}
