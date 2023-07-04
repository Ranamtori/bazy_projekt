package pl.schronisko.ZwierzatkaInfo.controlers.MainControllers;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.schronisko.ZwierzatkaInfo.model.Opiekunowie;
import pl.schronisko.ZwierzatkaInfo.repository.OpiekunRepository;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainviewController {
    private final OpiekunRepository opiekunRepository;

    public MainviewController(OpiekunRepository opiekunRepository) {
        this.opiekunRepository = opiekunRepository;
    }

    @RequestMapping(value = "/logowaniemain", method = RequestMethod.GET)
    public String loginPage() {
        return "mainview/logowanie";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String mainPage(Model model) {
        List<Opiekunowie> opiekunOptional = opiekunRepository.findAll();
        model.addAttribute("opiekunList",opiekunOptional);

        return "mainview/mainview";
    }

}