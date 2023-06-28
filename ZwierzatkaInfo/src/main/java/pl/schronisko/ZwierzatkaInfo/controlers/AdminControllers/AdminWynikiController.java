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
import java.util.stream.Collectors;

@Controller
public class AdminWynikiController {
    private final ZwierzeRepository zwierzeRepository;

    static List<Zwierze> zwierzeList = new ArrayList<>();
    @Autowired
    public AdminWynikiController(ZwierzeRepository zwierzeRepository) {
        this.zwierzeRepository = zwierzeRepository;
    }

    @GetMapping("/adminWyniki")
    public String wyniki(Model model, HttpSession httpSession, Zwierze zwierze) {
        List<Zwierze> zwierzeList = zwierzeRepository.findAll();

        List<Zwierze> pasujaceZwierzeta = zwierzeList.stream()
                .filter(z -> (zwierze.getId() == null ) || (z.getId() != null && z.getId().equals(zwierze.getId())))
                .filter(z -> (zwierze.getImie() == null || zwierze.getImie().isEmpty()) || (z.getImie() != null && z.getImie().equals(zwierze.getImie())))
                .filter(z -> (zwierze.getNrKojca() == null || zwierze.getNrKojca().isEmpty()) || (z.getNrKojca() != null && z.getNrKojca().equals(zwierze.getNrKojca())))
                .collect(Collectors.toList());

        model.addAttribute("zwierzeList", pasujaceZwierzeta);
        return "adminview/adminWyniki";
    }

}
