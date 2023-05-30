package pl.schronisko.ZwierzatkaInfo.controlers.AdminControllers;

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
public class AdminWynikiController {
//    private final ZwierzeRepository zwierzeRepository;
//
//    static List<Zwierze> zwierzeList = new ArrayList<>();
//    @Autowired
//    public AdminWynikiController(ZwierzeRepository zwierzeRepository) {
//        this.zwierzeRepository = zwierzeRepository;
//    }
//
//    @GetMapping("/adminWyniki")//to trzeba dopiero tu nie przed lista
//    public String wyniki(Model model, HttpSession httpSession) //dodaje atrybut do modela zeby za pomaca Thymeleaf polaczyc z html
//    {
//        List<Zwierze> zwierzeList=zwierzeRepository.findAll();
//        model.addAttribute("zwierzeList",zwierzeList);
//        return "userview/Wyniki";
}
