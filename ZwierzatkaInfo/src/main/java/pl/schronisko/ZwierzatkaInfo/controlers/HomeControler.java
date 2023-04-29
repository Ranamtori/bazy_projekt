package pl.schronisko.ZwierzatkaInfo.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.schronisko.ZwierzatkaInfo.model.Zwierze;

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
    static List<Zwierze> zwierzeList = new ArrayList<>();
    static
    {
        zwierzeList.add(new Zwierze(12,"Pucek",4,'k','m',"dachowiec","czarny","maly",true,false,true,true));
        zwierzeList.add(new Zwierze(12,"Rico",5,'p','m',"owczarek bernenski","laciaty","duzy",true,false,false,true));
        zwierzeList.add(new Zwierze(12,"Gucio",6,'p','m',"mieszaniec","czarny","maly",true,false,true,true));
    }


    @GetMapping("/")//to trzeba dopiero tu nie przed lista
    public String home(Model model) //dodaje atrybut do modela zeby za pomaca Thymeleaf polaczyc z html
    {
        model.addAttribute("zwierzeList",zwierzeList);
        return "index";
    }

    public List<Zwierze> getZwierzeList() {
        return zwierzeList;
    }
}
