package pl.schronisko.ZwierzatkaInfo.controlers.AdminControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AdminZwierzeContreoller {
    @GetMapping("/zwierzeAdmin")
    public String home()
    {
        return "/adminview/adminZwierze";
    }
}
