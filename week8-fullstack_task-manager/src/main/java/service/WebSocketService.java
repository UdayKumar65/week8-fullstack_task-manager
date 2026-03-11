package service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import model.entity.Task;

@Service
public class WebSocketService {

    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketService(SimpMessagingTemplate messagingTemplate){

        this.messagingTemplate = messagingTemplate;

    }

    public void sendTaskUpdate(Task task){

        messagingTemplate.convertAndSend(
                "/topic/tasks",
                task
        );

    }

}