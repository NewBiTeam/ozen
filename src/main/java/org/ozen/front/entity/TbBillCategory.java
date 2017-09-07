package org.ozen.front.entity;

public class TbBillCategory {
    private Long cateId;

    private String cateName;

    private Boolean cateType;

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName == null ? null : cateName.trim();
    }

    public Boolean getCateType() {
        return cateType;
    }

    public void setCateType(Boolean cateType) {
        this.cateType = cateType;
    }
}