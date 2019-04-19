package com.ucmed.hnust.service;

import javax.jws.WebService;

/**
 * Created by Administrator on 2019/4/18 0018.
 */

@WebService
public interface CxfDemo1Service {

    public String getUserById(String name);

    public String getAllUsers();

}
