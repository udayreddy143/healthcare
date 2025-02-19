package com.vishva.admindoctoraccess.dto;

import com.vishva.admindoctoraccess.enums.Type;
import lombok.Data;

@Data
public class AdminResponse {
    private Long id;
    private String name;
    private String email;
    private long phoneNumber;
    private String password;
    private Type type;
}
