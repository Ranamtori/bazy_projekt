package pl.schronisko.ZwierzatkaInfo.controlers.UserControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ZwierzeController {
    @GetMapping("/zwierze")
    public String home()
    {
        return "/userview/Zwierze";
    }
}
