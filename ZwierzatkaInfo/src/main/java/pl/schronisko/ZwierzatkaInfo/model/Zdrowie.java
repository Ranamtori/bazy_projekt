package pl.schronisko.ZwierzatkaInfo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Zdrowie {
    //@jakarta.persistence.Id
    @Id
    private Long IdZwierzecia;
    private String CzySczepiony;
    private String  Choroby;
    private String Leki;
    @OneToOne
    @JoinColumn(name = "zwierze_id")
    private Zwierze zwierze;
}
