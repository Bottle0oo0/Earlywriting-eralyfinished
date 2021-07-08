package com.neu.his.mapper;

import com.neu.his.entity.Patient;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientMapper {
    @Select("select * from patient where id=#{id}")
    Patient getPatient(@Param("id") int id);

    @Select("select * from patient where idNumber=#{idNumber}")
    Patient searchPatient(@Param("idNumber") String idNumber);

    @Insert("insert into patient values (null, #{idNumber}, #{name}, #{gender}, #{birth}, #{age}, #{addr}, #{tel}, #{recordId})")
    void addPatient(Patient patient);

    @Update("update patient set name=#{name}, idNumber = {idNumber},age=#{age}, addr=#{addr}, tel=#{tel} where id=#{id}")
    void updatePatient(Patient patient);

    @Select("select max(record_id)+1 from patient")
    Integer newRecordId();

    @Select("select max(id)+1 from patient")
    Integer newPatientId();
}
