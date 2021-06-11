package UsersDetail.User.service;
import UsersDetail.User.entity.UserEntity;
import UsersDetail.User.exception.UserNotFoundException;
import UsersDetail.User.model.*;
import UsersDetail.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.UUID;


@Service

public class UserServiceImpl implements UserServiceInterface {
    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpServletRequest httpServletRequest;

    @Override
    public GetSuccessResponse getUserById(String id ) {
        UserEntity userEntity = userRepository.findById(id).
                orElseThrow(() -> new UserNotFoundException(id));
        if (userEntity.getDeleted()){
            throw  new UserNotFoundException(id);
        }
        Address address = new Address();
        address.setCity(userEntity.getCity());
        address.setPincode(Integer.valueOf(userEntity.getPincode()));
        address.setLine1(userEntity.getLine1());
        Mobile mobile = new Mobile();
        mobile.setNumber(userEntity.getNumber());

        return  new GetSuccessResponse().data(new UserResponse().id(UUID.fromString(id)).name(userEntity.getName()).address(address).mobile(mobile))
                .request(new Request().uri(httpServletRequest.getRequestURI().toString())
                        .method(Method.valueOf(httpServletRequest.getMethod()))
                        .queryString(httpServletRequest.getQueryString()));

    }

    public UserEntity deleteById(String id) {

        UserEntity userEntity = this.userRepository.findById(id).get();
        if (!userEntity.getDeleted())
        userEntity.setDeleted(true);
        else
            throw new UserNotFoundException(id);
        userRepository.save(userEntity);
        return userEntity;

    }
    @Override
    public PutSuccessResponse updateUser(String id, PutUserId putUserId){

        Optional<UserEntity> previousUser = Optional.ofNullable(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id)));
        UserEntity response = new UserEntity();
        if (previousUser.isPresent()) {
            response = previousUser.get();

            if (putUserId.getLine1() != null)
                response.setLine1(putUserId.getLine1());
            if (putUserId.getCity() != null)
                response.setCity(putUserId.getCity());
            if (putUserId.getPincode() != null)
                response.setPincode(putUserId.getPincode().toString());
            if (putUserId.getNumber() != null)
                response.setNumber(putUserId.getNumber());

            userRepository.save(response);

        }
        if (previousUser.get().getDeleted()){
            throw  new UserNotFoundException(id);
        }

        return new PutSuccessResponse().data(new GetErrorResponseAllOfData().id(id))
                .request(new Request().uri(httpServletRequest.getRequestURI().toString())
                        .method(Method.valueOf(httpServletRequest.getMethod())).queryString(httpServletRequest.getQueryString()));
    }

    public PostSuccessResponse addUser( UserRequest userRequest){
        UserEntity user=new UserEntity();
        user.setId(UUID.randomUUID().toString());
        user.setName(userRequest.getName());
        user.setCity(userRequest.getAddress().getCity());
        user.setLine1(userRequest.getAddress().getLine1());
        user.setPincode(userRequest.getAddress().getPincode().toString());
        user.setNumber(userRequest.getMobile().getNumber());
        userRepository.save(user);

        return new PostSuccessResponse().data(new GetErrorResponseAllOfData().id(user.getId()))
                .request(new Request().uri(httpServletRequest.getRequestURI().toString()).method(Method.valueOf(httpServletRequest.getMethod()))
                        .queryString(httpServletRequest.getQueryString()));


    }
}
