package com.blog.service.login;

import com.blog.mappers.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.MessageDigest;


/**
 * user: lishicao
 * date 15/9/28
 * time 上午12:51
 */
@Service("loginService")
public class LoginService {
    @Autowired
    UserMapper userMapper ;

    /**
     * 将16位byte[] 转换为32位String
     * @param buffer
     * @return
     */
    private String toHex(byte[] buffer ){
        StringBuffer sb = new StringBuffer(buffer.length * 2);
        for (int i = 0; i < buffer.length; i++) {
            sb.append(Character.forDigit((buffer[i] & 240) >> 4, 16));
            sb.append(Character.forDigit(buffer[i] & 15, 16));
        }
        return sb.toString();
    }

    /**
     * 验证用户
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    public boolean varifyUser( String username , String password) throws Exception{
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        String pw = userMapper.getPassword(username);
        messageDigest.update(password.getBytes());
        String passwordMd5 = toHex( messageDigest.digest());
        if( passwordMd5.equals(pw) ) return true;
        else return false;
    }
}
