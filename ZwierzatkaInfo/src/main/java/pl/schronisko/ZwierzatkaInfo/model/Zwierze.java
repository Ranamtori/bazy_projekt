package pl.schronisko.ZwierzatkaInfo.model;

import jakarta.persistence.*;
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
    private String Imie;
    private String NrKojca;
    private String Gatunek;//pies/kot
    private String Plec;//k/m
    private String Rasa;
    private String Umaszczenie;
    private String Wielkosc; //maly/sredni/duzy
    private String CzyDoAdopcji; //tak/nie
    private String CzyPsy; //czy moze zyc zpsami
    private String CzyKoty;
    private String CzyDzieci;

    @ManyToOne
    @JoinColumn(name = "opiekun_id")
    private Opiekunowie opiekun;

    @OneToOne(mappedBy = "zwierze")
    private Zdrowie zdrowie;

    //konstruktor bez id
    public Zwierze(String imie,String nrKojca, String gatunek, String plec, String rasa, String umaszczenie, String wielkosc, String czyDoAdopcji, String czyPsy, String czyKoty, String czyDzieci) {
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
