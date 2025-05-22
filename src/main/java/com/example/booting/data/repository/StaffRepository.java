package com.example.booting.data.repository;

import com.example.booting.data.entity.StaffMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<StaffMember, String> {
}
