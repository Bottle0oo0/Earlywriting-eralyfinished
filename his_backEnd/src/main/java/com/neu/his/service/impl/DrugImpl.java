package com.neu.his.service.impl;
import com.neu.his.entity.Drug;
import com.neu.his.mapper.DrugMapper;
import com.neu.his.service.DrugMag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugImpl implements DrugMag {
    @Autowired
    private DrugMapper drugMapper;
    @Override
    public Drug addDrug(Drug drug) {
        return drugMapper.addDrug(drug);
    }

    @Override
    public int updateDrug(Drug drug) {
        return drugMapper.updateDrug(drug);
    }

    @Override
    public void deleteDrug(int drugId) {
        drugMapper.delDrug(drugId);
    }

    @Override
    public List<Drug> getDrugs() {
        return drugMapper.getAll();
    }

    @Override
    public List<Drug> searchDrug(String key) {
        return drugMapper.searchDrug(key);
    }
}
