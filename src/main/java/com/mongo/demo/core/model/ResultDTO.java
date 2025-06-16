package com.mongo.demo.core.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@Builder
@ToString
public class ResultDTO {


    private List<LogsDTO> logs;

}
