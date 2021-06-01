package UsersDetail.User.config;
import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Configuration
@EnableCassandraRepositories
public class CassandraLocalConfig extends AbstractCassandraConfiguration {
    @Value("${spring.data.cassandra.contact-points}")
    private String contactPoints;
    @Value("${spring.data.cassandra.port}")
    private int port;
    @Value("${spring.data.cassandra.keyspace}")
    private String keySpace;
    @Value("${spring.data.cassandra.local-datacenter}")
    private String dataCenter;
    @Autowired
    private CqlSession cqlSession;
    @Override
    protected @NotNull String getKeyspaceName() {
        return keySpace;
    }
    @Override
    protected @NotNull String getContactPoints() {
        return contactPoints;
    }
    @Override
    protected int getPort() {
        return port;
    }
    @Override
    protected String getLocalDataCenter() {
        return dataCenter;
    }
    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        final CreateKeyspaceSpecification specification =
                CreateKeyspaceSpecification.createKeyspace(keySpace)
                        .ifNotExists()
                        .with(KeyspaceOption.DURABLE_WRITES, true)
                        .withSimpleReplication();
        List<CreateKeyspaceSpecification> list = new ArrayList<>();
        list.add(specification);
        return list;
    }
    @Bean
    public void createKeyspaceAndTable() throws InterruptedException {
        cqlSession.execute(
                "CREATE KEYSPACE IF NOT EXISTS user WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 }");
        cqlSession.execute(
                "CREATE TABLE IF NOT EXISTS user.userEntity (\n" +
                        "    id text PRIMARY KEY,\n" +
                        "    address varchar,\n" +
                        "    mobile varchar,\n" +
                        ")");
    }
}