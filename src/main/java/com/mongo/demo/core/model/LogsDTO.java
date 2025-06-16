package com.mongo.demo.core.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@Setter
@Getter
@Builder
@ToString
@Document(collection = "logs")
public class LogsDTO {

    @NotNull
    private String returnCode;
    @NotNull
    private String serviceName;
    @NotNull
    private String level;
    @NotNull
    private String message;
    private LocalDateTime timestamp;
    private Map<String, Object> metadata;
}
