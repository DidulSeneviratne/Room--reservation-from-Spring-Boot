package com.example.booting.data.repository;

import com.example.booting.User;
import com.example.booting.data.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomRepository extends JpaRepository<RoomEntity, UUID> {
    // You get methods like save(), findAll(), findById(), deleteById() etc.
}

