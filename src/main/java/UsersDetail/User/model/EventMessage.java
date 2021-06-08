package UsersDetail.User.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventMessage {
    private String time;
    private UserResponse userResponse;
    private Event event;

    @Override
    public String toString() {
        return "EventMessage{" +
                "time='" + time + '\'' +
                ", user=" + userResponse +
                ", event=" + event +
                '}';
    }
}