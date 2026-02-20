package com.example.springindiv2.controller;

import com.example.springindiv2.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static List<User> USERS = List.of(
            new User(1L, "Imran", "Rasulzada"),
            new User(2L, "Said", "Kazimli"));

    @GetMapping
    public List<User> getUsers() {
        return USERS;
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable Long id) {
        for (User user : USERS) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        throw new RuntimeException("User not found");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user) {
        System.out.println("addingg");
        System.out.println(user);
    }

    @PutMapping("{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        System.out.println("update");
        System.out.println(user);
    }


    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@RequestParam Long id, @RequestParam String a) {
        System.out.println("delete");
        System.out.println(id);
    }
}
