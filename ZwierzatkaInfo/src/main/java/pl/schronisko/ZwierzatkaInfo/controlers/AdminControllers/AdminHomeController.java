package pl.schronisko.ZwierzatkaInfo.controlers.AdminControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.schronisko.ZwierzatkaInfo.model.Zwierze;
import pl.schronisko.ZwierzatkaInfo.repository.ZwierzeRepository;

@Controller
@RequestMapping("/adminHome")
public class AdminHomeController {
    private final ZwierzeRepository zwierzeRepository;
    @Autowired
    public AdminHomeController(ZwierzeRepository zwierzeRepository) {
        this.zwierzeRepository = zwierzeRepository;
    }
    @GetMapping
    private String adminPage(){

        return "adminview/adminHome";
    }
    //metody:
    //get-pobieranie danych z backend
    //post dodawanie nowego zasobu np z formularza
    //delete - usuwanie zasobu
    //put - aktualizacja istniejacego zasobu lub dodoanie nowego jesli nie sistnieje
    //patch (tak jak put) ale nie przesyla calego obiektu tylk odane do aktualizacji
    @PostMapping
    private String addZwierze(Zwierze zwierze)
    {
        //po przechwyceniu danych z formularza dodajemy do listy z home controller
        zwierzeRepository.save(zwierze);
        return "redirect:/"; //sie wykona ta home po tym
    }
}
