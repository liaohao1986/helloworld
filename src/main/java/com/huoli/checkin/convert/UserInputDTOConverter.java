/**
 * 
 */
package com.huoli.checkin.convert;

import org.springframework.beans.BeanUtils;

import com.huoli.checkin.dto.UserInputDTO;
import com.huoli.checkin.entity.User;

/**
 * @author Administrator
 *
 */
public class UserInputDTOConverter extends Converter<UserInputDTO, User> {

    @Override
    protected User doForward(UserInputDTO userInputDTO) {
        User user = new User();
        BeanUtils.copyProperties(userInputDTO, user);
        return user;
    }

    @Override
    protected UserInputDTO doBackward(User user) {
        UserInputDTO userInputDTO = new UserInputDTO();
        BeanUtils.copyProperties(user, userInputDTO);
        return userInputDTO;
    }

}
