package com.example.booting.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="EMPLOYEES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StaffMember {

    @Id
    @Column(name = "EMPLOYEE_ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String employeeId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "POSITION")
    @Enumerated(EnumType.STRING)
    private Position position;

    @Override
    public String toString() {
        return "StaffMember{" +
        "employeeId=" + employeeId +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", position=" + position  +
        '}';
    }
}
