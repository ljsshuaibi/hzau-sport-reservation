package org.example.last.java.service.impl;

import org.example.last.java.entity.Message;
import org.example.last.java.entity.MessageDto;
import org.example.last.java.entity.UserMessageId;
import org.example.last.java.mapper.UserBookMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserBookMessageimpl implements org.example.last.java.service.UserBookMessage {
    @Autowired
    UserBookMessageMapper userBookMessageMapper;
    @Override
    public void UpdateMessage(Message message) {
        userBookMessageMapper.UpdateMessage(message);
    }
    @Override
    public void CancleUpdateMessage(Message message){
        userBookMessageMapper.CancleUpadateMessage(message);
    }
    @Override
    /*管理员根据名字查询相关预约*/
    public List<MessageDto> AdminSelectUser(UserMessageId userMessageId){
        String UserId=userMessageId.getUserId();
        System.out.println(UserId);
        List<MessageDto> ljs=new ArrayList<>();
        ljs=userBookMessageMapper.AdminSelect(UserId);
        return ljs;
    }
    @Override
    public void deleteDataMessage(){
        userBookMessageMapper.delete();
    }
}
