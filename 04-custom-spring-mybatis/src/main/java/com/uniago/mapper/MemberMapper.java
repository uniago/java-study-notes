package com.uniago.mapper;

import org.apache.ibatis.annotations.Select;

public interface MemberMapper {
    @Select("select 'member'")
    String getMemberName();
}
