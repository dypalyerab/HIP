/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dy.fw.root.cf;

import org.dy.fw.cf.EventCommand;

/**
 *
 * @author duyi
 */
public class RootCommand extends EventCommand {

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public void getAppData() {
    }

    @Override
    public void getServiceData() {
    }

    @Override
    public void doView() {
        getModel("ROOT_MODEL").setProperty("result", getKey());
    }

}
