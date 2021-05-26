package UsersDetail.User.controller;
import UsersDetail.User.entity.Address;
import UsersDetail.User.entity.UserEntity;
import UsersDetail.User.model.Mobile;
import UsersDetail.User.model.PutSuccessResponse;
import UsersDetail.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;


@RestController
public class UserController {
    @Autowired
    UserService userService;
    @DeleteMapping("/users/{id}")
    public UserEntity deleteUserById(@PathVariable("id")UUID id){
          return userService.deleteById(id);

    }

    @PutMapping("/users/{id}")
    public PutSuccessResponse updateUser(@PathVariable("id")UUID id, @RequestBody Address address, Mobile mobile){
        PutSuccessResponse response = userService.updateUser(id, address,mobile);


        return  response;
    }



    }














