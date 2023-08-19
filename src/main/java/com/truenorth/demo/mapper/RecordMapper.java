package com.truenorth.demo.mapper;

import com.truenorth.demo.dto.RecordResponse;
import com.truenorth.demo.model.Operation;
import com.truenorth.demo.model.Record;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecordMapper {
     @Mapping(source = "operation", target = "operation")
     List<RecordResponse> toDto(List<Record> record);

     default String mapGetOperation(Operation operation) {
          return operation.getType().name();
     }
}
