package com.ucmed.hnust.service;

import org.apache.log4j.Logger;

/**
 * Created by ZY-LJ-1446 on 2018/6/7.
 */
public class GreetingImpl implements  Greeting{
    private Logger logger = Logger.getLogger(this.getClass());
    @Override
    public void sayHi(String param) {
        logger.info("sayHi");
    }
}
