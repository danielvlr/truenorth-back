package com.truenorth.demo.controller;

import com.truenorth.demo.dto.RecordResponse;
import com.truenorth.demo.mapper.RecordMapper;
import com.truenorth.demo.model.Record;
import com.truenorth.demo.model.User;
import com.truenorth.demo.repository.RecordRepository;
import com.truenorth.demo.service.RecordService;
import com.truenorth.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/records")
public class RecordController {
    @Autowired
    private RecordService recordService;

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<RecordResponse>> getUserRecords(@AuthenticationPrincipal User userDetails,
                                                       @RequestParam(required = false) String title,
                                                       @RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "3") int size,
                                                       @RequestParam(defaultValue = "id,desc") String[] sort) {

//        if (userDetails != null) {
//            List<Order> orders = new ArrayList<>();
//
//            if (sort[0].contains(",")) {
//                // will sort more than 2 fields
//                // sortOrder="field, direction"
//                for (String sortOrder : sort) {
//                    String[] _sort = sortOrder.split(",");
//                    orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
//                }
//            } else {
//                // sort=[field, direction]
//                orders.add(new Order(getSortDirection(sort[1]), sort[0]));
//            }
//
//            List<Record> tutorials = new ArrayList<>();
//            Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));
//
//            Page<Record> pageTuts;
//            if (title == null)
//                pageTuts = recordRepository.findAll(pagingSort);
//            else
//                pageTuts = tutorialRepository.findByTitleContaining(title, pagingSort);
//
//            tutorials = pageTuts.getContent();
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("tutorials", tutorials);
//            response.put("currentPage", pageTuts.getNumber());
//            response.put("totalItems", pageTuts.getTotalElements());
//            response.put("totalPages", pageTuts.getTotalPages());
//
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        }
        return ResponseEntity.ok(recordService.getRecordsByUser(userDetails));
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
