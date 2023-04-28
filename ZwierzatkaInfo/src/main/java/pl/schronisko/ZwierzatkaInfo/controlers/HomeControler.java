package pl.schronisko.ZwierzatkaInfo.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.schronisko.ZwierzatkaInfo.model.Zwierze;

@Controller
public class HomeControler {
    @GetMapping("/")
    //@ResponseBody //to jest po to zeby to co w return sie zamienilo na html a jak w return jest plik html to nie trzeba tego
//    public String home() //zwraca dokument html
//    {
//        return "index";
//    }
//    public Zwierze home() //zwraca obiekt
//    {
//        return new Zwierze(12,"Pucek",4,'k','m',"dachowiec","czarny","maly",true,false,true,true);
//    }
    public String home(Model model) //dodaje atrybut do modela zeby za pomaca Thymeleaf polaczyc z html
    {
        model.addAttribute("zwierze",new Zwierze(12,"Pucek",4,'k','m',"dachowiec","czarny","maly",true,false,true,true));
        return "index";
    }
}
