package com.vishva.admindoctoraccess.service.Impl;

import com.vishva.admindoctoraccess.dao.AdminRepository;
import com.vishva.admindoctoraccess.dto.AdminRequest;
import com.vishva.admindoctoraccess.dto.AdminResponse;
import com.vishva.admindoctoraccess.entity.AdminEntity;
import com.vishva.admindoctoraccess.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Override
    public AdminResponse registerAdmin(AdminRequest adminRequest) {
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setName(adminRequest.getName());
        adminEntity.setEmail(adminRequest.getEmail());
        adminEntity.setPhoneNumber(adminRequest.getPhoneNumber());
        adminEntity.setPassword(adminRequest.getPassword());
        adminEntity.setType(adminRequest.getType());
        adminRepository.save(adminEntity);

        AdminResponse adminResponse = new AdminResponse();
        adminResponse.setName(adminEntity.getName());
        adminResponse.setEmail(adminEntity.getEmail());
        adminResponse.setPassword(adminEntity.getPassword());
        adminResponse.setPhoneNumber(adminEntity.getPhoneNumber());
        adminResponse.setType(adminEntity.getType());
        return adminResponse;

    }

//    @Override
//    public void loginAdminByPhoneNumber(Long phoneNumber) {
//
//    }
//
    @Override
    public AdminResponse getProfileById(Long id) {
        AdminResponse adminResponse = new AdminResponse();
        Optional<AdminEntity> adminEntity = adminRepository.findById(id);
        if (adminEntity.isPresent()) {
            adminResponse.setName(adminEntity.get().getName());
            adminResponse.setEmail(adminEntity.get().getEmail());
            adminResponse.setPassword(adminEntity.get().getPassword());
            adminResponse.setPhoneNumber(adminEntity.get().getPhoneNumber());
            adminResponse.setType(adminEntity.get().getType());
            return adminResponse;
        }
        else
            return null;
    }

    @Override
    public AdminResponse loginAdminAndDoc(String email, String password) {
        AdminResponse adminResponse = new AdminResponse();
        Optional<AdminEntity> adminEntity = adminRepository.findByEmailAndPassword(email, password);
        if (adminEntity.isPresent()) {
            adminResponse.setName(adminEntity.get().getName());
            adminResponse.setEmail(adminEntity.get().getEmail());
            adminResponse.setPassword(adminEntity.get().getPassword());
            adminResponse.setPhoneNumber(adminEntity.get().getPhoneNumber());
            adminResponse.setType(adminEntity.get().getType());
            return adminResponse;
        }
        return null;
    }
}
