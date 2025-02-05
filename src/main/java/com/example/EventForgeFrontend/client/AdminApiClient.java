package com.example.EventForgeFrontend.client;

import com.example.EventForgeFrontend.dto.OrganisationResponseForAdmin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "admin-api-client" , url = "https://eventgorge-api.up.railway.app/admin")
public interface AdminApiClient {
    @GetMapping("/organisation-management/approved-accounts")
    public ResponseEntity<List<OrganisationResponseForAdmin>> getAllApprovedOrganisationsForAdmin(@RequestHeader("Authorization")String authHeader );
    @GetMapping("/organisation-management/unapproved-accounts")
    public ResponseEntity<List<OrganisationResponseForAdmin>> getAllUnapprovedOrganisationsForAdmin(@RequestHeader("Authorization")String authHeader);

    @PutMapping("/organisation-management/ban-account/{id}/{email}")
    public ResponseEntity<String> banAccountById(@RequestHeader("Authorization")String authHeader , @PathVariable("id")Long id , @PathVariable("email")String email);

    @PutMapping("/organisation-management/unban-account/{id}/{email}")
    public ResponseEntity<String> unbanAccountById(@RequestHeader("Authorization") String authHeader , @PathVariable("id")Long id ,@PathVariable("email")String email);

    @PutMapping("/organisation-management/approve-account/{id}")
    public ResponseEntity<String> approveUserAccount(@RequestHeader("Authorization")String authHeader , @PathVariable("id")Long userId);
}
