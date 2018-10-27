package com.mapper;

import com.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Insert(value = "insert into user (username,password) values (#{username},#{password})")
    int add(@Param(value = "username") String username, @Param(value = "password") String password);

//    @Select(value = "select *from user where username=#{username}")
//    User select(@Param(value = "username") String username);

    @Select(value = "select * from user where username=#{username}")
    User select1(@Param(value = "username") String username);

}
