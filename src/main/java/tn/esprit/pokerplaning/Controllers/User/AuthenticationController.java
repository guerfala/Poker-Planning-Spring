package tn.esprit.pokerplaning.Controllers.User;

import tn.esprit.pokerplaning.Entities.User.AuthenticationRequest;
import tn.esprit.pokerplaning.Entities.User.AuthenticationResponse;
import tn.esprit.pokerplaning.Entities.User.RegisterRequest;
import tn.esprit.pokerplaning.Services.User.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class AuthenticationController {

    private  final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register (
            @RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(service.register(request));
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate (
            @RequestBody AuthenticationRequest request)
    {
        return ResponseEntity.ok(service.authenticate(request));
    }

}