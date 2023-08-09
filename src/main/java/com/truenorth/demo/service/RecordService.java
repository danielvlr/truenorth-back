package com.truenorth.demo.service;

import com.truenorth.demo.model.Operation;
import com.truenorth.demo.model.Record;
import com.truenorth.demo.model.User;
import com.truenorth.demo.repository.RecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecordService {

    private RecordRepository recordRepository;

    RecordService(RecordRepository recordRepository){
        this.recordRepository = recordRepository;
    }

    public List<Record> getRecordsByUser(User user) {
        return recordRepository.findByUserOrderByDateDesc(user);
    }

    public Record getLastRecordsByUser(User user) {
        return recordRepository.findFirstByUserOrderByDateDesc(user);
    }

    public void createRecord(User user, Operation operation, double amount, double userBalance, String response) {
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
