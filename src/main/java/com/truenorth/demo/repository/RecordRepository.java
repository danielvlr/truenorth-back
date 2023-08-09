package com.truenorth.demo.repository;

import com.truenorth.demo.model.Record;
import com.truenorth.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findByUserOrderByDateDesc(User user);
    Record findFirstByUserOrderByDateDesc(User user);

}