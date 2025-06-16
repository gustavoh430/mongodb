package com.mongo.demo.infraestructure;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

public class MongoClientConfig {

    @Bean
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/db");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .applyToConnectionPoolSettings(builder -> builder
                        .maxSize(50)
                        .minSize(10)
                        .maxWaitTime(10, TimeUnit.SECONDS)
                )
                .build();
        return MongoClients.create(settings);
    }

}
