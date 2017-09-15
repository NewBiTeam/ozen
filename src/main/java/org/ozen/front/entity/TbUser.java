package org.ozen.front.entity;

import java.io.Serializable;
import java.util.Date;

public class TbUser implements Serializable{
	 private Long userId;

	    private String nickName;

	    private Boolean sex;

	    private String region;

	    private String avatar;

	    private String constellation;

	    private String usign;

	    private Integer integral;

	    private Integer surplusIntegral;

	    private String email;

	    private String telphone;

	    private Boolean privacy;

	    private Boolean status;

	    private Date createTime;

	    private Date loginTime;

	    private String username;
	    
	    private String password;
	    
	    public Long getUserId() {
	        return userId;
	    }

	    public void setUserId(Long userId) {
	        this.userId = userId;
	    }

	    public String getNickName() {
	        return nickName;
	    }

	    public void setNickName(String nickName) {
	        this.nickName = nickName == null ? null : nickName.trim();
	    }

	    public Boolean getSex() {
	        return sex;
	    }

	    public void setSex(Boolean sex) {
	        this.sex = sex;
	    }

	    public String getRegion() {
	        return region;
	    }

	    public void setRegion(String region) {
	        this.region = region == null ? null : region.trim();
	    }

	    public String getAvatar() {
	        return avatar;
	    }

	    public void setAvatar(String avatar) {
	        this.avatar = avatar == null ? null : avatar.trim();
	    }

	    public String getConstellation() {
	        return constellation;
	    }

	    public void setConstellation(String constellation) {
	        this.constellation = constellation == null ? null : constellation.trim();
	    }

	    public String getUsign() {
	        return usign;
	    }

	    public void setUsign(String usign) {
	        this.usign = usign == null ? null : usign.trim();
	    }

	    public Integer getIntegral() {
	        return integral;
	    }

	    public void setIntegral(Integer integral) {
	        this.integral = integral;
	    }

	    public Integer getSurplusIntegral() {
	        return surplusIntegral;
	    }

	    public void setSurplusIntegral(Integer surplusIntegral) {
	        this.surplusIntegral = surplusIntegral;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email == null ? null : email.trim();
	    }

	    public String getTelphone() {
	        return telphone;
	    }

	    public void setTelphone(String telphone) {
	        this.telphone = telphone == null ? null : telphone.trim();
	    }

	    public Boolean getPrivacy() {
	        return privacy;
	    }

	    public void setPrivacy(Boolean privacy) {
	        this.privacy = privacy;
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

	    public Date getLoginTime() {
	        return loginTime;
	    }

	    public void setLoginTime(Date loginTime) {
	        this.loginTime = loginTime;
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
