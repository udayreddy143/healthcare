package com.vishva.admindoctoraccess.dto;

import com.vishva.admindoctoraccess.enums.Type;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AdminRequest {

    private String name;
    private String email;
    private long phoneNumber;
    private String password;
    private Type type;
}
