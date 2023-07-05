package pl.schronisko.ZwierzatkaInfo.controlers.AdminControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.schronisko.ZwierzatkaInfo.model.Opiekunowie;
import pl.schronisko.ZwierzatkaInfo.model.Zdrowie;
import pl.schronisko.ZwierzatkaInfo.model.Zwierze;
import pl.schronisko.ZwierzatkaInfo.repository.OpiekunRepository;
import pl.schronisko.ZwierzatkaInfo.repository.ZdrowieRepository;
import pl.schronisko.ZwierzatkaInfo.repository.ZwierzeRepository;

import java.util.Optional;

@Controller
public class AdminEdycjaController {
    private final ZdrowieRepository zdrowieRepository;
    private final ZwierzeRepository zwierzeRepository;
    private Long id;
    private final OpiekunRepository opiekunRepository;

    public AdminEdycjaController(ZdrowieRepository zdrowieRepository, ZwierzeRepository zwierzeRepository, OpiekunRepository opiekunRepository) {
        this.zdrowieRepository = zdrowieRepository;
        this.zwierzeRepository = zwierzeRepository;
        this.opiekunRepository = opiekunRepository;
    }

    @GetMapping("/zwierzeAdminEdycja")
    public String edycja(@RequestParam("id") Long id, Model model) {
        this.id=id;
        Optional<Zwierze> zwierzeOptional = zwierzeRepository.findById(id);
        Optional<Zdrowie> zdrowieOptional = zdrowieRepository.findZdrowieByZwierzeId(id);
        if (zwierzeOptional.isPresent()) {
            Zwierze zwierze = zwierzeOptional.get();
            model.addAttribute("zwierze", zwierze);
        }
        if (zdrowieOptional.isPresent()) {
            Zdrowie zdrowie = zdrowieOptional.get();
            model.addAttribute("zdrowie", zdrowie);
        }
        return "adminview/adminEdycja";
    }
    @PostMapping("/adminEdycja")
    private String editZwierze(@RequestParam("id") Long id, Zwierze zwierze,Zdrowie zdrowie,Model model) {
        Optional<Zwierze> zwierzeOptional = zwierzeRepository.findById(id);
        Zwierze z1=null;
        if (zwierzeOptional.isPresent())
        {
            z1 = zwierzeOptional.get();
        }
        z1.setGatunek(zwierze.getGatunek());
        z1.setImie(zwierze.getImie());
        z1.setCzyDoAdopcji(zwierze.getCzyDoAdopcji());
        z1.setCzyDzieci(zwierze.getCzyDzieci());
        z1.setCzyKoty(zwierze.getCzyKoty());
        z1.setPlec(zwierze.getPlec());
        z1.setCzyPsy(zwierze.getCzyPsy());
        z1.setNrKojca(zwierze.getNrKojca());
        z1.setRasa(zwierze.getRasa());
        z1.setUmaszczenie(zwierze.getUmaszczenie());
        z1.setWielkosc(zwierze.getWielkosc());
        z1.setAdresUrl1(zwierze.getAdresUrl1());
        z1.setAdresUrl2(zwierze.getAdresUrl2());
        z1.setAdresUrl3(zwierze.getAdresUrl3());
        z1.setWiek(zwierze.getWiek());
        z1.setOpis(zwierze.getOpis());
        zwierzeRepository.save(z1);
        model.addAttribute("zwierze",z1);

        Zdrowie zd1 = null;
        Optional<Zdrowie> zdrowieOptional = zdrowieRepository.findZdrowieByZwierzeId(id);
        if (zdrowieOptional.isPresent())
        {
            zd1 = zdrowieOptional.get();
        }
        zd1.setCzySczepiony(zdrowie.getCzySczepiony());
        zd1.setChoroby(zdrowie.getChoroby());
        zd1.setLeki(zdrowie.getLeki());
        zdrowieRepository.save(zd1);
        model.addAttribute("zdrowie",zd1);


        Optional<Opiekunowie> opiekunOptional = opiekunRepository.findOpiekunByPiesekId(id);
        if (opiekunOptional.isPresent()) {
            Opiekunowie opiekun = opiekunOptional.get();
            model.addAttribute("opiekun", opiekun);
        }
        return "/adminview/adminZwierze";
    }
}
