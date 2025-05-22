package com.example.booting;

import com.example.booting.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

    /* @Autowired
    private RoomRepository userRepository;

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            userRepository.save(user);
            return "User updated";
        } else {
            return "User not found";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return "Deleted";
    } */
}
