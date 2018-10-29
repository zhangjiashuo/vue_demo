package cn.itcast.dao;

import cn.itcast.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from user")
    List<User> findAll();
    @Select("select * from user where id=#{id}")
    User findById(Integer id);
    @Update("update user set username=#{username},password=#{password},email=#{email},age=#{age},sex=#{sex} where id=#{id}")
    void update(User user);
}
