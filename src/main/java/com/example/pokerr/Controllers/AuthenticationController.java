package com.example.pokerr.Controllers;

import com.example.pokerr.Entities.AuthenticationRequest;
import com.example.pokerr.Entities.AuthenticationResponse;
import com.example.pokerr.Entities.RegisterRequest;
import com.example.pokerr.Services.AuthenticationService;
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