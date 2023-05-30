package pl.schronisko.ZwierzatkaInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import pl.schronisko.ZwierzatkaInfo.model.Zwierze;
import pl.schronisko.ZwierzatkaInfo.repository.HasloRepository;
import pl.schronisko.ZwierzatkaInfo.repository.ZwierzeRepository;

import java.util.List;

@Configuration
public class DbInit implements CommandLineRunner {
    private final ZwierzeRepository zwierzeRepository;
    private final HasloRepository hasloRepository;


    @Autowired
    public DbInit(HasloRepository hasloRepository,ZwierzeRepository zwierzeRepository) {
        this.hasloRepository = hasloRepository;
        this.zwierzeRepository = zwierzeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//    zwierzeRepository.saveAll(List.of(
//
//    ));
    }
}
