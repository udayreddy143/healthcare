package com.vishva.admindoctoraccess.controller;

import com.vishva.admindoctoraccess.dto.AdminRequest;
import com.vishva.admindoctoraccess.dto.AdminResponse;
import com.vishva.admindoctoraccess.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/save")
    public ResponseEntity<Object> registerAdmin(@RequestBody AdminRequest adminRequest){
        AdminResponse adminResponse=adminService.registerAdmin(adminRequest);
        System.out.println("admin registered");
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping("/getProfile/{id}")
    public AdminResponse getProfile(@PathVariable Long id){

        return adminService.getProfileById(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        AdminResponse response = adminService.loginAdminAndDoc(email, password);
        if (response != null) {
            return ResponseEntity.ok(response); // Login Successful
        }
        return ResponseEntity.badRequest().body("Login unsuccessful. Please register.");
    }

}
