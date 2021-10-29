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
public class Board {
    private Integer id;
    private String name;

    @JsonIgnore
    private Date createdTime;

    @JsonIgnore
    private List<Post> postList;
}
