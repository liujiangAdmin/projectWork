package com.ucmed.hnust.pojo;

/**
 * Created by ZY-LJ-1446 on 2018/1/22.
 */
public class Admin {


    public Integer getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }



    public void setId(Integer id) {
        this.id = id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getUseNumber() {
        return useNumber;
    }

    public void setUseNumber(String useNumber) {
        this.useNumber = useNumber;
    }


    private Integer id;
    private String account;
    private String password;
    private String useNumber;
}
