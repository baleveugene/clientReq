package com.springapp.mvc.service;

import com.springapp.mvc.model.ReqStatus;
import java.util.List;

public interface ReqStatusService {
    
    ReqStatus findByName(String status);
    public List<ReqStatus> findAll();
}
