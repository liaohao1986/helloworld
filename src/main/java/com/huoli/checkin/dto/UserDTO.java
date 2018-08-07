/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.huoli.checkin.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.BeanUtils;

import com.huoli.checkin.convert.Converter;
import com.huoli.checkin.entity.User;

/**
 *
 * @author Administrator
 * @version $Id: UserDTO.java, v 0.1 2017年3月10日 上午10:22:52 Administrator Exp $
 */
public class UserDTO {

    /** 用户名 */
    private String username;
    /** 年龄 */
    private int    age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User convertToUser() {
        UserDTOConvert userDTOConvert = new UserDTOConvert();
        User convert = userDTOConvert.doForward(this);
        return convert;
    }
    
    private static class UserDTOConvert extends Converter<UserDTO, User> {

        @Override
        protected User doForward(UserDTO userDTO) {
            User user = new User();
            BeanUtils.copyProperties(userDTO, user);
            return user;
        }

        @Override
        protected UserDTO doBackward(User user) {
            throw new AssertionError("不支持逆向转化方法!");
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
