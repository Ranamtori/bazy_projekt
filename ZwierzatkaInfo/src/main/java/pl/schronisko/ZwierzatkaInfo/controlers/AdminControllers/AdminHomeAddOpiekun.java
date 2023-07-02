package pl.schronisko.ZwierzatkaInfo.controlers.AdminControllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.schronisko.ZwierzatkaInfo.model.Opiekunowie;
import pl.schronisko.ZwierzatkaInfo.repository.OpiekunRepository;

import java.util.List;
@Controller

public class AdminHomeAddOpiekun {
    private final OpiekunRepository opiekunRepository;

    public AdminHomeAddOpiekun(OpiekunRepository opiekunRepository) {
        this.opiekunRepository = opiekunRepository;
    }

    @GetMapping("/addOpiekun")
    private String adminPage(Model model, HttpSession httpSession, Opiekunowie opiekun){
        List<Opiekunowie> opiekunList = opiekunRepository.findAll();
        model.addAttribute("opiekunList", opiekunList);
        return "adminview/addOpiekun";
    }
}
