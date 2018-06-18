package com.springapp.mvc.repository;

import com.springapp.mvc.model.ReqStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReqStatusRepository extends JpaRepository<ReqStatus, Long> {
    ReqStatus findByName(String status);
}
