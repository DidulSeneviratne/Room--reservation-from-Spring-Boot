package com.example.booting.controller;

import com.example.booting.data.entity.RoomEntity;
import com.example.booting.data.entity.StaffMember;
import com.example.booting.data.repository.StaffRepository;
import com.example.booting.service.StaffService;
import com.example.booting.web.model.Room;
import com.example.booting.web.model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public String staff(Model model) {
        model.addAttribute("staff", this.staffService.getAllStaff());
        return "staff";
    }

}
