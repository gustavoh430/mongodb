package com.mongo.demo.adapters.in.rest;

import com.mongo.demo.adapters.out.persistence.MongoDBRespository;
import com.mongo.demo.core.model.LogsDTO;
import com.mongo.demo.core.model.ResultDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/logs")
public class LogsController {

    Logger log = Logger.getLogger(LogsController.class.getName());

    @Autowired
    private MongoDBRespository repository;

    @PostMapping
    public ResponseEntity<LogsDTO> createLog(@Valid @RequestBody LogsDTO logsDTO) {

        logsDTO.setTimestamp(LocalDateTime.now());
        LogsDTO response = repository.save(logsDTO);
        log.info(response.toString());
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


    @GetMapping("/{serviceName}")
    public ResponseEntity<ResultDTO> getLog(@PathVariable String serviceName) {

        ResultDTO resultDTO =  ResultDTO.builder().logs(repository.findByServiceName(serviceName)).build();
        log.info(resultDTO.toString());
        return new ResponseEntity<>(resultDTO,HttpStatus.OK);

    }

}
