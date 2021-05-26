package UsersDetail.User.service;
import UsersDetail.User.entity.Address;
import UsersDetail.User.entity.UserEntity;
import UsersDetail.User.model.*;
import UsersDetail.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    UserRepository userRepository;
@Override
    public UserEntity getUserById(UUID id){
        Optional<UserEntity> check = userRepository.findById(id);
        UserEntity response = null;
        if(check.isPresent())
            response = check.get();
        return  response;
    }

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public UserEntity deleteById(UUID id) {
        UserEntity userEntity = this.userRepository.findById(id).get();
        userEntity.setDeleted(true);
        userRepository.save(userEntity);
        return userEntity;
    }
    @Override
    public PutSuccessResponse updateUser(UUID id, Address address,Mobile mobile){
        Optional<UserEntity> previousUser = userRepository.findById(id);
        UserEntity response = null;
        if (previousUser.isPresent()){
            response = previousUser.get();
            if(address.getLine1()!= null)
                response.setLine1(address.getLine1());
            if(address.getCity()!=null)
                response.setCity(address.getCity());
            if(address.getPincode()!=null)
                response.setPincode(address.getPincode());
            if(mobile.getNumber()!=null)
                response.setNumber(mobile.getNumber());

            userRepository.save(response);

        }
        Request request = getRequest();
        return new PutSuccessResponse().data(new GetErrorResponseAllOfData().id(id.toString()));
    }
    public  Request getRequest(){
        Request request = new Request();
        request.setMethod(Method.PUT);
        request.setUri("local host : 8080/user");
        request.setQueryString("update user");

    return  request;
    }
    public PostSuccessResponse addUser(UserEntity userEntity){
        UserEntity user=new UserEntity();
        user.setName(userEntity.getName());
        user.setCity(userEntity.getCity());
        user.setLine1(userEntity.getLine1());
        user.setPincode(userEntity.getPincode());
        user.setNumber(userEntity.getNumber());
        userRepository.save(user);
        Request request = getPost();

        return new PostSuccessResponse().data(new GetErrorResponseAllOfData().id(user.getId().toString()));


    }
    public  Request getPost() {
        Request request = new Request();
        request.setMethod(Method.POST);
        request.setUri("local host : 8080/user");
        request.setQueryString("create user");

        return request;

    }
}
