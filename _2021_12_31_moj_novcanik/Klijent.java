package _2021_12_31_moj_novcanik;

import java.util.ArrayList;

/**
 * Klijent sadrzi ime, prezime, adresu, username, password i listu racuna.
 */
public class Klijent {
  private String ime;
  private String prezime;
  private String adresa;
  private String username;
  private String password;
  private ArrayList<Racun> racuni;

  public Klijent(String ime, String prezime, String adresa, String username,
      String password) {
    this.ime = ime;
    this.prezime = prezime;
    this.adresa = adresa;
    this.username = username;
    this.password = password;
    this.racuni = new ArrayList<>();
  }

  public void dodajRacun(Racun racun) {
    this.racuni.add(racun);
  }

  public void ukloniRacun(Racun racun) {
    this.racuni.remove(racun);
  }

  public String getIme() {
    return ime;
  }

  public void setIme(String ime) {
    this.ime = ime;
  }

  public String getPrezime() {
    return prezime;
  }

  public void setPrezime(String prezime) {
    this.prezime = prezime;
  }

  public String getAdresa() {
    return adresa;
  }

  public void setAdresa(String adresa) {
    this.adresa = adresa;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public ArrayList<Racun> getRacuni() {
    return racuni;
  }

  public void setRacuni(ArrayList<Racun> racuni) {
    this.racuni = racuni;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Klijent - ime: '").append(ime).append('\'');
    sb.append(", prezime: '").append(prezime).append('\'');
    sb.append(", adresa: '").append(adresa).append('\'');
    sb.append(", username: '").append(username).append('\'');
    sb.append(", password: '").append(password).append('\'');
    sb.append('\n');
    return sb.toString();
  }
}
