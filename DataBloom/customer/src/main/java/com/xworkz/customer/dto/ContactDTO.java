package com.xworkz.customer.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@RequiredArgsConstructor
@ToString
public class ContactDTO {
    private String name;
    private String email;
    private String phoneNumber;
    private String comments;
}
