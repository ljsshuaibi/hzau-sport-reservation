package org.example.last.java.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.last.java.entity.Message;
import org.example.last.java.entity.MessageDto;
import org.example.last.java.entity.UserMessageId;

import java.util.List;

@Mapper
public interface UserBookMessageMapper {
    @Insert("INSERT INTO userbookmessage (USerid,time,Status,SportId,type)"+
            "values"+
            "(#{UserId},#{time},#{status},#{id},#{type})")
    void UpdateMessage(Message message);

    @Delete("delete from userbookmessage where Userid=#{UserId} and SportId=#{id} and type=#{type} and time=#{time}")
    void CancleUpadateMessage(Message message);
    /*管理员根据名字查询预约*/
    @Select("select * from userbookmessage where Userid=#{UserId}")
    List<MessageDto> AdminSelect(String UserId);
    @Delete("truncate table userbookmessage")
    void delete();
}
