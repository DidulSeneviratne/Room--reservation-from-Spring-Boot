package com.example.booting.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name="ROOMS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="ROOM_ID")
    private UUID roomId;
    @Column(name="NAME")
    private String name;
    @Column(name="NUMBER")
    private String number;
    @Column(name="BED_INFO")
    private String bedInfo;

    @Override
    public String toString() {
        return "RoomEntity{" +
                "roomId=" + roomId +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", bedInfo='" + bedInfo + '\'' +
                '}';
    }
}
