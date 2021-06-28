package com.example.question_pool.dao;

import com.neu.his.entity.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}