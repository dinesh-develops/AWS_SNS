package com.friendship.sns.AWS_SNS.Controller;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.friendship.sns.AWS_SNS.Model.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class messageController {
    @Value("${cloud.aws.arn}")
    private String TOPIC_ARN;
    @Autowired
    private AmazonSNSClient amazonSNSClient;

    @PostMapping(value = "/addSubscription/{email}")
    public ResponseEntity<String> addSubscription(@PathVariable final String email) {
        log.info("Adding new email subscription = {} to the topic.", email);
        final SubscribeRequest subscribeRequest = new SubscribeRequest(TOPIC_ARN, "email", email);
        amazonSNSClient.subscribe(subscribeRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping(value = "/sendNotification")
    public ResponseEntity<String> publishMessageToTopic(@RequestBody final Notification notification) {
        log.info("Publishing the notification = {} to the topic.", notification.toString());
        final PublishRequest publishRequest = new PublishRequest(TOPIC_ARN, notification.getMessage(), notification.getSubject());
        amazonSNSClient.publish(publishRequest);
        return new ResponseEntity<>("Notification sent successfully!!", HttpStatus.OK);
    }
}
