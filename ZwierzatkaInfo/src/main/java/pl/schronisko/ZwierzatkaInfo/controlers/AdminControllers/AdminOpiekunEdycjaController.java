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

import java.util.Optional;

@Controller
public class AdminOpiekunEdycjaController {
    private final OpiekunRepository opiekunRepository;

    public AdminOpiekunEdycjaController(OpiekunRepository opiekunRepository) {
        this.opiekunRepository = opiekunRepository;
    }

    @GetMapping("/edytujOpiekun")
    public String edycja(@RequestParam("id_opiekuna") Long id_opiekuna, Model model) {
        Optional <Opiekunowie> opiekunowieOptional = opiekunRepository.findById(id_opiekuna);
        if (opiekunowieOptional.isPresent()) {
            Opiekunowie opiekunowie = opiekunowieOptional.get();
            model.addAttribute("opiekun", opiekunowie);
        }
        return "adminview/adminOpiekunEdycja";
    }
    @PostMapping("/adminOpiekunEdycja")
    private String editZwierze(@RequestParam("id_opiekuna") Long id_opiekuna, Opiekunowie opiekunowie) {
        Optional<Opiekunowie> opiekunowieOptional = opiekunRepository.findById(id_opiekuna);
        Opiekunowie o1=null;
        if (opiekunowieOptional.isPresent())
        {
            o1 = opiekunowieOptional.get();
        }
        o1.setImie(opiekunowie.getImie());
        o1.setNazwisko(opiekunowie.getNazwisko());
        o1.setNrTel(opiekunowie.getNrTel());
        o1.setDoswiadczenie(opiekunowie.getDoswiadczenie());
        o1.setAdresUrlCzlowiek(opiekunowie.getAdresUrlCzlowiek());
        opiekunRepository.save(o1);
        return "redirect:/adminHome";
    }
}
