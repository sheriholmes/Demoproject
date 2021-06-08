package UsersDetail.User.repository;
import UsersDetail.User.model.index.UserIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepositoryES extends ElasticsearchRepository<UserIndex, UUID> {
}