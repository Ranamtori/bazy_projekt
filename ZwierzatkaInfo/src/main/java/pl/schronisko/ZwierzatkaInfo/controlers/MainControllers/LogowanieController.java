package pl.schronisko.ZwierzatkaInfo.controlers.MainControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.schronisko.ZwierzatkaInfo.repository.HasloRepository;

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
    @RequestMapping(method = RequestMethod.GET)
    public String logowaniePage() {
        return "mainview/logowanie";
    }

    @GetMapping("/adminHome")
    public String adminHomePage() {
        return "adminview/adminHome";
    }

    @PostMapping("/submitForm")
    public String submitForm(@RequestParam("password") String password) {
        this.haslo = password;
        if (haslo.equals("haslo")) {
            return "redirect:/adminHome";
        } else {
            return "redirect:/logowanie";
        }
    }
}
