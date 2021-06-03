package UsersDetail.User.service;
import UsersDetail.User.entity.Address;
import UsersDetail.User.entity.UserEntity;
import UsersDetail.User.model.*;
import UsersDetail.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserServiceInterface {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserEntity getUserById(String id){
        Optional<UserEntity> check = userRepository.findById(id);
        UserEntity response = null;
        if(check.isPresent())
            response = check.get();
        return  response;
    }

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public UserEntity deleteById(String id) {
        UserEntity userEntity = this.userRepository.findById(id).get();
        userEntity.setDeleted(true);
        userRepository.save(userEntity);
        return userEntity;
    }
    @Override
    public PutSuccessResponse updateUser(String id, PutUserId putUserId){
        Optional<UserEntity> previousUser = userRepository.findById(id);
        UserEntity response = new UserEntity();
        if (previousUser.isPresent()){
            response = previousUser.get();
            if(putUserId.getLine1()!= null)
                response.setLine1(putUserId.getLine1());
            if(putUserId.getCity()!=null)
                response.setCity(putUserId.getCity());
            if(putUserId.getPincode()!=null)
                response.setPincode(putUserId.getPincode().toString());
            if(putUserId.getNumber()!=null)
                response.setNumber(putUserId.getNumber());

            userRepository.save(response);

        }

        return new PutSuccessResponse().data(new GetErrorResponseAllOfData().id(id.toString()));
    }

    public PostSuccessResponse addUser(UserRequest userRequest){
        UserEntity user=new UserEntity();
        user.setId(UUID.randomUUID().toString());

        user.setName(userRequest.getName());
        user.setCity(userRequest.getAddress().getCity());
        user.setLine1(userRequest.getAddress().getLine1());
        user.setPincode(userRequest.getAddress().getPincode().toString());
        user.setNumber(userRequest.getMobile().getNumber());
        userRepository.save(user);





        return new PostSuccessResponse().data(new GetErrorResponseAllOfData().id(user.getId()));


    }
}
