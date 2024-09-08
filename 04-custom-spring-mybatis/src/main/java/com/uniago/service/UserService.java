package com.uniago.service;

import com.uniago.mapper.MemberMapper;
import com.uniago.mapper.OrderMapper;
import com.uniago.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private MemberMapper memberMapper;

    public void test() {
        System.out.println(memberMapper.getMemberName());
        System.out.println(orderMapper.getOrderName());
        System.out.println(userMapper.getUserName());
    }
}
