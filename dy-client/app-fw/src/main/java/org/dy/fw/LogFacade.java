/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dy.fw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author duyi
 */
public class LogFacade {

    private Logger logger;

    private String beanId;

    public LogFacade() {
    }

    public Logger getLogger() {
        if (logger == null) {
            logger = LoggerFactory.getLogger(getClass().getName() + "|" + getBeanId());
        }
        return logger;
    }

    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }

}
