package com.portfolio.back.controller;

import com.portfolio.back.model.WorkTimeType;
import com.portfolio.back.service.IWorkTimeTypeService;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkTimeTypeController {
    
    @Autowired
    private IWorkTimeTypeService service;
    
    @PostMapping ("/work-time-types")
    public ResponseEntity<WorkTimeType> create (@Valid @RequestBody WorkTimeType workTimeType){
         WorkTimeType newWorkTimeType = service.create(workTimeType);
        return new ResponseEntity<>(newWorkTimeType, HttpStatus.CREATED);
    }
    
    @GetMapping ("/work-time-types")
    @ResponseBody
    public List<WorkTimeType> list(){
       return service.list();
    }
    
    @GetMapping ("/work-time-types/{id}")
    @ResponseBody
    public ResponseEntity<WorkTimeType> getById(@PathVariable UUID id){
        WorkTimeType workTimeType = service.getById(id);
        return new ResponseEntity<>(workTimeType,HttpStatus.OK);
    }
        
    
    @DeleteMapping ("/work-time-types/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping ("/work-time-types/{id}")
    public ResponseEntity<WorkTimeType> update(@PathVariable UUID id,
            @Valid @RequestBody WorkTimeType workTimeType){
        workTimeType.setId(id);
        WorkTimeType updatedWorkTimeType = service.update(workTimeType);
        return new ResponseEntity<>(updatedWorkTimeType, HttpStatus.OK);
    }
    
}
