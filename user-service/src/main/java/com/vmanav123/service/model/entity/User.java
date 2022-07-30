package com.vmanav123.service.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.*;
import java.util.Date;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table("USER")
public class User {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Serial
    @Column("user_id")
    private Long userId;
    @Column("first_name")
    private String firstName;
    @Column("last_name")
    private String lastName;
    @Column("user_name")
    private String username;
    @Column("email_address")
    private String emailAddress;
    @Column("contact_number")
    private String contactNumber;
    @Column("location")
    private String location;
    @Column("profile_url")
    private String profileUrl;
    @Column("created_date")
    private Date createdDate;
}
