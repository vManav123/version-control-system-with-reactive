package com.vmanav123.service.aggregate;

import com.vmanav123.service.command.api.UserCreatedCommand;
import com.vmanav123.service.event.UserCreatedEvent;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
@Slf4j
@NoArgsConstructor
@ToString
public class UserAggregate {
    @AggregateIdentifier
    private Long userId;
    private String firstName;
    private String lastName;
    private String username;
    private String emailAddress;
    private String contactNumber;
    private String location;
    private String profileUrl;
    private Date createdDate;

    @CommandHandler
    public void aggregate(UserCreatedCommand productCreatedCommand) {
        //  You can perform validation here
        UserCreatedEvent userCreatedEvent = new UserCreatedEvent();
        BeanUtils.copyProperties(productCreatedCommand ,userCreatedEvent);

        // Publish the event
        AggregateLifecycle.apply(userCreatedEvent);
    }

    @EventSourcingHandler
    public void on(UserCreatedEvent event)
    {
        this.userId=event.getUserId();
        this.firstName=event.getFirstName();
        this.lastName=event.getLastName();
        this.username=event.getUsername();
        this.emailAddress= event.getEmailAddress();
        this.contactNumber=event.getContactNumber();
        this.location= event.getLocation();
        this.profileUrl=event.getProfileUrl();
        this.createdDate=event.getCreatedDate();
    }
    
}
