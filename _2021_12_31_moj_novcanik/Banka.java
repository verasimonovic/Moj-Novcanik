package _2021_12_31_moj_novcanik;

import java.util.ArrayList;

/**
 * Banka koja sadrzi listu klijenta i naziv.
 */
public class Banka {
  private String naziv;
  private ArrayList<Klijent> klijenti;

  public Banka(String naziv) {
    this.naziv = naziv;
    this.klijenti = new ArrayList<>();
  }

  public String getNaziv() {
    return naziv;
  }

  public void setNaziv(String naziv) {
    this.naziv = naziv;
  }

  public ArrayList<Klijent> getKlijenti() {
    return klijenti;
  }

  public void setKlijenti(ArrayList<Klijent> klijenti) {
    this.klijenti = klijenti;
  }

  /**
   * Dodaje klijenta ako prethodno vec nije dodat.
   *
   * @param klijent
   */
  public void dodajKlijenta(Klijent klijent){
    if (!this.klijenti.contains(klijent)) {
      this.klijenti.add(klijent);
    }
  }

  /**
   * Vraca klijenta koji sadrzi dati username.
   *
   * @param username
   * @return
   */
  public Klijent pronadjiKlijenta(String username) {
    Klijent klijent = null;
    for (int i = 0; i < klijenti.size(); i++) {
      klijent = klijenti.get(0);
      if (klijent.getUsername().equals(username)) {
        break;
      }
    }
    return klijent;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Banka").append("\n");
    sb.append("[ naziv: ").append(naziv).append("\n");
    sb.append(", klijenti: ").append("\n");
    for(Klijent klijent: klijenti) {
      sb.append(klijent).append("\n");
    }
    sb.append("]");
    return sb.toString();
  }
}
