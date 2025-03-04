package com.itacadam.myapp.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.itacadam.myapp.api.requests.UserCreationRequest;
import com.itacadam.myapp.models.User;
import com.itacadam.myapp.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody UserCreationRequest userCreationRequest) {
        return userService.createUser(userCreationRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.removeUser(id);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {
        return userService.getUser(id).orElse(null);
    }

    @GetMapping("/getall")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/getfiltered")
    public List<User> buscarUsuarios(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Integer minEdad,
            @RequestParam(required = false) Integer maxEdad,
            @RequestParam(required = false) Boolean esAdministrador) {

        return userService.filteredSearchUsers(nombre,  minEdad, maxEdad, esAdministrador);
    }

}
