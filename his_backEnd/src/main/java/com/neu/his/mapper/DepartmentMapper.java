package com.neu.his.mapper;

import com.neu.his.entity.Department;
import com.neu.his.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {
    @Select("select * from department")
    List<Department> getAll();

    @Select("select name from department where id=#{id}")
    String getNameOf(@Param("id") String id);

    @Insert("insert into department values (#{id}, #{name}, #{category}, #{type})")
    void addDepartment(Department department);

    @Delete("delete from department where id=#{id}")
    void delDepartment(@Param("id") String id);

    @Update("update department set id=#{id}, name=#{name}, category=#{category}, type=#{type} where id=#{id}")
    void updateDepartment(Department department);

    @Select("select * from department where id=#{key} or name=#{key} or category = #{key} or type = #{key}")
    List<Department> searchDepartment(@Param("key") String key);
}
