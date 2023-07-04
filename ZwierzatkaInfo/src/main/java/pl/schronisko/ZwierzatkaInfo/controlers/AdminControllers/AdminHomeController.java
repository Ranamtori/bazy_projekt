package pl.schronisko.ZwierzatkaInfo.controlers.AdminControllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.schronisko.ZwierzatkaInfo.model.Opiekunowie;
import pl.schronisko.ZwierzatkaInfo.model.Zdrowie;
import pl.schronisko.ZwierzatkaInfo.model.Zwierze;
import pl.schronisko.ZwierzatkaInfo.repository.OpiekunRepository;
import pl.schronisko.ZwierzatkaInfo.repository.ZdrowieRepository;
import pl.schronisko.ZwierzatkaInfo.repository.ZwierzeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller

public class AdminHomeController {
    private final ZwierzeRepository zwierzeRepository;
    private final OpiekunRepository opiekunRepository;
    private final ZdrowieRepository zdrowieRepository;
    private Zwierze z1; //ostatnio dodane zwierze
    private List<Zwierze> zwierzeta;
    private Opiekunowie existingOpiekun;

    @Autowired
    public AdminHomeController(ZwierzeRepository zwierzeRepository, OpiekunRepository opiekunRepository, ZdrowieRepository zdrowieRepository) {
        this.zwierzeRepository = zwierzeRepository;
        this.opiekunRepository = opiekunRepository;
        this.zdrowieRepository = zdrowieRepository;
        this.zwierzeta = new ArrayList<>(); // inicjalizacja listy zwierzeta
        this.existingOpiekun = new Opiekunowie();
    }
    @GetMapping("/adminHome")
    private String adminPage(Model model) {
        List<Opiekunowie> opiekunOptional = opiekunRepository.findAll();
        model.addAttribute("opiekunList",opiekunOptional);
        return "adminview/adminHome";
    }
    //metody:
    //get-pobieranie danych z backend
    //post dodawanie nowego zasobu np z formularza
    //delete - usuwanie zasobu
    //put - aktualizacja istniejacego zasobu lub dodoanie nowego jesli nie sistnieje
    //patch (tak jak put) ale nie przesyla calego obiektu tylk odane do aktualizacji

    @PostMapping("/adminHomeZwierze")
    private String addZwierze(Zwierze zwierze) {
        //po przechwyceniu danych z formularza dodajemy do listy z home controller
        z1 = zwierze;
        zwierzeRepository.save(zwierze);
        return "redirect:/addZdrowie"; //sie wykona ta home po tym
    }

    @PostMapping("/adminHomeZdrowie")
    private String addZdrowie(Zdrowie zdrowie) {
        zdrowie.setZwierze(z1);
        zdrowie.setIdZwierzecia(z1.getId());
        z1.setZdrowie(zdrowie);
        zdrowieRepository.save(zdrowie);
        zwierzeRepository.save(z1);
        return "redirect:/addOpiekun";
    }

    @GetMapping("/adminHomeWybranyOpiekun")
    private String addWybranyOpiekun(@RequestParam("id_opiekuna") Long id, Model model) {        // Pobierz zwierze o podanym id
        Optional<Opiekunowie> opiekunowieOptional = opiekunRepository.findById(id);
        if (opiekunowieOptional.isPresent()) {
            Opiekunowie opiekunowie = opiekunowieOptional.get();
            model.addAttribute("opiekun", opiekunowie);
            opiekunowie.setIloscPodOpieka(opiekunowie.getIloscPodOpieka() + 1);
            zwierzeta = opiekunowie.getZwierzeta();
            zwierzeta.add(z1);
            opiekunowie.setZwierzeta(zwierzeta);
            z1.setOpiekun(opiekunowie);
            zwierzeRepository.save(z1);
            opiekunRepository.save(opiekunowie);
        }
        return "redirect:/adminHome"; //sie wykona ta home po tym
    }

    @PostMapping("/adminHomeOpiekun") //dodawanie nowego opiekuna
    private String addOpiekun(Opiekunowie opiekun) {
        opiekun.setIloscPodOpieka(0);
        opiekun.setZwierzeta(null);
        opiekunRepository.save(opiekun);
        return "redirect:/adminHome"; //sie wykona ta home po tym
    }

    @PostMapping("/usunOpiekun")
    public String usunOpiekun(@RequestParam("idOpiekuna") Long id, Model model) {
        if (id != null) {
            Optional<Opiekunowie> opiekunOptional = opiekunRepository.findById(id);
            if (opiekunOptional.isPresent()) {
                Opiekunowie opiekunowie2 = opiekunOptional.get();
                if (opiekunowie2.getIloscPodOpieka()== 0) { //jesli nie ma zwierzat
                    opiekunRepository.delete(opiekunowie2);
                }
            }
        }


        return "redirect:/adminHome";
    }
}
