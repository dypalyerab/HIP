/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dy.fw.cf;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import org.dy.fw.AbstractApplication;
import org.dy.fw.LogFacade;
import static org.dy.fw.cf.EventCommand.getThreadPool;
import org.dy.fw.uf.FXMLModel;

/**
 *
 * @author duyi
 */
public abstract class Command extends LogFacade {

    /**
     * Hip所使用的线程池
     */
    private static ExecutorService threadPool;

    protected abstract void getAppData();

    protected abstract void getServiceData();

    protected abstract void doView();

    public final void doCommand() {
        getLogger().debug(getBeanId() + ":getAppData:start");
        getAppData();
        getLogger().debug(getBeanId() + ":getAppData:end");
        Task<Object> task = new Task<Object>() {

            @Override
            protected Object call() throws Exception {
                getLogger().debug(getBeanId() + ":getServiceData:start");
                getServiceData();
                getLogger().debug(getBeanId() + ":getServiceData:end");
                return null;
            }
        };
        task.runningProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (oldValue && !newValue) {
                    getLogger().debug(getBeanId() + ":doView:start");
                    doView();
                    getLogger().debug(getBeanId() + ":doView:end");
                }
            }
        });
        getThreadPool().execute(task);
    }

    public static ExecutorService getThreadPool() {
        if (threadPool == null) {
            Integer cpuThread = AbstractApplication.getAppConfig().getCpuThread();
            System.err.println(cpuThread);
            threadPool = Executors.newFixedThreadPool(1 * cpuThread);
        }
        return threadPool;
    }

    public FXMLModel getModel(String key) {
        return (FXMLModel) AbstractApplication.getContext().getBean(key);
    }

    public Command getCommand(String key) {
        return (Command) AbstractApplication.getContext().getBean(key);
    }
}
