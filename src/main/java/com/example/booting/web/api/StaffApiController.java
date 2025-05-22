package com.example.booting.web.api;

import com.example.booting.service.RoomService;
import com.example.booting.service.StaffService;
import com.example.booting.web.model.Room;
import com.example.booting.web.model.Staff;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffApiController {

    private final StaffService staffService;

    public StaffApiController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public List<Staff> getAll() {
        return this.staffService.getAllStaff();
    }

    @GetMapping("/id")
    public Staff getStaff(@PathVariable(name="id") String id){
        return this.staffService.getStaffById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Staff addStaff(@RequestBody Staff staff){
        return this.staffService.addStaff(staff);
    }

    @PutMapping("/{id}")
    public Staff updateStaff(@PathVariable(name="id") String id, @RequestBody Staff staff){
        return this.staffService.updateRoom(staff);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable(name="id") String id){
        this.staffService.deleteRoom(id);
    }

}
