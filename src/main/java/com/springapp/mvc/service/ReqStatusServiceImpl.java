package com.springapp.mvc.service;

import com.springapp.mvc.model.ReqStatus;
import com.springapp.mvc.repository.ReqStatusRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReqStatusServiceImpl implements ReqStatusService {
    
    @Autowired
    private ReqStatusRepository reqStatusRepository;  
    @Override
    public ReqStatus findByName(String status) {
        return reqStatusRepository.findByName(status);
    }
    @Override
    public List<ReqStatus> findAll() {
        return reqStatusRepository.findAll();
    }
}
