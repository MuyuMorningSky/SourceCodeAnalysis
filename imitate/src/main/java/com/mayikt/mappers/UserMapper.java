package com.mayikt.mappers;

import com.mayikt.annotation.Select;
import com.mayikt.entity.UserEntity;

public interface UserMapper {

    @Select("SELECT * FROM `user` where id=?;")
    public UserEntity getUser(int id);

}
