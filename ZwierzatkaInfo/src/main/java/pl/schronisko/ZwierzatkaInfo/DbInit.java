package pl.schronisko.ZwierzatkaInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import pl.schronisko.ZwierzatkaInfo.repository.HasloRepository;
import pl.schronisko.ZwierzatkaInfo.repository.OpiekunRepository;
import pl.schronisko.ZwierzatkaInfo.repository.ZwierzeRepository;

@Configuration
public class DbInit implements CommandLineRunner {
    private final ZwierzeRepository zwierzeRepository;
    private final HasloRepository hasloRepository;
    private final OpiekunRepository opiekunRepository;


    @Autowired
    public DbInit(HasloRepository hasloRepository, ZwierzeRepository zwierzeRepository, OpiekunRepository opiekunRepository) {
        this.hasloRepository = hasloRepository;
        this.zwierzeRepository = zwierzeRepository;
        this.opiekunRepository = opiekunRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//    zwierzeRepository.saveAll(List.of(
//
//    ));
    }
}
