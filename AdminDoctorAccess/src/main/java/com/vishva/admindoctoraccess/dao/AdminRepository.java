package com.vishva.admindoctoraccess.dao;

import com.vishva.admindoctoraccess.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity,Long> {
    Optional<AdminEntity> findByEmailAndPassword(String email, String password);
}
