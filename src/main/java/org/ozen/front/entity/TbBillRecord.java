package org.ozen.front.entity;

import java.io.Serializable;
import java.util.Date;

public class TbBillRecord implements Serializable{
    private Long id;

    private String content;

    private Integer money;

    private Boolean cateId;

    private Boolean status;

    private Date time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Boolean getCateId() {
        return cateId;
    }

    public void setCateId(Boolean cateId) {
        this.cateId = cateId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}