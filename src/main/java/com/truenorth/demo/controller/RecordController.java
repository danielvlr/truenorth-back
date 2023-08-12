package com.truenorth.demo.controller;

import com.truenorth.demo.model.Record;
import com.truenorth.demo.model.User;
import com.truenorth.demo.service.RecordService;
import com.truenorth.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/records")
public class RecordController {
    @Autowired
    private RecordService recordService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<Record>> getUserRecords(@AuthenticationPrincipal User userDetails) {
        if (userDetails != null) {
            List<Record> userRecords = recordService.getRecordsByUser(userDetails);
            return ResponseEntity.ok(userRecords);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/current-result")
    public ResponseEntity<BigDecimal> getUserCurrentResult(@AuthenticationPrincipal User userDetails) {
        if (userDetails != null) {
            Optional<Record> lastRecord = recordService.getLastRecordsByUser(userDetails);
            return ResponseEntity.ok(lastRecord.map(Record::getOperationResponse).orElse(BigDecimal.ZERO));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @DeleteMapping("/{recordId}")
    public ResponseEntity<String> deleteRecord(@PathVariable Long recordId) {
        recordService.softDeleteRecord(recordId);
        return ResponseEntity.ok("Record deleted.");
    }
}
