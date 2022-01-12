package _2021_12_31_moj_novcanik;

import java.util.Scanner;

public abstract class Meni {
  protected Scanner sc;

  public Meni() {
    this.sc = new Scanner(System.in);
  }

  public abstract void prikazi();
}
