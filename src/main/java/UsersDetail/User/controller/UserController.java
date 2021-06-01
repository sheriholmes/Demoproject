package UsersDetail.User.controller;
import UsersDetail.User.entity.Address;
import UsersDetail.User.entity.UserEntity;
import UsersDetail.User.model.Mobile;
import UsersDetail.User.model.PostSuccessResponse;
import UsersDetail.User.model.PutSuccessResponse;

import UsersDetail.User.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
public class UserController {
    @Autowired
<<<<<<< HEAD
    UserServiceImpl userServiceImpl;
    @GetMapping("/users/{id}")
    public  UserEntity getUserById(@PathVariable("id") UUID id){
        UserEntity response = userServiceImpl.getUserById(id);
=======
    UserService userService;
    @GetMapping("/users/{id}")
    public  UserEntity getUserById(@PathVariable("id") UUID id){
        UserEntity response = userService.getUserById(id);
>>>>>>> 15edddad3930ecb6f05547f518be5a8ed9f9baed
        return  response;
    }

    @DeleteMapping("/users/{id}")
    public UserEntity deleteUserById(@PathVariable("id")UUID id){
        return userServiceImpl.deleteById(id);

    }

    @PutMapping("/users/{id}")
    public PutSuccessResponse updateUser(@PathVariable("id")UUID id, @RequestBody Address address, Mobile mobile){
        PutSuccessResponse response = userServiceImpl.updateUser(id, address,mobile);


        return  response;
    }

    @PostMapping("/user")
    public PostSuccessResponse addUser (@RequestBody UserEntity userEntity){
<<<<<<< HEAD
        String userId = UUID.randomUUID().toString();
        userEntity.setId(userId);

        return userServiceImpl.addUser(userEntity);
=======

        return userService.addUser(userEntity);

    }
>>>>>>> 15edddad3930ecb6f05547f518be5a8ed9f9baed

    }

}

































