package UsersDetail.User.service;
import UsersDetail.User.entity.Address;
import UsersDetail.User.entity.UserEntity;
import UsersDetail.User.model.Mobile;
import UsersDetail.User.model.PutSuccessResponse;

import java.util.UUID;

public interface UserServiceInterface {

    String deleteUserById(UUID id);
    PutSuccessResponse updateUser(UUID id, Address address, Mobile mobile);



}
