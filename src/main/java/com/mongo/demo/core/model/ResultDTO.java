package com.mongo.demo.core.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class ResultDTO {


    private List<LogsDTO> logs;

}
