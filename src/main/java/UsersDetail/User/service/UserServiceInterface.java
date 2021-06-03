package UsersDetail.User.service;
import UsersDetail.User.entity.Address;
import UsersDetail.User.entity.UserEntity;
import UsersDetail.User.model.Mobile;
import UsersDetail.User.model.PutSuccessResponse;
import UsersDetail.User.model.PutUserId;

import java.util.UUID;

public interface UserServiceInterface {


    PutSuccessResponse updateUser(String id, PutUserId putUserId);
    UserEntity getUserById(String id);
    UserEntity deleteById(String id);


}
