package org.example.last.java.entity;

import lombok.Data;

import java.security.PublicKey;

@Data
public class Message {
    public String UserId;
    public int time;
    public String status;
    public int id;
    public String type;
    public Message(UpdateMessage updateMessage){
        this.UserId=updateMessage.getUserName();
        this.id=updateMessage.getId();
        this.time=updateMessage.getTime()+7;
        this.type=updateMessage.getType();
        if(updateMessage.getIsBook()){
            this.status="预约";
        }else{
            this.status="取消预约";
        }
    }
}
