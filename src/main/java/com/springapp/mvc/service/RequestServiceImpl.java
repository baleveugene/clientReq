package com.springapp.mvc.service;

import com.springapp.mvc.model.Request;
import com.springapp.mvc.model.User;
import com.springapp.mvc.repository.RequestRepository;
import com.springapp.mvc.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RequestRepository requestRepository;   

    @Override
    public void save(Request request) {
       
    }
    
    @Override
    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    @Override
    public Request findByText(String text) {
        return requestRepository.findByText(text);
    }
}
