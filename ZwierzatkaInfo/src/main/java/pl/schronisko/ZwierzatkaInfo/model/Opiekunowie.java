package pl.schronisko.ZwierzatkaInfo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@Entity
public class Opiekunowie {
    //@jakarta.persistence.Id
    @GeneratedValue //to generuje nastepne id dla kazdego autoinkrementacja
    @Id
    private Long IdOpiekuna;
    private Long IdZwierzecia;
    public int IloscPodOpieka;
    public int Doswiadczenie;
    public String Imie;//pies/kot
    public String Nazwisko;
    public char NrTel;//k/m


    public Opiekunowie(Long idOpiekuna, Long idZwierzecia, int iloscPodOpieka, int doswiadczenie, String imie, String nazwisko, char nrTel) {
        IdOpiekuna = idOpiekuna;
        IdZwierzecia = idZwierzecia;
        IloscPodOpieka = iloscPodOpieka;
        Doswiadczenie = doswiadczenie;
        Imie = imie;
        Nazwisko = nazwisko;
        NrTel = nrTel;
    }

}
