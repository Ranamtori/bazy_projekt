package pl.schronisko.ZwierzatkaInfo.controlers.UserControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.schronisko.ZwierzatkaInfo.model.Opiekunowie;
import pl.schronisko.ZwierzatkaInfo.model.Zwierze;
import pl.schronisko.ZwierzatkaInfo.repository.OpiekunRepository;
import pl.schronisko.ZwierzatkaInfo.repository.ZwierzeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller

public class ZwierzeController {
    private final ZwierzeRepository zwierzeRepository;
    private final OpiekunRepository opiekunRepository;

    static List<Zwierze> zwierzeList = new ArrayList<>();
    @Autowired
    public ZwierzeController(ZwierzeRepository zwierzeRepository, OpiekunRepository opiekunRepository) {
        this.zwierzeRepository = zwierzeRepository;
        this.opiekunRepository = opiekunRepository;
    }



    @GetMapping("/zwierze")
    public String home(@RequestParam("id") Long id, Model model) {
        // Pobierz zwierze o podanym id
        Optional<Zwierze> zwierzeOptional = zwierzeRepository.findById(id);
        Optional<Opiekunowie> opiekunOptional = opiekunRepository.findOpiekunByPiesekId(id);
        if (zwierzeOptional.isPresent()) {
            Zwierze zwierze = zwierzeOptional.get();
            model.addAttribute("zwierze", zwierze);
        }
        if (opiekunOptional.isPresent()) {
            Opiekunowie opiekun = opiekunOptional.get();
            model.addAttribute("opiekun", opiekun);
        }
        return "userview/Zwierze";
    }
}
