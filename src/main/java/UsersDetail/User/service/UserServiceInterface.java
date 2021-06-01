package UsersDetail.User.service;
import UsersDetail.User.entity.Address;
import UsersDetail.User.entity.UserEntity;
import UsersDetail.User.model.Mobile;
import UsersDetail.User.model.PutSuccessResponse;

import java.util.UUID;

public interface UserServiceInterface {


    PutSuccessResponse updateUser(UUID id, Address address, Mobile mobile);
    UserEntity getUserById(UUID id);
    UserEntity deleteById(UUID id);


}
