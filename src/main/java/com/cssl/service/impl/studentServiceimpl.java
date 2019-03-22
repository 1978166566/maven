package com.cssl.service.impl;

import com.cssl.dao.studentDao;
import com.cssl.pojo.Student;
import com.cssl.service.studentServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class studentServiceimpl implements studentServcie {
    @Autowired
    private studentDao studentDao;

    @Override
    public List<Student> selectAll() {
        return studentDao.selectAll();
    }
}
