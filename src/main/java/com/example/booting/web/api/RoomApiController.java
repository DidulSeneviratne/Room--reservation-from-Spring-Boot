package com.example.booting.web.api;

import com.example.booting.service.RoomService;
import com.example.booting.web.model.Room;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/rooms")
public class RoomApiController {

    private final RoomService roomService;

    public RoomApiController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getAll() {
        return this.roomService.getAllRooms();
    }

    @GetMapping("/id")
    public Room getRoom(@PathVariable(name="id") UUID id){
        return this.roomService.getRoomById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room addRoom(@RequestBody Room room){
        return this.roomService.addRoom(room);
    }

    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable(name="id") int id, @RequestBody Room room){
        return this.roomService.updateRoom(room);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable(name="id") UUID id){
        this.roomService.deleteRoom(id);
    }

}
