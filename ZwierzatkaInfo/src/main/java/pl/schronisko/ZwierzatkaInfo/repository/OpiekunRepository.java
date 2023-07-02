package pl.schronisko.ZwierzatkaInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.schronisko.ZwierzatkaInfo.model.Opiekunowie;

import java.util.Optional;

@Repository
public interface OpiekunRepository extends JpaRepository<Opiekunowie,Long> {
    Opiekunowie findByImieAndNazwiskoAndNrTel(String imie, String nazwisko,String NrTel);
    @Query("SELECT o FROM Opiekunowie o JOIN o.zwierzeta z WHERE z.id = :piesekId")
    Optional<Opiekunowie> findOpiekunByPiesekId(@Param("piesekId") Long piesekId);
}
