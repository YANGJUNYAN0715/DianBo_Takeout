package com.yjy.dianbo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yjy.dianbo.entity.Employee;
import com.yjy.dianbo.mapper.EmployMapper;
import com.yjy.dianbo.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployMapper, Employee> implements EmployeeService {

}
