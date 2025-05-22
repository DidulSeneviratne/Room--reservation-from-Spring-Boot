package com.example.booting.service;

import com.example.booting.data.entity.Position;
import com.example.booting.data.entity.RoomEntity;
import com.example.booting.data.entity.StaffMember;
import com.example.booting.data.repository.RoomRepository;
import com.example.booting.data.repository.StaffRepository;
import com.example.booting.web.model.Room;
import com.example.booting.web.model.Staff;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> getAllStaff() {
        List<StaffMember> entities = this.staffRepository.findAll();
        List<Staff> staff = new ArrayList<>(entities.size());
        entities.forEach(s -> staff.add(this.getStaffFromEntity(s)));
        return staff;
    }

    public Staff getStaffById(String id) {
        Optional<StaffMember> entity = this.staffRepository.findById(id);
        if(entity.isEmpty()){
            return null;
        }else{
            return this.getStaffFromEntity(entity.get());
        }
    }

    public Staff addStaff(Staff staff) {
        StaffMember entity = this.getStaffEntityFromStaff(staff);
        entity = this.staffRepository.save(entity);
        return this.getStaffFromEntity(entity);
    }

    public Staff updateRoom(Staff staff) {
        StaffMember entity = this.getStaffEntityFromStaff(staff);
        entity = this.staffRepository.save(entity);
        return this.getStaffFromEntity(entity);
    }

    public void deleteRoom(String id) {
        this.staffRepository.deleteById(id);
    }

    private Staff getStaffFromEntity(StaffMember entity) {
        return new Staff(entity.getEmployeeId(), entity.getFirstName(), entity.getLastName(), entity.getPosition().toString());
    }

    private StaffMember getStaffEntityFromStaff(Staff staff) {
        return new StaffMember(staff.getId(), staff.getFirstName(), staff.getLastName(), Position.valueOf(staff.getPosition()));
    }

}
