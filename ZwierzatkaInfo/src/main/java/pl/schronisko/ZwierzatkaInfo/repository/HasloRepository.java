package pl.schronisko.ZwierzatkaInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.schronisko.ZwierzatkaInfo.model.Haslo;

@Repository
public interface HasloRepository extends JpaRepository<Haslo, String> {
}

