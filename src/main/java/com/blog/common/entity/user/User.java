package com.blog.common.entity.user;

/**
 * user: lishicao
 * date 15/9/28
 * time 上午10:45
 */
public class User {
    private Integer id ;
    private String username;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
