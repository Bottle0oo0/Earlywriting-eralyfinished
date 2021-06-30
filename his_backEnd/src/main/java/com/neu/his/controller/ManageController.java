package com.neu.his.controller;
import com.neu.his.entity.Department;
import com.neu.his.mapper.DepartmentMapper;
import com.neu.his.service.ManagePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ManageController {
    @Autowired
    private ManagePort managePort;

    @RequestMapping("/manage/add_department")
    public Department addDepartment(@RequestBody Department bean) {
        return managePort.addDepartment(bean);
    }

    @RequestMapping("/manage/delete_department")
    public void deleteDepartment(@RequestBody Map<String, String> department) {
        managePort.deleteDepartment(department.get("id"));
    }

    @RequestMapping("/manage/update_department")
    public Department updateDepartment(@RequestBody Department bean) {
        return managePort.updateDepartment(bean);
    }

    @RequestMapping("/manage/search_department")
    public List<Department> searchDepartment(@RequestBody Map<String, String> keyWord) {
        return managePort.searchDepartment(keyWord.get("key"));
    }



}
