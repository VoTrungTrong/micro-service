package com.example.accountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private Long id;

    private String name;

    private String username;

    private String password;

    private Set<String> roles;
}
