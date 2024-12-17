package SGIT.project.user.users.Service;

import SGIT.project.user.users.Repository.UserRepository;
import SGIT.project.user.users.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserEntity updateUser(Long id, UserEntity userEntity) {
        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
        existingUser.setName(userEntity.getName());
        existingUser.setName(userEntity.getEmail());
        return userRepository.save(existingUser);
    }
}
