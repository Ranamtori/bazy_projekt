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
public class Zdrowie {
    //@jakarta.persistence.Id
    @GeneratedValue //to generuje nastepne id dla kazdego autoinkrementacja
    @Id
    private Long IdZwierzecia;
    public char CzySczepiony;
    public char Choroby;
    public char Leki;


    public Zdrowie(Long idZwierzecia, char czySczepiony, char choroby, char leki) {
        IdZwierzecia = idZwierzecia;
        CzySczepiony = czySczepiony;
        Choroby = choroby;
        Leki = leki;
    }

}
