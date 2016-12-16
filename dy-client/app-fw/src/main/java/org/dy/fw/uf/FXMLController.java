/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dy.fw.uf;

import javafx.fxml.Initializable;
import org.dy.fw.AbstractApplication;
import org.dy.fw.LogFacade;
import org.dy.fw.cf.Command;
import org.dy.fw.cf.EventCommand;

/**
 *
 * @author duyi
 * @param <T>
 */
public abstract class FXMLController<T extends FXMLModel> extends LogFacade implements Initializable {

    private T model;

    public FXMLController() {
    }

    public void setModel(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public FXMLModel getModel(String key) {
        return (FXMLModel) AbstractApplication.getContext().getBean(key);
    }

    public Command getCommand(String key) {
        return (Command) AbstractApplication.getContext().getBean(key);
    }
}
