package pl.schronisko.ZwierzatkaInfo.controlers.MainControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.schronisko.ZwierzatkaInfo.repository.HasloRepository;

import java.text.AttributedString;

@Controller
@RequestMapping("/logowanie")
public class LogowanieController {

    private String haslo;
    private final HasloRepository hasloRepository;

    @Autowired
    public LogowanieController(HasloRepository hasloRepository) {
        this.hasloRepository = hasloRepository;
    }
//funkcje do wyswietlanie stron

    @RequestMapping(value = "/adminhomemain", method = RequestMethod.GET)
    public String loginPage() {
        return "adminview/adminHome";
    }

    @GetMapping("/logowanie")
    public String adminHomePage() {
        return "mainview/logowanie";
    }

    @PostMapping("/submitForm")
    public String submitForm(@RequestParam("password") String password, Model model) {
        this.haslo = password;
        if (haslo.equals("haslo")) {
            return "redirect:/adminHome";
        } else {
            model.addAttribute("error", "Błędne hasło");
            return "redirect:/logowaniemain";
        }
    }
}
