package SGIT.project.user.users.Controllers;

import SGIT.project.user.users.Service.UserService;
import SGIT.project.user.users.entities.UserEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create a new user
    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        return userService.saveUser(userEntity);
    }

    // Get all users
    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get a user by ID
    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    // Update a user by ID
    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity userEntity) {
        return userService.updateUser(id, userEntity);
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
