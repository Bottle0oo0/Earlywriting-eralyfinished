package com.neu.his.service;

import com.neu.his.entity.Department;
import com.neu.his.entity.User;

import java.util.List;

public interface ManagePort {

    Department addDepartment(Department department);

    Department updateDepartment(Department department);

    void deleteDepartment(String departmentId);

    List<Department> getDepartments();

    List<Department> searchDepartment(String key);
}
