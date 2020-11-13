package com.aux.terminator.service;

import com.aux.terminator.dao.mapper.UserViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserViewService {
    @Autowired
    UserViewMapper uvm;
}
