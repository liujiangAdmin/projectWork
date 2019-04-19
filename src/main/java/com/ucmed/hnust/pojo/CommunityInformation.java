package com.ucmed.hnust.pojo;

/**
 * Created by ZY-LJ-1446 on 2018/1/23.
 */
public class CommunityInformation {
    public Integer getId() {
        return id;
    }

    public String getCommunityName() {
        return communityName;
    }

    public String getCommunityHttp() {
        return communityHttp;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public void setCommunityHttp(String communityHttp) {
        this.communityHttp = communityHttp;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public CommunityInformation() {
    }

    public CommunityInformation(Integer id, String communityName, String communityHttp, String loginName, String loginPassword, String remarks) {
        this.id = id;
        this.communityName = communityName;
        this.communityHttp = communityHttp;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
        this.remarks = remarks;
    }

    private Integer id;
    private String communityName;
    private String communityHttp;
    private String loginName;
    private String loginPassword;
    private String remarks;
}
