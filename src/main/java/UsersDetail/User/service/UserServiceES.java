package UsersDetail.User.service;

import UsersDetail.User.model.index.UserIndex;
import UsersDetail.User.repository.UserRepositoryES;
import com.datastax.oss.driver.shaded.guava.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
@Service
@Slf4j
public class UserServiceES {

    public static final String EVENT_TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";


    @Autowired
    private UserRepositoryES userRepositoryES;


    public UserIndex saveUser(UserIndex user) {
        return userRepositoryES.save(user);
    }




    public List<UserIndex> userHistory(UUID uuid, long fromDate, long toDate, Integer limit, Integer offset) {
        MatchPhraseQueryBuilder userIdFilter = QueryBuilders.matchPhraseQuery("user.id", uuid.toString());

        LocalDateTime fromDateTime = getLocalDateTime(fromDate);
        RangeQueryBuilder timeRange = QueryBuilders.rangeQuery("createdAt")
                .from(fromDateTime)
                .to(fromDateTime.plusDays(toDate))
                .format(EVENT_TIMESTAMP_FORMAT);

        BoolQueryBuilder query = QueryBuilders.boolQuery().must(userIdFilter).must(timeRange);

        Iterable<UserIndex> result = userRepositoryES.search(query);
        return Lists.newArrayList(result);
    }


    private LocalDateTime getLocalDateTime(long epoch) {
        return Instant.ofEpochMilli(epoch).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}