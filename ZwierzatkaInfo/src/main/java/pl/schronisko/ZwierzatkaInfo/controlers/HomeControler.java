package pl.schronisko.ZwierzatkaInfo.controlers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.schronisko.ZwierzatkaInfo.model.Zwierze;
import pl.schronisko.ZwierzatkaInfo.repository.ZwierzeRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeControler {

    //@ResponseBody //to jest po to zeby to co w return sie zamienilo na html a jak w return jest plik html to nie trzeba tego
//    public String home() //zwraca dokument html
//    {
//        return "index";
//    }
//    public Zwierze home() //zwraca obiekt
//    {
//        return new Zwierze(12,"Pucek",4,'k','m',"dachowiec","czarny","maly",true,false,true,true);
//    }


    private final ZwierzeRepository zwierzeRepository;
    @Autowired
    public HomeControler(ZwierzeRepository zwierzeRepository) {
        this.zwierzeRepository = zwierzeRepository;
    }
    @GetMapping("/")//to trzeba dopiero tu nie przed lista
    public String home(Model model, HttpSession httpSession) //dodaje atrybut do modela zeby za pomaca Thymeleaf polaczyc z html
    {
        List<Zwierze> zwierzeList=zwierzeRepository.findAll();
        model.addAttribute("zwierzeList",zwierzeList);
        return "index";
    }


}
