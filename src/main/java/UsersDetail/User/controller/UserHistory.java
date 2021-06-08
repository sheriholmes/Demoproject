package UsersDetail.User.controller;



import UsersDetail.User.model.GetErrorResponse;
import UsersDetail.User.model.UserResponse;
import UsersDetail.User.model.index.UserIndex;
import UsersDetail.User.service.UserServiceES;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.UUID;

import static UsersDetail.User.utils.Constants.*;



@Validated
@Api(value = "userHistory" )
@RestController
class UserHistory{


    @Autowired
    private UserServiceES userServiceES;

    @ApiOperation(value = " User change log", nickname = "getChangeLog", notes = "", response = UserResponse.class, tags = {"Change Log",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "This is a user info!.", response = List.class),
            @ApiResponse(code = 400, message = "Error Occurred", response = GetErrorResponse.class),
            @ApiResponse(code = 401, message = "Error Occurred", response = GetErrorResponse.class),
            @ApiResponse(code = 404, message = "Error Occurred", response = GetErrorResponse.class)})
    @GetMapping(value = "/user/{userId}/change-log")
    public List<UserIndex> getChangeLog(
            @ApiParam(value = "userId which should be deleted", required = true) @PathVariable("userId") UUID userId,
            @NotNull @ApiParam(value = "Start time of the change log in unix epoch format.", required = true)
            @Valid @RequestParam(value = "from", required = true) long from, @Min(1) @Max(31)
            @ApiParam(value = "Number of days for which change log is to be returned.", defaultValue = TO_DATE_DEFAULT)
            @Valid @RequestParam(value = "toDate", required = false, defaultValue = TO_DATE_DEFAULT) long toDate, @Min(1)
            @ApiParam(value = "Number of items to return.", defaultValue = LIMIT)
            @Valid @RequestParam(value = "limit", required = false, defaultValue = LIMIT) Integer limit, @Min(0)
            @ApiParam(value = "Number of items to skip from start.", defaultValue = OFF_SET_DEFAULT_VALUE)
            @Valid @RequestParam(value = "offset", required = false, defaultValue = OFF_SET_DEFAULT_VALUE) Integer offset) {
        return userServiceES.userHistory(userId, from, toDate, limit, offset);
    }

}