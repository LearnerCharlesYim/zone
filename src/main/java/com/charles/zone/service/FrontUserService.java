package com.charles.zone.service;

import com.charles.zone.domain.FrontUser;

import javax.servlet.http.HttpSession;

public interface FrontUserService {
    Boolean isUsernameDuplicated(String username);

    void register(FrontUser frontUser);

    FrontUser login(FrontUser frontUser);

    void logout(HttpSession session);
}
