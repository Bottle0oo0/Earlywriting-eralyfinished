package com.neu.his.controller;
import com.neu.his.entity.Department;
import com.neu.his.entity.Drug;
import com.neu.his.mapper.DepartmentMapper;
import com.neu.his.service.DrugMag;
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

    @Autowired
    private DrugMag drugMag;

    //管理科室：增删改查
    @RequestMapping("/manage/add_department")
    public int addDepartment(@RequestBody Department bean) {
        return managePort.addDepartment(bean);
    }

    @RequestMapping("/manage/delete_department")
    public void deleteDepartment(@RequestBody Map<String, Integer> department) {
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

    //管理药物：增删改查
    @RequestMapping("/manage/get_all_drug")
    public List<Drug> getAllDrugs() {
        return drugMag.getDrugs();
    }

    @RequestMapping("/manage/add_drug")
    public Drug addDrug(@RequestBody Drug bean) {
        return drugMag.addDrug(bean);
    }

    @RequestMapping("/manage/delete_drug")
    public void deleteDrug(@RequestBody Map<String, Integer> drugId) {
        drugMag.deleteDrug(drugId.get("id"));
    }

    @RequestMapping("/manage/update_drug")
    public int updateDrug(@RequestBody Drug bean) {
       return drugMag.updateDrug(bean);
    }

    @RequestMapping("/manage/search_drug")
    public List<Drug> searchDrug(@RequestBody Map<String, String> keyWord) {
        return drugMag.searchDrug(keyWord.get("key"));
    }


}
