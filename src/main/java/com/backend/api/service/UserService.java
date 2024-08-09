package com.backend.api.service;

        import java.util.Collections;
        import java.util.List;

        import com.backend.api.entity.UserEntity;
        import com.backend.api.data.UserRepository;
        import com.backend.api.response.OperationResult;
        import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public OperationResult userExist(String username) {
        try {
            UserEntity user = userRepository.findByUsername(username);
            return new OperationResult(user != null, user != null ? "User exists" : "User not exists");
        } catch (Exception ex) {
            return new OperationResult(false, ex.getMessage());
        }
    }

    public boolean authenticate(String username, String password) {
        try {
            UserEntity user = userRepository.findByUsername(username);
            return user.getPassword().equals(password);
        } catch (Exception ex) {
            return false;
        }
    }

    public OperationResult addPerson(UserEntity person) {
        try {
            userRepository.save(person);
            return new OperationResult(true, "Person added successfully.");
        } catch (Exception ex) {
            return new OperationResult(false, "Person could not be added!: " + ex.getMessage());
        }

    }

    public OperationResult deleteUser(String username, String password) {
        try {
            UserEntity user = this.userRepository.findByUsername(username);
            this.userRepository.deleteById(user.getId());
            return new OperationResult(true, "Person deleted successfully.");

        } catch (Exception ex) {
            return new OperationResult(false, "Person could not be deleted!: " + ex.getMessage());
        }

    }

    public List<UserEntity> getAllData() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
    public boolean updateUserName(String name, String newName) {

        try {
            UserEntity temp =userRepository.findByUsername(name);
            temp.setUsername(newName);
            userRepository.save(temp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updatePassword(String name, String password) {

        try {
            UserEntity temp = userRepository.findByUsername(name);
            temp.setPassword(password);
            userRepository.save(temp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateEmail(String name, String email) {

        try {
            UserEntity temp = userRepository.findByUsername(name);
            temp.setEmail(email);
            userRepository.save(temp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
