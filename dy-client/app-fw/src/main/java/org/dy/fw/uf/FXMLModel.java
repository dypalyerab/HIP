/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dy.fw.uf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import org.dy.fw.AbstractApplication;
import org.dy.fw.LogFacade;
import org.dy.fw.cf.EventCommand;
import org.dy.fw.util.ReflectUtil;
import org.springframework.ui.Model;

/**
 *
 * @author duyi
 */
public abstract class FXMLModel extends LogFacade {
    
    private Node root;
    
    private String fxmlPath;
    
    private FXMLController fxmlController;
    
    public FXMLModel() {
        super();
    }
    
    public String getFxmlPath() {
        return fxmlPath;
    }
    
    public void setFxmlPath(String fxmlPath) {
        this.fxmlPath = fxmlPath;
    }
    
    public FXMLController getFxmlController() {
        return fxmlController;
    }
    
    public void setFxmlController(FXMLController fxmlController) {
        this.fxmlController = fxmlController;
    }
    
    public Model getModel(String key) {
        return (Model) AbstractApplication.getContext().getBean(key);
    }
    
    public EventCommand getCommand(String key) {
        return (EventCommand) AbstractApplication.getContext().getBean(key);
    }
    
    public Node getRoot() throws Exception {
        if (root == null) {
            root = initRoot();
        }
        return root;
    }
    
    protected final Node initRoot() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(getFxmlPath()));
        getFxmlController().setModel(this);
        getFxmlController().setBeanId(getBeanId());
        fxmlLoader.setController(getFxmlController());
        fxmlLoader.load();
        Node node = fxmlLoader.getRoot();
        return node;
    }
    
    public void setProperty(String fieldname, Object value) {
        try {
            String setMethodName = ReflectUtil.getSetMethod(fieldname);
            Method method = this.getClass().getDeclaredMethod(setMethodName, value.getClass());
            method.setAccessible(true);
            method.invoke(this, value);
        } catch (Exception ex) {
            getLogger().error(this.getBeanId() + "为属性" + fieldname + "赋值" + value + "失败！！！", ex);
        }
    }
}
