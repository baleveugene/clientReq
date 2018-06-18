package com.springapp.mvc.service;

import com.springapp.mvc.model.Request;
import java.util.List;

public interface RequestService {
    void save(Request request);
    public List<Request> findAll();

    Request findByText(String text);
}
