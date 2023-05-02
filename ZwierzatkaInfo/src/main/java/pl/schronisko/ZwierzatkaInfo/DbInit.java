package pl.schronisko.ZwierzatkaInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import pl.schronisko.ZwierzatkaInfo.model.Zwierze;
import pl.schronisko.ZwierzatkaInfo.repository.ZwierzeRepository;

import java.util.List;

@Configuration
public class DbInit implements CommandLineRunner {
    private final ZwierzeRepository zwierzeRepository;
    @Autowired
    public DbInit(ZwierzeRepository zwierzeRepository) {
        this.zwierzeRepository = zwierzeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
    zwierzeRepository.saveAll(List.of(
            new Zwierze("Pucek",4, "kot",'m',"dachowiec","czarny","maly","tak","tak","tak","tak"),
            new Zwierze("Rico",5, "pies",'m',"owczarek bernenski","laciaty","duzy","tak","nie","nie","tak"),
            new Zwierze("Gucio",6, "pies",'m',"mieszaniec","czarny","maly","tak","nie","tak","tak")
    ));
    }
}
