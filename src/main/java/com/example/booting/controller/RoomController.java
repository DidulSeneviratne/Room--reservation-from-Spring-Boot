package com.example.booting.controller;

import com.example.booting.data.entity.RoomEntity;
import com.example.booting.service.RoomService;
import com.example.booting.web.model.Room;
import org.springframework.ui.Model;
import com.example.booting.data.repository.RoomRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rooms")


public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public String getRoomsPage(Model model) {
        model.addAttribute("rooms", this.roomService.getAllRooms());
        return "rooms";
    }

}
