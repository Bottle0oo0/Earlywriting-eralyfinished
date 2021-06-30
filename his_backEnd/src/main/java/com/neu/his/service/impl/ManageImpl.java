package com.neu.his.service.impl;

import com.neu.his.entity.Department;
import com.neu.his.mapper.DepartmentMapper;
import com.neu.his.service.ManagePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageImpl implements ManagePort {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public Department addDepartment(Department department) {
        departmentMapper.addDepartment(department);
        return department;
    }

    @Override
    public Department updateDepartment(Department department) {
        departmentMapper.updateDepartment(department);
        return department;
    }

    @Override
    public void deleteDepartment(String departmentId) {
        departmentMapper.delDepartment(departmentId);
    }

    @Override
    public List<Department> getDepartments() {
        return null;
    }

    @Override
    public List<Department> searchDepartment(String key) {
        return departmentMapper.searchDepartment(key);
    }
}
