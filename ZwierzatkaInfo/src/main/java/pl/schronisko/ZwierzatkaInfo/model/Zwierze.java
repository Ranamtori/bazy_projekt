package pl.schronisko.ZwierzatkaInfo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//wykorzystujac lombock ustawiam gonstruktory settery i gettery
@NoArgsConstructor
@AllArgsConstructor
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
    private String Wiek;
    private String Gatunek;//pies/kot
    private String Plec;//k/m
    private String Rasa;
    private String Umaszczenie;
    private String Wielkosc; //maly/sredni/duzy
    private String CzyDoAdopcji; //tak/nie
    private String CzyPsy; //czy moze zyc zpsami
    private String CzyKoty;
    private String CzyDzieci;
    private String Opis;
    private String AdresUrl1;
    private String AdresUrl2;
    private String AdresUrl3;

    @ManyToOne
    @JoinColumn(name = "opiekun_id")
    private Opiekunowie opiekun;

    @OneToOne(mappedBy = "zwierze")
    private Zdrowie zdrowie;


}
