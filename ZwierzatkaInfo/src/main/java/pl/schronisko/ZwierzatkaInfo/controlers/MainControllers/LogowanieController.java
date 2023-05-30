package pl.schronisko.ZwierzatkaInfo.controlers.MainControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.schronisko.ZwierzatkaInfo.repository.HasloRepository;
import pl.schronisko.ZwierzatkaInfo.repository.ZwierzeRepository;

@Controller
@RequestMapping("/logowanie")
public class LogowanieController {

    private String haslo;
    private final HasloRepository hasloRepository;
    @Autowired
    private LogowanieController(HasloRepository hasloRepository) {
        this.hasloRepository = hasloRepository;
    }

    @GetMapping
    private String logowaniePage(){

        return "mainview/logowanie";
    }
    @PostMapping("/logowanie/mainview/form")
    public String showForm(Model model) {
        // Logika przetwarzania formularza
        return "mainview/logowanie"; // Nazwa szablonu Thymeleaf
    }
    @PostMapping("/submitForm")
    public String submitForm(@RequestParam("password") String password, Model model) {
        this.haslo = password;
        model.addAttribute("haslo", this.haslo);
        return "adminview/adminHome"; // Nazwa szablonu Thymeleaf dla wyniku
    }

}

