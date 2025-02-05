package com.example.EventForgeFrontend.client;

import com.example.EventForgeFrontend.dto.AuthenticationResponse;
import com.example.EventForgeFrontend.dto.JWTAuthenticationRequest;
import com.example.EventForgeFrontend.dto.RegistrationRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@FeignClient(name = "authentication-api-client" , url = "https://eventgorge-api.up.railway.app/auth")

public interface AuthenticationApiClient {


    @JsonIgnore
    Collection<String> attributeNames = new ArrayList<>();
    @GetMapping("/getAllPriorityCategories")
    public ResponseEntity<Set<String>>getAllPriorityCategories();
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> getTokenForAuthenticatedUser(@RequestBody JWTAuthenticationRequest authRequest);
    @PostMapping("/register")
    public ResponseEntity<String> register(
            @Valid @RequestBody RegistrationRequest request);
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String authorization);
}
