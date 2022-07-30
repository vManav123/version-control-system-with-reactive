package com.vmanav123.service.event;

import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserCreatedEvent {
    private Long userId;
    private String firstName;
    private String lastName;
    private String username;
    private String emailAddress;
    private String contactNumber;
    private String location;
    private String profileUrl;
    private Date createdDate;
    private String status;
}
