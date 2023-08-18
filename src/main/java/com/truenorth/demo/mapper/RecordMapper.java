package com.truenorth.demo.mapper;

import com.truenorth.demo.dto.RecordResponse;
import com.truenorth.demo.model.Record;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecordMapper {
     List<RecordResponse> toDto(List<Record> record);
}
