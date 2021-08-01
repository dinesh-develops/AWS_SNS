package com.friendship.sns.AWS_SNS.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @JsonProperty("subject")
    @NonNull
    private String subject;
    @JsonProperty("message")
    private String message;
}
