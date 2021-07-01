package com.neu.his.mapper;

import com.neu.his.entity.Department;
import com.neu.his.entity.Drug;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugMapper {


    @Select("select * from drug where id=#{id}")
    @Results(id = "drugMap",value = {
            @Result(column = "id",property = "id"),
            @Result(column = "DrugsCode",property = "code" ) ,
            @Result(column = "DrugsName",property = "name"),
            @Result(column = "DrugsFormat",property = "format"),
            @Result(column = "DrugsUnit",property = "unit"),
            @Result(column = "Manufacturer",property = "manufacturer"),
            @Result(column = "DrugsDosageID",property = "dosage"),
            @Result(column = "DrugsTypeID",property = "type"),
            @Result(column = "DrugsPrice",property = "price"),
            @Result(column = "MnemonicCode",property = "mnemonicCode")
    })
    Drug getDrug(@Param("id") int id);

    @ResultMap(value = "drugMap")
    @Select("select * from drug where MnemonicCode=#{key}")
    List<Drug> searchDrug(@Param("key") String key);

    @Select("select * from drug")
    @ResultMap(value = "drugMap")
    List<Drug> getAll();

    @Select("select DrugsName from drug where id=#{id}")
    String getNameOf(@Param("id") int id);


    @Insert("insert into drug values (#{id}, #{code}, #{name}, #{format}, #{unit}, #{manufacturer}, #{dosage}, #{type}, #{price}, #{mnemonicCode})")
    @ResultMap(value = "drugMap")
    Drug addDrug(Drug drug);

    @Delete("delete from drug where id=#{id}")
    void delDrug(@Param("id") int id);

    @Update("update department set DrugsCode = #{code}, DrugsName = #{name}, DrugsFormat = #{format}, DrugsUnit = #{unit}, " +
            "Manufacturer = #{manufacturer}, DrugsDosageID = #{dosage}, DrugsTypeID = #{type}, DrugsPrice = #{price}, MnemonicCode = #{mnemonicCode} where id=#{id}")
    int updateDrug(Drug drug);

}
