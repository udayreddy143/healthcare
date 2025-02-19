package com.vishva.admindoctoraccess.service;

import com.vishva.admindoctoraccess.dto.AdminRequest;
import com.vishva.admindoctoraccess.dto.AdminResponse;

public interface AdminService {
    AdminResponse registerAdmin (AdminRequest adminRequest);
//    void loginAdminByPhoneNumber(Long phoneNumber);
    AdminResponse getProfileById(Long id);
}
