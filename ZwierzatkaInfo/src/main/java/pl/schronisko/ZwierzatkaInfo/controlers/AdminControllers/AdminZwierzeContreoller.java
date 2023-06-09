package pl.schronisko.ZwierzatkaInfo.controlers.AdminControllers;

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

@Controller
public class AdminZwierzeContreoller {
    private final ZwierzeRepository zwierzeRepository;
    private final OpiekunRepository opiekunRepository;
    private final ZdrowieRepository zdrowieRepository;
    //private Long id;

    static List<Zwierze> zwierzeList = new ArrayList<>();
    @Autowired

    public AdminZwierzeContreoller(ZwierzeRepository zwierzeRepository, OpiekunRepository opiekunRepository, ZdrowieRepository zdrowieRepository) {
        this.zwierzeRepository = zwierzeRepository;
        this.opiekunRepository = opiekunRepository;
        this.zdrowieRepository = zdrowieRepository;
    }
    @GetMapping("/zwierzeAdmin")
    public String home(@RequestParam("id") Long id, Model model) {
        // Pobierz zwierze o podanym id
        Optional<Zwierze> zwierzeOptional = zwierzeRepository.findById(id);
        Optional<Opiekunowie> opiekunOptional = opiekunRepository.findOpiekunByPiesekId(id);
        Optional<Zdrowie> zdrowieOptional = zdrowieRepository.findZdrowieByZwierzeId(id);
        //this.id=id;
        if (zwierzeOptional.isPresent()) {
            Zwierze zwierze = zwierzeOptional.get();
            model.addAttribute("zwierze", zwierze);
        }
        if (opiekunOptional.isPresent()) {
            Opiekunowie opiekun = opiekunOptional.get();
            model.addAttribute("opiekun", opiekun);
        }
        if (zdrowieOptional.isPresent()) {
            Zdrowie zdrowie = zdrowieOptional.get();
            model.addAttribute("zdrowie", zdrowie);
        }
        return "adminview/adminZwierze";
    }
    @PostMapping("/usun")
    public String usunZwierze(@RequestParam("id") Long id, Model model) {
        if (id != null) {
            Optional<Zwierze> zwierzeOptional = zwierzeRepository.findById(id);
            if (zwierzeOptional.isPresent()) {
                Zwierze zwierze = zwierzeOptional.get();
                Opiekunowie opiekunowie = zwierze.getOpiekun();
                opiekunowie.setIloscPodOpieka(opiekunowie.getIloscPodOpieka()-1);
                opiekunRepository.save(opiekunowie);
                // Delete associated "zdrowie" record if it exists
                if (zwierze.getZdrowie() != null) {
                    zdrowieRepository.delete(zwierze.getZdrowie());
                }

                zwierzeRepository.delete(zwierze);
            }
        }

        return "redirect:/adminWyniki";
    }



}
