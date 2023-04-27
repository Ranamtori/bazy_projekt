package pl.schronisko.ZwierzatkaInfo.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeControler {
    @GetMapping("/")
    //@ResponseBody //to jest po to zeby to co w return sie zamienilo na html a jak w return jest plik html to nie trzeba tego
    public String home()
    {
        return "index";
    }

}
