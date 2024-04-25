package org.example.last.java.service.impl;

import org.example.last.java.entity.Admin;
import org.example.last.java.mapper.AdminMapper;
import org.example.last.java.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceimpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public Admin login(String id) {
        Admin admin1=adminMapper.getByAdminname(id);
        return admin1;
    }
}
