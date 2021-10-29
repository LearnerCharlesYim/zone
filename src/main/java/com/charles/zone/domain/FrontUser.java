package com.charles.zone.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FrontUser {
    @JsonIgnore
    private Integer id;
    private String uuid;
    private String username;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String salt;
    private String phone;
    private String email;
    private Integer gender;
    private String avatar;
    private  Integer isActive;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;

    private List<Post> postList;

}
