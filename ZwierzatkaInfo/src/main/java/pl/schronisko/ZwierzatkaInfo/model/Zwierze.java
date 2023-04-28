package pl.schronisko.ZwierzatkaInfo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//wykorzystujac lombock ustawiam gonstruktory settery i gettery
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Zwierze {
    public int Id;
    public String Imie;
    public int NrKojca;
    public char Gatunek;//p/k
    public char Plec;//k/m
    public String Rasa;
    public String Umaszczenie;
    public String Wielkosc; //maly/sredni/duzy
    public boolean CzyDoAdopcji;
    public boolean CzyPsy; //czy moze zyc zpsami
    public boolean CzyKoty;
    public boolean CzyDzieci;

}
