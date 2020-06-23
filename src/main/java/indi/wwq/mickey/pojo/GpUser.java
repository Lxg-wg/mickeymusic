package indi.wwq.mickey.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gp_user")
public class GpUser implements Serializable {
    /**
     * 账号
     */
    @Id
    @Column(name = "user_Id")
    private String userId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 密码
     */
    private String password;

    /**
     * 注册的时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",locale = "zh",timezone="GMT+8")
    private Date regtime;

    /**
     * 上一次登录的时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",locale = "zh",timezone="GMT+8")
    private Date lastlogin;

    /**
     * 状态:0.在线,1.离线,-1.注销
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    /**
     * 获取账号
     *
     * @return user_Id - 账号
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置账号
     *
     * @param userId 账号
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取注册的时间
     *
     * @return regtime - 注册的时间
     */
    public Date getRegtime() {
        return regtime;
    }

    /**
     * 设置注册的时间
     *
     * @param regtime 注册的时间
     */
    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    /**
     * 获取上一次登录的时间
     *
     * @return lastlogin - 上一次登录的时间
     */
    public Date getLastlogin() {
        return lastlogin;
    }

    /**
     * 设置上一次登录的时间
     *
     * @param lastlogin 上一次登录的时间
     */
    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    /**
     * 获取状态:0.在线,1.离线,-1.注销
     *
     * @return status - 状态:0.在线,1.离线,-1.注销
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态:0.在线,1.离线,-1.注销
     *
     * @param status 状态:0.在线,1.离线,-1.注销
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}