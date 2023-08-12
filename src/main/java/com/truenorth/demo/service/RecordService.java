package com.truenorth.demo.service;

import com.truenorth.demo.model.Operation;
import com.truenorth.demo.model.Record;
import com.truenorth.demo.model.User;
import com.truenorth.demo.repository.RecordRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RecordService {

    private RecordRepository recordRepository;

    RecordService(RecordRepository recordRepository){
        this.recordRepository = recordRepository;
    }

    public List<Record> getRecordsByUser(User user) {
        return recordRepository.findByUserOrderByDateDesc(user);
    }

    public Optional<Record> getLastRecordsByUser(User user) {
        return recordRepository.findFirstByUserAndDeletedOrderByDateDesc(user, false);
    }

    public BigDecimal getLastOperationResponseByUser(User user) {
        return recordRepository.findFirstByUserAndDeletedOrderByDateDesc(user, false).map(Record::getOperationResponse).orElse(BigDecimal.ZERO);
    }


    public void createRecord(User user, Operation operation, BigDecimal amount, BigDecimal userBalance, BigDecimal response) {
        Record record = new Record();
        record.setUser(user);
        record.setOperation(operation);
        record.setAmount(amount);
        record.setUserBalance(userBalance);
        record.setOperationResponse(response);
        record.setDate(LocalDateTime.now());
        recordRepository.save(record);
    }

    public void softDeleteRecord(Long recordId) {
        Record record = recordRepository.findById(recordId).orElse(null);

        if (record != null) {
            record.setDeleted(true);
            recordRepository.save(record);
        }
    }
}
