package pl.schronisko.ZwierzatkaInfo.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.schronisko.ZwierzatkaInfo.model.Zwierze;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping
    private String adminPage(){
        return "adminview/adminHome";
    }
    @PostMapping
    //metody:
    //get-pobieranie danych z backend
    //post dodawanie nowego zasobu np z formularza
    //delete - usuwanie zasobu
    //put - aktualizacja istniejacego zasobu lub dodoanie nowego jesli nie sistnieje
    //patch (tak jak put) ale nie przesyla calego obiektu tylk odane do aktualizacji

    public String addZwierze(Zwierze zwierze)
    {
        //po przechwyceniu danych z formularza dodajemy do listy z home controller

        HomeControler.zwierzeList.add(zwierze);
        return "redirect:/"; //sie wykona ta home po tym
    }
}
