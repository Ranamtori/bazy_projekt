package pl.schronisko.ZwierzatkaInfo.controlers.MainControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainviewController {
    @RequestMapping(method = RequestMethod.GET)
    public String logowaniePage() {
        return "mainview/mainview";
    }
}
