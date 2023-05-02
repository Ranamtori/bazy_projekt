package pl.schronisko.ZwierzatkaInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.schronisko.ZwierzatkaInfo.model.Zwierze;
@Repository
public interface ZwierzeRepository extends  JpaRepository<Zwierze, Long> {


}
