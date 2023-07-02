package pl.schronisko.ZwierzatkaInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.schronisko.ZwierzatkaInfo.model.Opiekunowie;
import pl.schronisko.ZwierzatkaInfo.model.Zdrowie;

import java.util.Optional;

@Repository
public interface ZdrowieRepository extends JpaRepository<Zdrowie,Long> {
    @Query("SELECT z FROM Zdrowie z JOIN z.zwierze zw WHERE zw.id = :zwierzeId")
    Optional<Zdrowie> findZdrowieByZwierzeId(@Param("zwierzeId") Long zwierzeId);

}
