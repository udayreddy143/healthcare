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
        return ResponseEntity.ok(adminResponse);

    }

    @GetMapping("/getProfile/{id}")
    public ResponseEntity<?>  getProfile(@PathVariable Long id){
    AdminResponse adminResponse= adminService.getProfileById(id);
        if(adminResponse!=null){
            return ResponseEntity.ok(adminResponse);

        }
        return ResponseEntity.badRequest().body("No profile found.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        AdminResponse response = adminService.loginAdminAndDoc(email, password);
        if (response != null) {
            System.out.println("Login successful");
            return ResponseEntity.ok(response); // Login Successful
        }
        return ResponseEntity.badRequest().body("Login unsuccessful. Please register.");
    }

}
