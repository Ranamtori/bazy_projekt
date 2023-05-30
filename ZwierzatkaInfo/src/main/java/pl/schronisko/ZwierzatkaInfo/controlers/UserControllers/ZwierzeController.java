package pl.schronisko.ZwierzatkaInfo.controlers.UserControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ZwierzeController {
    @GetMapping("/zwierze")
    public String home()
    {
        return "/userview/Zwierze";
    }
}
