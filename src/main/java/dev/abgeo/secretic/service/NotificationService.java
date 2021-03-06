package dev.abgeo.secretic.service;

import dev.abgeo.secretic.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public NotificationService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void notify(Notification notification) {
        messagingTemplate.convertAndSendToUser(
                notification.getUser().getUsername(),
                "/topic/notification",
                notification
        );
    }

}
