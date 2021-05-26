package UsersDetail.User.controller;
import UsersDetail.User.entity.Address;
import UsersDetail.User.model.Mobile;
import UsersDetail.User.model.PutSuccessResponse;
import UsersDetail.User.service.UserService;
import UsersDetail.User.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;


@RestController
public class UserController {
    @Autowired
    UserServiceInterface userServiceInterface;
    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable("id")UUID id){
        String message= userServiceInterface.deleteUserById(id);
        return  message;
    }

    @PutMapping("/users/{id}")
    public PutSuccessResponse updateUser(@PathVariable("id")UUID id, @RequestBody Address address, Mobile mobile){
        PutSuccessResponse response = userServiceInterface.updateUser(id, address,mobile);


        return  response;
    }



    }














