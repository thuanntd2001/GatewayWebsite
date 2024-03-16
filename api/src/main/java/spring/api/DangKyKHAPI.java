package spring.api;

import lombok.AllArgsConstructor;
import spring.dto.KhachHangDTO;
import spring.service.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class DangKyKHAPI {

	@Autowired
    private RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody KhachHangDTO request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
