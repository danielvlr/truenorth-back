package com.truenorth.demo.repository;

import com.truenorth.demo.model.Record;
import com.truenorth.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findByUserOrderByDateDesc(User user);
     Optional<Record> findFirstByUserAndDeletedOrderByDateDesc(User user, boolean deleted);
}