package pl.schronisko.ZwierzatkaInfo.controlers.AdminControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminHomeAddZdrowie {
    @GetMapping("/addZdrowie")
    private String addPage(){
        return "adminview/addZdrowie";
    }
}
