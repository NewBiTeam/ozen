package org.ozen.front.entity;

import java.io.Serializable;
import java.util.Date;

public class TbUserLike implements Serializable{
    private Integer id;

    private Long userId;

    private Integer userDynamicId;

    private Boolean status;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getUserDynamicId() {
        return userDynamicId;
    }

    public void setUserDynamicId(Integer userDynamicId) {
        this.userDynamicId = userDynamicId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}