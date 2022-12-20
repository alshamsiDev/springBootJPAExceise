package com.example.usersmanagementsoftware.Controller;

import com.example.usersmanagementsoftware.Model.User;
import com.example.usersmanagementsoftware.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UsersController {
    private final UserService userService;


//    Update User
//    Delete User

    /**
     * Get all the Users
     *
     * @return
     */
    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.status(200).body(userService.all());
    }

    /**
     * Add new User
     *
     * @param user
     * @param errors
     * @return
     */

    @PostMapping("/create")
    public ResponseEntity<String> addUser(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            System.out.println(errors.getFieldError());
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.create(user);
        return ResponseEntity.status(200).body("User created");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            System.out.println(errors.getFieldError());
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.update(id, user);
        return ResponseEntity.status(200).body("User created");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.delete(id);
        return ResponseEntity.status(200).body("Deleted");
    }
}
