package org.example.last.java.entity;

import lombok.Data;

@Data
public class UpdateMessage {
    public int id;
    public int time;
    public Boolean isBook;
    public String userName;
    public String type;
}
