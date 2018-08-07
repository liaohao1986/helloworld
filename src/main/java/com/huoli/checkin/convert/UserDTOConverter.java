/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.huoli.checkin.convert;

import org.springframework.beans.BeanUtils;

import com.huoli.checkin.dto.UserDTO;
import com.huoli.checkin.entity.User;

/**
 *
 * @author Administrator
 * @version $Id: UserDTOConverter.java, v 0.1 2017年3月10日 上午10:24:20 Administrator Exp $
 */
public class UserDTOConverter extends Converter<UserDTO, User> {

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
