package pl.schronisko.ZwierzatkaInfo.controlers.MainControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainviewController {
    @RequestMapping(method = RequestMethod.GET)
    public String mainPage() {
        return "mainview/mainview";
    }

    @RequestMapping(value = "/logowaniemain", method = RequestMethod.GET)
    public String loginPage() {
        return "mainview/logowanie";
    }

}