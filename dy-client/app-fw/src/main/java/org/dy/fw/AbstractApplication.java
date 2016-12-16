/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dy.fw;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.dy.fw.cf.EventCommand;
import org.dy.fw.config.AppConfig;
import org.dy.fw.uf.FXMLModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author duyi
 */
public abstract class AbstractApplication extends Application {

    private static FXMLModel rootModel;

    private static ApplicationContext context;

    private static AppConfig appConfig;

    public static FXMLModel initRootModel() {
        if (rootModel == null) {
            rootModel = (FXMLModel) context.getBean("ROOT_MODEL");
        }
        return rootModel;
    }

    public static FXMLModel getRootModel() {
        return rootModel;
    }

    public static void setRootModel(FXMLModel rootModel) {
        AbstractApplication.rootModel = rootModel;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static AppConfig getAppConfig() {
        return appConfig;
    }

    @Override
    public final void init() throws Exception {
        ApplicationContext configContext = new ClassPathXmlApplicationContext("/config/config.xml");
        appConfig = (AppConfig) configContext.getBean("FWConfig");
        context = new ClassPathXmlApplicationContext("/config/beans.xml");
        rootModel = initRootModel();
        initApp();
    }

    @Override
    public final void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene((Parent) getRootModel().getRoot(), 500D, 500D);
        configScene(scene);
        primaryStage.setScene(scene);
        configStage(primaryStage);
        primaryStage.setOnHidden((WindowEvent event) -> {
            close();
        });
        primaryStage.show();
    }

    protected abstract void configScene(Scene scene);

    protected abstract void configStage(Stage stage);

    protected abstract void initApp();

    private void close() {
        EventCommand.getThreadPool().shutdown();
    }

}
