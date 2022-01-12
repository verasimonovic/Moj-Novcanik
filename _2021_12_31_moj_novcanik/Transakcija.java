package _2021_12_31_moj_novcanik;

import java.util.Date;

public class Transakcija {

  private String svrhaUplate;
  private String primalac;
  private double iznos;
  private String kategorija; // racun, hrana, zabava, odeca
  private Date datum;

  public Transakcija(String svrhaUplate, String primalac, double iznos, String kategorija) {
    this.svrhaUplate = svrhaUplate;
    this.primalac = primalac;
    this.iznos = iznos;
    this.kategorija = kategorija;
    this.datum = new Date();
  }

  public String getSvrhaUplate() {
    return svrhaUplate;
  }

  public void setSvrhaUplate(String svrhaUplate) {
    this.svrhaUplate = svrhaUplate;
  }

  public String getPrimalac() {
    return primalac;
  }

  public void setPrimalac(String primalac) {
    this.primalac = primalac;
  }

  public double getIznos() {
    return iznos;
  }

  public void setIznos(double iznos) {
    this.iznos = iznos;
  }

  public String getKategorija() {
    return kategorija;
  }

  public void setKategorija(String kategorija) {
    this.kategorija = kategorija;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("[ svrha uplate: ").append(svrhaUplate);
    sb.append(", primalac: ").append(primalac);
    sb.append(", iznos: ").append(iznos);
    sb.append(", kategorija: '").append(kategorija).append('\'');
    sb.append(", datum: ").append(datum).append("]");
    return sb.toString();
  }
}
