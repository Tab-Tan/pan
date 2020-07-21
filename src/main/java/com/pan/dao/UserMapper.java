package com.pan.dao;

import com.pan.poji.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    /*
     * 增加用户
     */
    int addUser(User user);

    /*
     * 删除用户
     */
    int delUserByUsername(@Param("username") String username);

    int delUserById(@Param("id") int id);

    /*
     *修改用户
     */
    int updateUserByUsername(Map map);

    /*
     *查找用户
     */
    List<User> queryAllUser();

    List<User> queryByNikename();

    User queryByUsernameAndPassword(Map map);

    User queryByUsername(@Param("username") String username);

}
