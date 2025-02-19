package com.vishva.admindoctoraccess.entity;

import com.vishva.admindoctoraccess.enums.Type;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name="admin_access")
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private long phoneNumber;
    private String password;

    @Enumerated(EnumType.STRING)
    private Type type;

}
