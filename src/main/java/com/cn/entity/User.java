package com.cn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author chenyun
 * @projectName springboot
 * @description: TODO
 * @date 2019/8/30 14:54
 */
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;

    /** 昵称 */
    private String nickname;

    /** 手机号 */
    private String phone;

    /** 邮箱 */
    private String email;

    /** 密码 */
    private String password;

    /** 头像 */
    private String avatar;

    /** 账户余额 */
    private Double money;

    /** 注册时间 */
    private Date createTime;

    /** 最近登陆时间 */
    private Date lastLoginTime;

    /** 真实姓名 */
    private String realname;

    /** 身份证号码 */
    private String idcard;

    /** 性别 1-男 0-女 */
    private String gender;

    /** 住址编码 */
    private String addressCode;

    /** 住址名称 --city-picker 对应的编码在js中，存储名字方面地址在前台显示（列表或导出等）*/
    private String addressName;

    /** 出生日期 */
    private String birthday;

    /** 是否删除 1-是 0-否(默认) */
    private String deleted;

    /** 是否锁定登陆 1-是 0-否(默认) */
    private String locked;

    /** 密码错误次数 */
    private Integer wrongPwd;

    /** APP登陆token */
    private String token;

    /** 是否禁用 1-是 0-否(默认) */
    private String forbided;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public Integer getWrongPwd() {
        return wrongPwd;
    }

    public void setWrongPwd(Integer wrongPwd) {
        this.wrongPwd = wrongPwd;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getForbided() {
        return forbided;
    }

    public void setForbided(String forbided) {
        this.forbided = forbided;
    }
}