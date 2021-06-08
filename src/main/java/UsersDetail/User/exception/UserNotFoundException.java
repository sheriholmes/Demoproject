package UsersDetail.User.exception;

import java.text.MessageFormat;
import java.util.UUID;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String id) {
        super(MessageFormat.format("User with Id {0} not found", id));
    }
}