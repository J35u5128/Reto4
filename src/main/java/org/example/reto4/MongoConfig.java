package org.example.reto4;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {

    @Value("${spring.mongodb.uri}")
    private String mongoUri;

    @Value("${spring.mongodb.database}")
    private String mongoDatabase;

    @Bean
    public MongoTemplate mongoTemplate() {
        ConnectionString connectionString = new ConnectionString(mongoUri);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .applyToSslSettings(builder -> builder.enabled(true).invalidHostNameAllowed(true))
                .build();

        String databaseName = connectionString.getDatabase();
        if (databaseName == null || databaseName.isEmpty()) {
            databaseName = mongoDatabase;
        }

        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(MongoClients.create(mongoClientSettings), databaseName));
    }
}
