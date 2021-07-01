package com.neu.his.service;

import com.neu.his.entity.Department;
import com.neu.his.entity.Drug;

import java.util.List;

public interface DrugMag {
    Drug addDrug(Drug drug);

    int updateDrug(Drug drug);

    void deleteDrug(int drugId);

    List<Drug> getDrugs();

    List<Drug> searchDrug(String key);
}
