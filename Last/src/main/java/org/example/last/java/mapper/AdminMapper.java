package org.example.last.java.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.last.java.entity.Admin;


@Mapper
public interface AdminMapper {
    @Select("select * from admin where adminName = #{adminName}")
    Admin getByAdminname(String adminName);
}
