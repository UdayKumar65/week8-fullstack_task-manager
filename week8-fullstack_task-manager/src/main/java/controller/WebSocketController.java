package controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import model.entity.Task;

@Controller
public class WebSocketController<WebSocketService> {

    private final WebSocketService webSocketService;

    public WebSocketController(WebSocketService webSocketService){

        this.webSocketService = webSocketService;

    }

    @MessageMapping("/task-update")
    public void sendTaskUpdate(Task task){

        ((Object) webSocketService).sendTaskUpdate(task);

    }

}