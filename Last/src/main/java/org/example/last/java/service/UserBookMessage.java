package org.example.last.java.service;

import org.example.last.java.entity.Message;
import org.example.last.java.entity.MessageDto;
import org.example.last.java.entity.UserMessageId;

import java.util.List;

public interface UserBookMessage {
    void UpdateMessage(Message message);
    void CancleUpdateMessage(Message message);
    List<MessageDto> AdminSelectUser(UserMessageId userMessageId);
    void deleteDataMessage();
}
