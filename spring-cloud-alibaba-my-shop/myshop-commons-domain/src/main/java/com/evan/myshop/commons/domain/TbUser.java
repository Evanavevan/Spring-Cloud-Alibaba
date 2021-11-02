package com.evan.myshop.commons.domain;

import lombok.Data;

@Data
public class TbUser {
    private String username;

    private String password;

    private String phone;

    private String email;
}
