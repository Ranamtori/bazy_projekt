package pl.schronisko.ZwierzatkaInfo.controlers.UserControllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.schronisko.ZwierzatkaInfo.model.Zwierze;
import pl.schronisko.ZwierzatkaInfo.repository.ZwierzeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WynikiControler {
    private final ZwierzeRepository zwierzeRepository;

    static List<Zwierze> zwierzeList = new ArrayList<>();
    @Autowired
    public WynikiControler(ZwierzeRepository zwierzeRepository) {
        this.zwierzeRepository = zwierzeRepository;
    }

    @GetMapping("/Wyniki")
    public String wyniki(Model model, HttpSession httpSession, Zwierze zwierze) {
        List<Zwierze> zwierzeList = zwierzeRepository.findAll();

        List<Zwierze> pasujaceZwierzeta = zwierzeList.stream()
                .filter(z -> (zwierze.getImie() == null || zwierze.getImie().isEmpty()) || (z.getImie() != null && z.getImie().equals(zwierze.getImie())))
                .filter(z -> (zwierze.getGatunek() == null || zwierze.getGatunek().isEmpty()) || (z.getGatunek() != null && z.getGatunek().equals(zwierze.getGatunek())))
                .filter(z -> (zwierze.getPlec() == null || zwierze.getPlec().isEmpty()) || (z.getPlec() != null && z.getPlec().equals(zwierze.getPlec())))
                .filter(z -> (zwierze.getRasa() == null || zwierze.getRasa().isEmpty()) || (z.getRasa() != null && z.getRasa().equals(zwierze.getRasa())))
                .filter(z -> (zwierze.getUmaszczenie() == null || zwierze.getUmaszczenie().isEmpty()) || (z.getUmaszczenie() != null && z.getUmaszczenie().equals(zwierze.getUmaszczenie())))
                .filter(z -> (zwierze.getWielkosc() == null || zwierze.getWielkosc().isEmpty()) || (z.getWielkosc() != null && z.getWielkosc().equals(zwierze.getWielkosc())))
                .filter(z -> (zwierze.getCzyDoAdopcji() == null || zwierze.getCzyDoAdopcji().isEmpty()) || (z.getCzyDoAdopcji() != null && z.getCzyDoAdopcji().equals(zwierze.getCzyDoAdopcji())))
                .filter(z -> (zwierze.getCzyPsy() == null || zwierze.getCzyPsy().isEmpty()) || (z.getCzyPsy() != null && z.getCzyPsy().equals(zwierze.getCzyPsy())))
                .filter(z -> (zwierze.getCzyKoty() == null || zwierze.getCzyKoty().isEmpty()) || (z.getCzyKoty() != null && z.getCzyKoty().equals(zwierze.getCzyKoty())))
                .filter(z -> (zwierze.getCzyDzieci() == null || zwierze.getCzyDzieci().isEmpty()) || (z.getCzyDzieci() != null && z.getCzyDzieci().equals(zwierze.getCzyDzieci())))
                .collect(Collectors.toList());


        model.addAttribute("zwierzeList", pasujaceZwierzeta);
        return "userview/Wyniki";
    }




}
