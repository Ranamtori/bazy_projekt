package pl.schronisko.ZwierzatkaInfo.controlers.AdminControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.schronisko.ZwierzatkaInfo.model.Zwierze;
import pl.schronisko.ZwierzatkaInfo.repository.ZwierzeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminZwierzeContreoller {
    private final ZwierzeRepository zwierzeRepository;

    static List<Zwierze> zwierzeList = new ArrayList<>();
    @Autowired

    public AdminZwierzeContreoller(ZwierzeRepository zwierzeRepository) {
        this.zwierzeRepository = zwierzeRepository;
    }

    @GetMapping("/zwierzeAdmin")
    public String home(@RequestParam("id") Long id, Model model) {
        // Pobierz zwierze o podanym id
        Optional<Zwierze> zwierzeOptional = zwierzeRepository.findById(id);
        if (zwierzeOptional.isPresent()) {
            Zwierze zwierze = zwierzeOptional.get();
            model.addAttribute("zwierze", zwierze);
        }
        return "adminview/adminZwierze";
    }
}
