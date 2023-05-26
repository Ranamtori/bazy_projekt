package pl.schronisko.ZwierzatkaInfo.controlers.AdminControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.schronisko.ZwierzatkaInfo.model.Zwierze;
import pl.schronisko.ZwierzatkaInfo.repository.ZwierzeRepository;

@Controller
@RequestMapping("/logowanie")
public class LogowanieController {

    @GetMapping
    private String adminPage(){

        return "mainview/logowanie";
    }
}

//    @PostMapping("/mainview/form")
//    public String showForm(Model model) {
//        // Logika przetwarzania formularza
//        return "mainview/logowanie"; // Nazwa szablonu Thymeleaf
//    }
//
//    @PostMapping("/submitForm")
//    public String submitForm(@RequestParam("password") String password) {
//        this.haslo = password;
//        // Przetwarzaj wartość hasła według potrzeb
//        return "mainview/logowanie"; // Nazwa szablonu Thymeleaf dla wyniku
//    }