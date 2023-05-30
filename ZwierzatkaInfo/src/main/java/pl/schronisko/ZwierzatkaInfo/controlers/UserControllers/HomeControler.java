package pl.schronisko.ZwierzatkaInfo.controlers.UserControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.schronisko.ZwierzatkaInfo.repository.ZwierzeRepository;

@Controller
public class HomeControler {
    private final ZwierzeRepository zwierzeRepository;
    @Autowired
    public HomeControler(ZwierzeRepository zwierzeRepository) {
        this.zwierzeRepository = zwierzeRepository;
    }


    @GetMapping("/home")//to trzeba dopiero tu nie przed lista
    public String home() //dodaje atrybut do modela zeby za pomaca Thymeleaf polaczyc z html
    {
        return "/userview/Home";
    }
}
