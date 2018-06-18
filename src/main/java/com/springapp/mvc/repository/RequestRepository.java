package com.springapp.mvc.repository;

import com.springapp.mvc.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
    Request findByText(String text);
}
