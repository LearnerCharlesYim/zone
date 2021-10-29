package com.charles.zone.mapper;

import com.charles.zone.domain.FrontUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FrontUserMapper {
    FrontUser findByUsername(String username);

    Integer insert(FrontUser frontUser);

}
