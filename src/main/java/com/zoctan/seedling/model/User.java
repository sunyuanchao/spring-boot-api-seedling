package com.zoctan.seedling.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Zoctan
 * @date 2018/5/27
 */
@Table(name = "user")
public class User {
    /**
     * 用户Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 邮箱
     */
    @Email
    @Column(name = "email")
    private String email;

    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空")
    @Size(min = 3, message = "用户名长度不能小于3")
    @Column(name = "username")
    private String username;

    /**
     * 密码
     */
    @JSONField(serialize = false)
    @NotEmpty(message = "密码不能为空")
    @Size(min = 6, message = "密码长度不能小于6")
    @Column(name = "password")
    private String password;

    /**
     * 注册时间
     */
    @Column(name = "register_time")
    private Timestamp registerTime;

    /**
     * 上一次登录时间
     */
    @Column(name = "last_login_time")
    private Timestamp lastLoginTime;

    /**
     * 用户的角色
     */
    @Transient
    private List<Role> roleList;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Timestamp getRegisterTime() {
        return this.registerTime;
    }

    public void setRegisterTime(final Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    public Timestamp getLastLoginTime() {
        return this.lastLoginTime;
    }

    public void setLastLoginTime(final Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public List<Role> getRoleList() {
        return this.roleList;
    }

    public void setRoleList(final List<Role> roleList) {
        this.roleList = roleList;
    }
}