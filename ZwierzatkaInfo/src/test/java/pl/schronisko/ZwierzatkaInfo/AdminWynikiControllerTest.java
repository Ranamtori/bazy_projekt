package pl.schronisko.ZwierzatkaInfo;

import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import pl.schronisko.ZwierzatkaInfo.controlers.AdminControllers.AdminWynikiController;
import pl.schronisko.ZwierzatkaInfo.model.Zwierze;
import pl.schronisko.ZwierzatkaInfo.repository.ZwierzeRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AdminWynikiControllerTest {

    private AdminWynikiController adminWynikiController;

    @Mock
    private ZwierzeRepository zwierzeRepository;

    @Mock
    private Model model;

    @Mock
    private HttpSession httpSession;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        adminWynikiController = new AdminWynikiController(zwierzeRepository);
    }

    @Test
    void testWynikiAdmin() {
        // Arrange
        Zwierze zwierze = new Zwierze();
        List<Zwierze> zwierzeList = new ArrayList<>();
        when(zwierzeRepository.findAll()).thenReturn(zwierzeList);


        String viewName = adminWynikiController.wynikiAdmin(model, httpSession, zwierze); //do viewname przypisujemy wartos zwracana przez metode


        assertEquals("adminview/adminWyniki", viewName);//porowujemy to z oczekiwanym rezultatem
        verify(zwierzeRepository, times(1)).findAll();//spr czy findall() zostala wywolana dokladnie raz
        verify(model, times(1)).addAttribute(eq("zwierzeList"), anyList());//spr czy tylko raz zostal dodany model znacyz czy zostala wywolana funkjca addAtribute 
    }
}
