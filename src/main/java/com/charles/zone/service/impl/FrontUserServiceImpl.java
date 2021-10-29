package com.charles.zone.service.impl;

import com.charles.zone.domain.FrontUser;
import com.charles.zone.mapper.FrontUserMapper;
import com.charles.zone.service.FrontUserService;
import com.charles.zone.service.ex.*;
import com.charles.zone.utils.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

@Service
public class FrontUserServiceImpl implements FrontUserService {
    @Autowired
    private FrontUserMapper frontUserMapper;

    @Override
    public Boolean isUsernameDuplicated(String username) {
        FrontUser result = frontUserMapper.findByUsername(username);
        if(result != null){
            throw new UsernameDuplicatedException("用户名已被占用");
        }
        return false;
    }

    @Override
    public void register(FrontUser frontUser) {
        isUsernameDuplicated(frontUser.getUsername());
        Date now = new Date();
        String salt = EncryptionUtils.getSalt();
        String md5Password = EncryptionUtils.getMD5Password(frontUser.getPassword(), salt);

        frontUser.setPassword(md5Password);
        frontUser.setSalt(salt);
        frontUser.setUuid(UUID.randomUUID().toString().toUpperCase());
        frontUser.setCreatedTime(now);
        frontUser.setIsActive(1);

        Integer rows = frontUserMapper.insert(frontUser);
        if (rows != 1) {
            throw new InsertException("添加用户数据出现未知错误，请联系系统管理员");
        }
    }

    @Override
    public FrontUser login(FrontUser frontUser) {
        FrontUser result = frontUserMapper.findByUsername(frontUser.getUsername());
        if(result == null){
            throw new UserNotFoundException("用户不存在错误");
        }
        if(result.getIsActive() == 0){
            throw new UserNotActiveException("用户被封禁错误");
        }
        String password = frontUser.getPassword();
        String salt = result.getSalt();
        if(!result.getPassword().equals(EncryptionUtils.getMD5Password(password,salt))){
            throw new PasswordNotMatchException("用户名或密码错误");
        }
       return result;
    }

    @Override
    public void logout(HttpSession session) {
        Object result = session.getAttribute("frontUser");
        if(result == null){
            throw new LogoutException("注销信息错误");
        }
        session.removeAttribute("frontUser");

    }

}
