package com.xworkz.dairy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@ToString
public class AgentDTO {
    private Integer agentId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String typesOfMilk;
}
