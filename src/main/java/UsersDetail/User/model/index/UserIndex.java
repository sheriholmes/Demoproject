package UsersDetail.User.model.index;

import UsersDetail.User.model.Event;
import UsersDetail.User.model.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;
import java.util.UUID;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "users")
@Data
public class UserIndex {

    @Id
    private UUID id ;

    @Field(type = FieldType.Nested, includeInParent = true)
    private UserResponse userResponse;
    @Field(type = FieldType.Text)
    private Event event;

    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "uuuu-MM-dd'T'HH:mm:ssZZ")
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "UserIndex{" +
                "id=" + id +
                ", user=" + userResponse +
                ", event=" + event +
                ", createdAt=" + createdAt +
                '}';
    }
}