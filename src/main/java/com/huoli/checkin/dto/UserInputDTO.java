/**
 * 
 */
package com.huoli.checkin.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.BeanUtils;

import com.huoli.checkin.convert.DTOConvert;
import com.huoli.checkin.entity.User;

/**
 * @author Administrator
 *
 */
public class UserInputDTO {
   
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
        UserInputDTOConvert userInputDTOConvert = new UserInputDTOConvert();
        User convert = userInputDTOConvert.convert(this);
        return convert;
    }

    private static class UserInputDTOConvert implements DTOConvert<UserInputDTO, User> {
        @Override
        public User convert(UserInputDTO userInputDTO) {
            User user = new User();
            BeanUtils.copyProperties(userInputDTO, user);
            return user;
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
