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

    @Insert("insert into department values (0, #{name}, #{code}, #{category}, #{type})")
    int addDepartment(Department department);

    @Delete("delete from department where id=#{id}")
    void delDepartment(@Param("id") int id);

    @Update("update department set id=#{id}, name=#{name}, code=#{code}, category=#{category}, type=#{type} where id=#{id}")
    void updateDepartment(Department department);

    @Select("select * from department where id=#{key} or name=#{key} or category = #{key} or type = #{key} or code=#{key}")
    List<Department> searchDepartment(@Param("key") String key);
}
