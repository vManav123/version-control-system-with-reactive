package com.vmanav123.service.command.api;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserCreatedCommand {

    @TargetAggregateIdentifier
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
