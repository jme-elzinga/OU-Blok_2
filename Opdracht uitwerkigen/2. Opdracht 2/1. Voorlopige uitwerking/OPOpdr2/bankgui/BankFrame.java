package bankgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bank.Bank;
import bank.Rekening;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class BankFrame extends JFrame {

//----------------- Eigen attributen ---------------------------------------------

  private Bank mijnBank = new Bank();
  private Rekening rekeningVan = mijnBank.zoekRekening(1111);
  private Rekening rekeningNaar = mijnBank.zoekRekening(1234);

//----------------- Einde eigen attributen ---------------------------------------------

  private static final long serialVersionUID = 1L;
  private JPanel internetBankPaneel;
  private JPanel vanPaneel;
  private JLabel vanLabel;
  private JLabel reknrVanLabel;
  private JLabel naamVanLabel;
  private JLabel saldoVanLabel;
  private JLabel bedragVanLabel;
  private JTextField reknrVanVeld;
  private JTextField naamVanVeld;
  private JTextField saldoVanVeld;
  private JTextField bedragVanVeld;
  private JPanel naarPaneel;
  private JLabel naarLabel;
  private JLabel reknrNaarLabel;
  private JLabel naamNaarLabel;
  private JLabel saldoNaarLabel;
  private JLabel bedragNaarLabel;
  private JTextField reknrNaarVeld;
  private JTextField naamNaarVeld;
  private JTextField saldoNaarVeld;
  private JTextField bedragNaarVeld;
  private JLabel internetBankLabel;
  private JButton stortVanKnop;
  private JButton neemOpVanKnop;
  private JButton zoekVanKnop;
  private JButton maakOverKnop;
  private JButton stortNaarKnop;
  private JButton neemOpNaarKnop;
  private JButton zoekNaarKnop;

//----------------- Eigen methoden ---------------------------------------------

  /**
   * Eerste initialisatie van de Internet Bank waarden.
   */
  void mijnInit() {
    setVanPaneelWaarden();
    bedragVanVeld.setText("");
    setNaarPaneelWaarden();
    bedragNaarVeld.setText("");
  }

  /**
   * Stelt de waarden op het vanPaneel in.
   */
  private void setVanPaneelWaarden() {
    reknrVanVeld.setText(""+rekeningVan.getRekeningNummer());
    naamVanVeld.setText(rekeningVan.getNaam());
    saldoVanVeld.setText(""+rekeningVan.getSaldo());
  }
  
  /**
   * Stelt de waarde op het naarPaneel in.
   */
  private void setNaarPaneelWaarden() {
    reknrNaarVeld.setText(""+rekeningNaar.getRekeningNummer());
    naamNaarVeld.setText(rekeningNaar.getNaam());
    saldoNaarVeld.setText(""+rekeningNaar.getSaldo());
  }
  
  /**
   * Controleert of de te testen string inderdaad een integer bevat en geeft dan true terug, in alle andere gevallen false.
   * @param test de te testen string.
   * @return true of false.
   */
  private boolean sanityIntegerTest(String test) {
    try {
      Integer.parseInt(test);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
  
  /**
   * Controleert of de te testen string inderdaad een double bevat en geeft dan true terug, in alle andere gevallen false.
   * @param test de te testen string.
   * @return true of false.
   */
  private boolean sanityDoubleTest(String test) {
    try {
      Double.parseDouble(test);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  /**
   * De 'stort' knop onder het vanPaneel is ingedrukt.
   */
  private void stortVanKnopAction() {
    if (sanityIntegerTest(reknrVanVeld.getText()) && sanityDoubleTest(bedragVanVeld.getText())) {
      rekeningVan = mijnBank.zoekRekening(Integer.parseInt(reknrVanVeld.getText()));
      if(rekeningVan != null) {
        rekeningVan.stort(Double.parseDouble(bedragVanVeld.getText()));
        setVanPaneelWaarden();
        setNaarPaneelWaarden();
      }
    }
  }

  /**
   * De 'neem op' knop onder het vanPaneel is ingedrukt.
   */
  private void neemOpVanKnopAction() {
    if (sanityIntegerTest(reknrVanVeld.getText()) && sanityDoubleTest(bedragVanVeld.getText())) {
      rekeningVan = mijnBank.zoekRekening(Integer.parseInt(reknrVanVeld.getText()));
      if(rekeningVan != null) {
        rekeningVan.neemOp(Double.parseDouble(bedragVanVeld.getText()));
        setVanPaneelWaarden();
        setNaarPaneelWaarden();
      }
    }
  }
  
  /**
   * De 'zoek' knop onder het vanPaneel is ingedrukt.
   */
  private void zoekVanKnopAction() {
    if (sanityIntegerTest(reknrVanVeld.getText())) {
      rekeningVan = mijnBank.zoekRekening(Integer.parseInt(reknrVanVeld.getText()));
      if(rekeningVan != null) {
        setVanPaneelWaarden();
      } else {
        // Rekening niet gevonden, maak velden leeg.
        reknrVanVeld.setText("");
        naamVanVeld.setText("");
        saldoVanVeld.setText("");
        bedragVanVeld.setText("");
      }
    }
  }
  
  /**
   * De knop 'maak over' is ingedrukt.
   */
  private void maakOverKnopAction() {
    if (sanityIntegerTest(reknrVanVeld.getText()) && sanityIntegerTest(reknrNaarVeld.getText()) && sanityDoubleTest(bedragVanVeld.getText())) {
      rekeningVan = mijnBank.zoekRekening(Integer.parseInt(reknrVanVeld.getText()));
      rekeningNaar = mijnBank.zoekRekening(Integer.parseInt(reknrNaarVeld.getText()));
      if(rekeningVan != null && rekeningNaar != null) {
        mijnBank.maakOver(rekeningVan.getRekeningNummer(), rekeningNaar.getRekeningNummer(), Double.parseDouble(bedragVanVeld.getText()));
        setVanPaneelWaarden();
        setNaarPaneelWaarden();
        bedragNaarVeld.setText("");
      }
    }
  }
  
  /**
   * De 'stort' knop onder het naarPaneel is ingedrukt.
   */
  private void stortNaarKnopAction() {
    if (sanityIntegerTest(reknrNaarVeld.getText()) && sanityDoubleTest(bedragNaarVeld.getText())) {
      rekeningNaar = mijnBank.zoekRekening(Integer.parseInt(reknrNaarVeld.getText()));
      if(rekeningNaar != null) {
        rekeningNaar.stort(Double.parseDouble(bedragNaarVeld.getText()));
        setVanPaneelWaarden();
        setNaarPaneelWaarden();
      }
    }
  }

  /**
   * De 'neem op' knop onder het naarPaneel is ingedrukt.
   */
  private void neemOpNaarKnopAction() {
    if (sanityIntegerTest(reknrNaarVeld.getText()) && sanityDoubleTest(bedragNaarVeld.getText())) {
      rekeningNaar = mijnBank.zoekRekening(Integer.parseInt(reknrNaarVeld.getText()));
      if(rekeningNaar != null) {
        rekeningNaar.neemOp(Double.parseDouble(bedragNaarVeld.getText()));
        setVanPaneelWaarden();
        setNaarPaneelWaarden();
      }
    }
  }
  
  /**
   * De 'zoek' knop onder het naarPaneel is ingedrukt.
   */
  private void zoekNaarKnopAction() {
    if (sanityIntegerTest(reknrNaarVeld.getText())) {
      rekeningNaar = mijnBank.zoekRekening(Integer.parseInt(reknrNaarVeld.getText()));
      if(rekeningNaar != null) {
        setNaarPaneelWaarden();
      } else {
        // Rekening niet gevonden, maak velden leeg.
        reknrNaarVeld.setText("");
        naamNaarVeld.setText("");
        saldoNaarVeld.setText("");
        bedragNaarVeld.setText("");
      }
    }
  }

//----------------- Einde eigen methoden ---------------------------------------------
  
  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          BankFrame frame = new BankFrame();
          frame.setVisible(true);
        }
        catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public BankFrame() {
    initialize();
    mijnInit();
  }
  private void initialize() {
    setTitle("Bank Applicatie");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 710, 315);
    internetBankPaneel = new JPanel();
    internetBankPaneel.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(internetBankPaneel);
    internetBankPaneel.setLayout(null);
    internetBankPaneel.add(getVanPaneel());
    internetBankPaneel.add(getNaarPaneel());
    internetBankPaneel.add(getInternetBankLabel());
    internetBankPaneel.add(getStortVanKnop());
    internetBankPaneel.add(getNeemOpVanKnop());
    internetBankPaneel.add(getZoekVanKnop());
    internetBankPaneel.add(getMaakOverKnop());
    internetBankPaneel.add(getStortNaarKnop());
    internetBankPaneel.add(getNeemOpNaarKnop());
    internetBankPaneel.add(getZoekNaarKnop());
  }
  private JPanel getVanPaneel() {
    if (vanPaneel == null) {
    	vanPaneel = new JPanel();
    	vanPaneel.setBackground(Color.YELLOW);
    	vanPaneel.setBorder(null);
    	vanPaneel.setBounds(11, 36, 275, 178);
    	vanPaneel.setLayout(null);
    	vanPaneel.add(getVanLabel());
    	vanPaneel.add(getReknrVanLabel());
    	vanPaneel.add(getNaamVanLabel());
    	vanPaneel.add(getSaldoVanLabel());
    	vanPaneel.add(getBedragVanLabel());
    	vanPaneel.add(getReknrVanVeld());
    	vanPaneel.add(getNaamVanVeld());
    	vanPaneel.add(getSaldoVanVeld());
    	vanPaneel.add(getBedragVanVeld());
    }
    return vanPaneel;
  }
  private JLabel getVanLabel() {
    if (vanLabel == null) {
    	vanLabel = new JLabel("Van");
    	vanLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	vanLabel.setBounds(116, 18, 30, 14);
    }
    return vanLabel;
  }
  private JLabel getReknrVanLabel() {
    if (reknrVanLabel == null) {
    	reknrVanLabel = new JLabel("Rekeningnummer:");
    	reknrVanLabel.setBounds(10, 50, 125, 14);
    }
    return reknrVanLabel;
  }
  private JLabel getNaamVanLabel() {
    if (naamVanLabel == null) {
    	naamVanLabel = new JLabel("Naam:");
    	naamVanLabel.setBounds(10, 82, 99, 14);
    }
    return naamVanLabel;
  }
  private JLabel getSaldoVanLabel() {
    if (saldoVanLabel == null) {
    	saldoVanLabel = new JLabel("Saldo:");
    	saldoVanLabel.setBounds(10, 114, 99, 14);
    }
    return saldoVanLabel;
  }
  private JLabel getBedragVanLabel() {
    if (bedragVanLabel == null) {
    	bedragVanLabel = new JLabel("Bedrag:");
    	bedragVanLabel.setBounds(10, 146, 99, 14);
    }
    return bedragVanLabel;
  }
  private JTextField getReknrVanVeld() {
    if (reknrVanVeld == null) {
    	reknrVanVeld = new JTextField();
    	reknrVanVeld.setBounds(120, 47, 143, 20);
    	reknrVanVeld.setColumns(10);
    }
    return reknrVanVeld;
  }
  private JTextField getNaamVanVeld() {
    if (naamVanVeld == null) {
    	naamVanVeld = new JTextField();
    	naamVanVeld.setEditable(false);
    	naamVanVeld.setBounds(120, 79, 143, 20);
    	naamVanVeld.setColumns(10);
    }
    return naamVanVeld;
  }
  private JTextField getSaldoVanVeld() {
    if (saldoVanVeld == null) {
    	saldoVanVeld = new JTextField();
    	saldoVanVeld.setEditable(false);
    	saldoVanVeld.setBounds(120, 111, 143, 20);
    	saldoVanVeld.setColumns(10);
    }
    return saldoVanVeld;
  }
  private JTextField getBedragVanVeld() {
    if (bedragVanVeld == null) {
    	bedragVanVeld = new JTextField();
    	bedragVanVeld.setBounds(120, 143, 143, 20);
    	bedragVanVeld.setColumns(10);
    }
    return bedragVanVeld;
  }
  private JPanel getNaarPaneel() {
    if (naarPaneel == null) {
    	naarPaneel = new JPanel();
    	naarPaneel.setLayout(null);
    	naarPaneel.setBorder(null);
    	naarPaneel.setBackground(Color.YELLOW);
    	naarPaneel.setBounds(408, 36, 275, 178);
    	naarPaneel.add(getNaarLabel());
    	naarPaneel.add(getReknrNaarLabel());
    	naarPaneel.add(getNaamNaarLabel());
    	naarPaneel.add(getSaldoNaarLabel());
    	naarPaneel.add(getBedragNaarLabel());
    	naarPaneel.add(getReknrNaarVeld());
    	naarPaneel.add(getNaamNaarVeld());
    	naarPaneel.add(getSaldoNaarVeld());
    	naarPaneel.add(getBedragNaarVeld());
    }
    return naarPaneel;
  }
  private JLabel getNaarLabel() {
    if (naarLabel == null) {
    	naarLabel = new JLabel("Naar");
    	naarLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	naarLabel.setBounds(122, 18, 30, 14);
    }
    return naarLabel;
  }
  private JLabel getReknrNaarLabel() {
    if (reknrNaarLabel == null) {
    	reknrNaarLabel = new JLabel("Rekeningnummer:");
    	reknrNaarLabel.setBounds(10, 50, 125, 14);
    }
    return reknrNaarLabel;
  }
  private JLabel getNaamNaarLabel() {
    if (naamNaarLabel == null) {
    	naamNaarLabel = new JLabel("Naam:");
    	naamNaarLabel.setBounds(10, 82, 99, 14);
    }
    return naamNaarLabel;
  }
  private JLabel getSaldoNaarLabel() {
    if (saldoNaarLabel == null) {
    	saldoNaarLabel = new JLabel("Saldo:");
    	saldoNaarLabel.setBounds(10, 114, 99, 14);
    }
    return saldoNaarLabel;
  }
  private JLabel getBedragNaarLabel() {
    if (bedragNaarLabel == null) {
    	bedragNaarLabel = new JLabel("Bedrag:");
    	bedragNaarLabel.setBounds(10, 146, 99, 14);
    }
    return bedragNaarLabel;
  }
  private JTextField getReknrNaarVeld() {
    if (reknrNaarVeld == null) {
    	reknrNaarVeld = new JTextField();
    	reknrNaarVeld.setColumns(10);
    	reknrNaarVeld.setBounds(120, 47, 143, 20);
    }
    return reknrNaarVeld;
  }
  private JTextField getNaamNaarVeld() {
    if (naamNaarVeld == null) {
    	naamNaarVeld = new JTextField();
    	naamNaarVeld.setEditable(false);
    	naamNaarVeld.setColumns(10);
    	naamNaarVeld.setBounds(120, 79, 143, 20);
    }
    return naamNaarVeld;
  }
  private JTextField getSaldoNaarVeld() {
    if (saldoNaarVeld == null) {
    	saldoNaarVeld = new JTextField();
    	saldoNaarVeld.setEditable(false);
    	saldoNaarVeld.setColumns(10);
    	saldoNaarVeld.setBounds(120, 111, 143, 20);
    }
    return saldoNaarVeld;
  }
  private JTextField getBedragNaarVeld() {
    if (bedragNaarVeld == null) {
    	bedragNaarVeld = new JTextField();
    	bedragNaarVeld.setColumns(10);
    	bedragNaarVeld.setBounds(120, 143, 143, 20);
    }
    return bedragNaarVeld;
  }
  private JLabel getInternetBankLabel() {
    if (internetBankLabel == null) {
    	internetBankLabel = new JLabel("Internet Bank");
    	internetBankLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	internetBankLabel.setBounds(297, 11, 100, 14);
    }
    return internetBankLabel;
  }
  private JButton getStortVanKnop() {
    if (stortVanKnop == null) {
    	stortVanKnop = new JButton("stort");
    	stortVanKnop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent arg0) {
    	    stortVanKnopAction();
    	  }
    	});
    	stortVanKnop.setBounds(3, 232, 95, 23);
    }
    return stortVanKnop;
  }
  private JButton getNeemOpVanKnop() {
    if (neemOpVanKnop == null) {
    	neemOpVanKnop = new JButton("neem op");
    	neemOpVanKnop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent arg0) {
    	    neemOpVanKnopAction();
    	  }
    	});
    	neemOpVanKnop.setBounds(101, 232, 95, 23);
    }
    return neemOpVanKnop;
  }
  private JButton getZoekVanKnop() {
    if (zoekVanKnop == null) {
    	zoekVanKnop = new JButton("zoek");
    	zoekVanKnop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    zoekVanKnopAction();
    	  }
    	});
    	zoekVanKnop.setBounds(199, 232, 95, 23);
    }
    return zoekVanKnop;
  }
  private JButton getMaakOverKnop() {
    if (maakOverKnop == null) {
    	maakOverKnop = new JButton("maak over");
    	maakOverKnop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    maakOverKnopAction();
    	  }
    	});
    	maakOverKnop.setBounds(297, 232, 95, 23);
    }
    return maakOverKnop;
  }
  private JButton getStortNaarKnop() {
    if (stortNaarKnop == null) {
    	stortNaarKnop = new JButton("stort");
    	stortNaarKnop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    stortNaarKnopAction();
    	  }
    	});
    	stortNaarKnop.setBounds(395, 232, 95, 23);
    }
    return stortNaarKnop;
  }
  private JButton getNeemOpNaarKnop() {
    if (neemOpNaarKnop == null) {
    	neemOpNaarKnop = new JButton("neem op");
    	neemOpNaarKnop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    neemOpNaarKnopAction();
    	  }
    	});
    	neemOpNaarKnop.setBounds(493, 232, 95, 23);
    }
    return neemOpNaarKnop;
  }
  private JButton getZoekNaarKnop() {
    if (zoekNaarKnop == null) {
    	zoekNaarKnop = new JButton("zoek");
    	zoekNaarKnop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    zoekNaarKnopAction();
    	  }
    	});
    	zoekNaarKnop.setBounds(591, 232, 95, 23);
    }
    return zoekNaarKnop;
  }
  
}
