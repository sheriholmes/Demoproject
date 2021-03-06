package UsersDetail.User.controller;
import UsersDetail.User.entity.UserEntity;
import UsersDetail.User.model.*;

import UsersDetail.User.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("/user/{id}")
    public GetSuccessResponse getUserById(@PathVariable("id") String id) {
        GetSuccessResponse response = userServiceImpl.getUserById(id);
        return response;
    }

    @DeleteMapping("/user/{id}")
    public UserEntity deleteUserById(@PathVariable("id") String id) {
        return userServiceImpl.deleteById(id);


    }

    @PutMapping("/user/{id}")
    public PutSuccessResponse updateUser(@PathVariable("id") String id, @RequestBody PutUserId putUserId) {
        PutSuccessResponse response = userServiceImpl.updateUser(id, putUserId);

        return response;
    }

    @PostMapping("/user")

    public PostSuccessResponse addUser(@Valid @RequestBody UserRequest userRequest) {
        return userServiceImpl.addUser(userRequest);


    }
}

































