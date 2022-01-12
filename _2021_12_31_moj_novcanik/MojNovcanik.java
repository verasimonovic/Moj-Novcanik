package _2021_12_31_moj_novcanik;

import java.util.ArrayList;
import java.util.Scanner;

public class MojNovcanik {

  public static void main(String[] args) {
    Banka banka = new Banka("ITB");
    Klijent klijent1 = new Klijent("Vera", "Simonovic", "M. Venac 11", "vera", "miki");
    Racun racun1 = new Racun(20000, "RSD");
    klijent1.dodajRacun(racun1);
    banka.dodajKlijenta(klijent1);

    Scanner sc = new Scanner(System.in);

    Klijent klijent;

    glavni:
    while (true) {
      System.out.println("\n=========================");
      System.out.println("ITBOOTCAMP MOJ NOVCANIK");
      System.out.println("=========================");
      System.out.println("1. Registruj se");
      System.out.println("2. Uloguje se");
      System.out.println("3. Izadji");
      System.out.println("-------------------------");
      System.out.print("Unesite svoj izbor: ");

      int input = sc.nextInt();
      if (input == 1) {// show application signup form
        System.out.println("\n-------------------------");
        System.out.println("[ITB BANK] SIGN UP");
        System.out.println("-------------------------");
        System.out.print("Unesite ime: ");
        String ime = sc.next();
        System.out.print("Unesite prezime: ");
        String prezime = sc.next();
        System.out.print("Unesite adresu: ");
        sc.nextLine();
        String adresa = sc.nextLine();
        System.out.print("Unesite username: ");
        String username = sc.next();
        System.out.print("Unesite sifru: ");
        String password = sc.next();

        System.out.println("-------------------------\n");

        // save client
        klijent = new Klijent(ime, prezime, adresa, username, password);
        banka.dodajKlijenta(klijent);

        System.out.println("\n> Dodat je novi klijent");
        System.out.println(klijent);
      } else if (input == 2) {
        String username;
        String password;// show application login form
        System.out.println("\n-------------------------");
        System.out.println("[ITB BANK] LOGIN");
        System.out.println("-------------------------");
        int preostaliBrojPokusaja = 3;

        login:
        while (true) {
          System.out.print("Unesite username: ");
          username = sc.next();
          System.out.print("Unesite password: ");
          password = sc.next();

          klijent = banka.pronadjiKlijenta(username);
          if (klijent != null && klijent.getPassword().equals(password)) {
            dobrodosli:
            while (true) {
              System.out.println("\n-------------------------");
              System.out.println(
                  "[ITB BANK] DOBRODOSLI " + klijent.getIme() + " " + klijent.getPrezime());
              System.out.println("-------------------------");
              System.out.println("1. Racuni");
              System.out.println("2. Nazad");
              System.out.println("-------------------------");
              System.out.print("Unesite svoj izbor: ");
              input = sc.nextInt();

              if (input == 1) {
                racuni:
                while (true) {
                  System.out.println("\n-------------------------");
                  System.out.println("[ITB BANK] RACUNI");
                  System.out.println("-------------------------");
                  System.out.println("1. Dodaj Racun");
                  System.out.println("2. Nazad");
                  System.out.println("-------------------------");
                  ArrayList<Racun> racuni = klijent.getRacuni();
                  int i = 3;
                  int ukupnoRacuna = racuni.size();
                  if (ukupnoRacuna == 0) {
                    System.out.println("Trenutno nemate otvorenih racuna");
                  } else {
                    for (Racun racun : racuni) {
                      System.out.println(i + ". Izaberi Racun:  " + racun);
                      i++;
                    }
                  }
                  System.out.println("-------------------------");
                  System.out.print("Unesite svoj izbor: ");
                  input = sc.nextInt();

                  if (input == 1) {
                    System.out.println("\n-------------------------");
                    System.out.println("[ITB BANK] DODAJ RACUN");
                    System.out.println("-------------------------");
                    System.out.print("Unesite iznos na racunu: ");
                    double iznos = sc.nextDouble();
                    System.out.print("Unesite valutu [RSD, EUR]: ");
                    String valuta = sc.next();

                    Racun racun = new Racun(iznos, valuta);
                    klijent.dodajRacun(racun);

                    System.out.println("\n> Racun " + racun + " je dodat!");
                  } else if (input == 2) {
                    // Nazad
                    break;
                  } else if (input >= 3 && input < (3 + ukupnoRacuna)) {
                    Racun odabraniRacun = klijent.getRacuni().get(input - 3);

                    racun:
                    while (true) {
                      System.out.println("\n-------------------------");
                      System.out.println(
                          "[ITB BANK] RACUN " + odabraniRacun.getBrojRacuna() + ", "
                              + odabraniRacun.getIznos() + ", " + odabraniRacun.getValuta());
                      System.out.println("-------------------------");
                      System.out.println("1. Ukloni Racun");
                      System.out.println("2. Placanja");
                      System.out.println("3. Izlistaj Transakcije");
                      System.out.println("4. Nazad");
                      System.out.println("-------------------------");
                      System.out.print("Unesite svoj izbor: ");
                      input = sc.nextInt();

                      if (input == 1) {
                        klijent.ukloniRacun(odabraniRacun);

                        System.out.println(
                            "\n> Uspesno ste uklonili Racun br. " + odabraniRacun.getBrojRacuna());
                        // vrati se na prethodnu stranu nakon uklanjanja
                        break;
                      } else if (input == 2) {
                        placanja:
                        while (true) {
                          System.out.println("\n-------------------------");
                          System.out.println(
                              "[ITB BANK] PLACANJA PREKO RACUNA BR. "
                                  + odabraniRacun.getBrojRacuna() + ", "
                                  + odabraniRacun.getIznos() + ", " + odabraniRacun.getValuta());
                          System.out.println("-------------------------");
                          System.out.println("1. Kupi odecu");
                          System.out.println("2. Plati gorivo");
                          System.out.println("3. Plati infostan");
                          System.out.println("4. Plati struju");
                          System.out.println("5. Plati bioskop");
                          System.out.println("6. Plati turu");
                          System.out.println("7. Plati racun");
                          System.out.println("8. Nazad");
                          System.out.println("-------------------------");
                          System.out.print("Unesite svoj izbor: ");
                          input = sc.nextInt();

                          if (input == 8) {
                            // nazad
                            break;
                          }

                          System.out.print("Unesite primaoca: ");
                          sc.nextLine();
                          String primalac = sc.nextLine();
                          System.out.print("Unesite iznos: ");
                          double iznos = sc.nextDouble();

                          try {
                            if (input == 1) {
                              System.out.print("Unesite svrhu uplate: ");
                              sc.nextLine();
                              String svrhaUplate = sc.nextLine();
                              odabraniRacun.platiRacun(svrhaUplate, primalac, iznos,
                                  "racun");
                            } else if (input == 2) {
                              odabraniRacun.platiRacun("Gorivo", primalac, iznos,
                                  "racun");
                            } else if (input == 3) {
                              odabraniRacun.platiRacun("Infostan", primalac, iznos,
                                  "racun");
                            } else if (input == 4) {
                              odabraniRacun.platiRacun("Struja", primalac, iznos,
                                  "racun");
                            } else if (input == 5) {
                              System.out.print("Unesite svrhu uplate: ");
                              sc.nextLine();
                              String svrhaUplate = sc.nextLine();
                              odabraniRacun.platiRacun("Zabava", primalac, iznos,
                                  "zabava");
                            } else if (input == 6) {
                              odabraniRacun.platiRacun("Tura pica", primalac, iznos,
                                  "zabava");
                            } else if (input == 7) {
                              System.out.print("Unesite svrhu uplate: ");
                              sc.nextLine();
                              String svrhaUplate = sc.nextLine();
                              odabraniRacun.platiRacun(svrhaUplate, primalac, iznos,
                                  "racun");
                            } else {
                              System.out.println(
                                  "\n> Uneli ste nevazecu opciju. Pokusajte ponovo.");
                            }

                            System.out.println("\n> Uspesno ste obavili transakciju: "
                                + odabraniRacun.poslednjaTransakcija());
                          } catch (ArithmeticException greska) {
                            System.out.println(greska.getMessage());
                          }
                        }
                      } else if (input == 3) {
                        while (true) {
                          System.out.println("\n-------------------------");
                          System.out.println(
                              "[ITB BANK] TRANSAKCIJE RACUNA " + odabraniRacun.getBrojRacuna()
                                  + ", "
                                  + odabraniRacun.getIznos() + ", " + odabraniRacun.getValuta());
                          System.out.println("-------------------------");
                          System.out.println("1. Izlistaj");
                          System.out.println("2. Izlistaj Po Kategoriji");
                          System.out.println("3. Nazad");
                          System.out.println("-------------------------");
                          System.out.print("Unesite svoj izbor: ");
                          input = sc.nextInt();

                          if (input == 1) {
                            ArrayList<Transakcija> transakcije = odabraniRacun.getTransakcije();
                            i = 1;
                            int ukupnoTransakcija = transakcije.size();
                            if (ukupnoTransakcija == 0) {
                              System.out.println("Trenutno nemate transakcija vezanih za ovaj racun");
                            } else {
                              for (Transakcija transakcija : transakcije) {
                                System.out.println(i + ") " + transakcija);
                                i++;
                              }
                            }
                          } else if (input == 2) {
                            System.out.print("Unesite kategoriju[hrana, zabava, racun]: ");
                            String kategorija = sc.next();
                            ArrayList<Transakcija> transakcijePoKategoriji = odabraniRacun.transakcijePoKategoriji(
                                kategorija);

                            i = 1;
                            int ukupnoTransakcija = transakcijePoKategoriji.size();
                            if (ukupnoTransakcija == 0) {
                              System.out.println("Trenutno nemate transakcija po kategoriji vezanih za ovaj racun");
                            } else {
                              for (Transakcija transakcija : transakcijePoKategoriji) {
                                System.out.println(i + ") " + transakcija);
                                i++;
                              }
                            }
                          } else if (input == 3) {
                            break;
                          }
                        }
                      } else if (input == 4) {
                        break;
                      }
                    }
                  }
                }
              } else if (input == 2) {
                break login;
              } else {
                System.out.println("\n> Uneli ste nevazecu opciju. Pokusajte ponovo.");
              }
            }
          } else if (preostaliBrojPokusaja > 1) {
            preostaliBrojPokusaja--;
            System.out.println("\n> Uneli ste pogresan username ili password! Pokusajte ponovo.");
            System.out.println(
                "> Preostali broj pokusaja je " + preostaliBrojPokusaja);
          } else {
            System.out.println(
                "\n> Vise od 3 puta zaredom ste uneli pogresan username ili password");
            break;
          }
        }
      } else if (input == 3) {
        System.out.println("\n##################################################");
        System.out.println("Hvala sto koristite usluge nase banke. Dovidjenja.");
        System.out.println("##################################################");
        break;
      } else {
        System.out.println("\n> Uneli ste nevazecu opciju. Pokusajte ponovo.");
      }
    }
  }
}
