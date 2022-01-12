package _2021_12_31_moj_novcanik;

import java.util.ArrayList;

/**
 * Racun sadrzi broj racuna, iznos, valutu i listu odradjenih transakcija.
 */
public class Racun {
  private static int NextId = 1;

  private long brojRacuna;
  private double iznos;
  private String valuta;
  private ArrayList<Transakcija> transakcije;

  public Racun(double iznos) {
    this.iznos = iznos;
    this.valuta = "RSD";
    this.transakcije = new ArrayList<>();
    this.brojRacuna = NextId;
    NextId++;
  }

  public Racun(double iznos, String valuta) {
    this.iznos = iznos;
    this.valuta = valuta;
    this.transakcije = new ArrayList<>();
    this.brojRacuna = NextId;
    NextId++;
  }

  public void dodajIznos(double iznos) {
    this.iznos += iznos;
  }

  public void oduzmiIznos(double iznos) {
    this.iznos -= iznos;
  }

  public long getBrojRacuna() {
    return brojRacuna;
  }

  public void setBrojRacuna(long brojRacuna) {
    this.brojRacuna = brojRacuna;
  }

  public double getIznos() {
    return iznos;
  }

  public void setIznos(double iznos) {
    this.iznos = iznos;
  }

  public String getValuta() {
    return valuta;
  }

  public void setValuta(String valuta) {
    this.valuta = valuta;
  }

  public ArrayList<Transakcija> getTransakcije() {
    return transakcije;
  }

  public void setTransakcije(ArrayList<Transakcija> transakcije) {
    this.transakcije = transakcije;
  }

  /**
   * Skida iznos sa racuna i dodaje novu transakciju vezanu za dati racun. Ako racun nema dovoljno
   * sredstava za placanje, baca se greska.
   *
   * @param svrhaUplate
   * @param primalac
   * @param iznosPlacanja
   * @param kategorija
   * @throws ArithmeticException
   */
  public void platiRacun(String svrhaUplate, String primalac, double iznosPlacanja, String kategorija) throws ArithmeticException {
    if (iznos >= iznosPlacanja) {
      iznos = iznos - iznosPlacanja;
      Transakcija transakcija = new Transakcija(svrhaUplate, primalac, iznosPlacanja, kategorija);
      transakcije.add(transakcija);
    } else {
      ArithmeticException greska = new ArithmeticException("Nemate dovoljno sredstava na racunu. Pokusajte drugo placanje.");
      throw greska;
    }
  }

  /**
   * Vraca poslednju transakciju.
   *
   * @return
   */
  public Transakcija poslednjaTransakcija() {
    int ukupno = transakcije.size();
    return transakcije.get(ukupno - 1);
  }

  public ArrayList<Transakcija> transakcijePoKategoriji(String kategorija) {
    ArrayList<Transakcija> rezultat = new ArrayList<>();
    for(Transakcija transakcija: transakcije) {
      if (transakcija.getKategorija().equals(kategorija)) {
        rezultat.add(transakcija);
      }
    }
    return rezultat;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("[broj: ").append(brojRacuna);
    sb.append(", iznos: ").append(iznos);
    sb.append(", valuta: ").append('\'').append(valuta).append('\'').append("]");
    return sb.toString();
  }
}
