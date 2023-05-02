package pl.schronisko.ZwierzatkaInfo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//wykorzystujac lombock ustawiam gonstruktory settery i gettery
@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@Entity //dodajemy do klas ktore chcemy odwzorowac na tabele
public class Zwierze {
    //@jakarta.persistence.Id
    @GeneratedValue //to generuje nastepne id dla kazdego autoinkrementacja
    @Id
    private Long id;
    public String Imie;
    public int NrKojca;
    public String Gatunek;//pies/kot
    public char Plec;//k/m
    public String Rasa;
    public String Umaszczenie;
    public String Wielkosc; //maly/sredni/duzy
    public String CzyDoAdopcji; //tak/nie
    public String CzyPsy; //czy moze zyc zpsami
    public String CzyKoty;
    public String CzyDzieci;



    //konstruktor bez id
    public Zwierze(String imie, int nrKojca, String gatunek, char plec, String rasa, String umaszczenie, String wielkosc, String czyDoAdopcji, String czyPsy, String czyKoty, String czyDzieci) {
        Imie = imie;
        NrKojca = nrKojca;
        Gatunek = gatunek;
        Plec = plec;
        Rasa = rasa;
        Umaszczenie = umaszczenie;
        Wielkosc = wielkosc;
        CzyDoAdopcji = czyDoAdopcji;
        CzyPsy = czyPsy;
        CzyKoty = czyKoty;
        CzyDzieci = czyDzieci;
    }

}
