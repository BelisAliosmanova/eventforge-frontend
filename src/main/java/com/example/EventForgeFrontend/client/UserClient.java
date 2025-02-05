package com.example.EventForgeFrontend.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-client" , url ="https://eventgorge-api.up.railway.app/user")
public interface UserClient {
    @PostMapping("/enableOrganisationByAdmin")
    public ResponseEntity<String> enableOrganisationByAdmin(@RequestParam("userId") Long userId);
}
