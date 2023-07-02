package pl.schronisko.ZwierzatkaInfo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Opiekunowie {
    //@jakarta.persistence.Id
    @GeneratedValue //to generuje nastepne id dla kazdego autoinkrementacja
    @Id
    private Long IdOpiekuna;
    private int iloscPodOpieka;
    private int doswiadczenie;
    private String imie;//pies/kot
    private String nazwisko;
    private String nrTel;//k/m

    @OneToMany(mappedBy = "opiekun")
    private List<Zwierze> zwierzeta;


}
