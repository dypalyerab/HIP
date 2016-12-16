/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dy.fw.root.uf;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.dy.fw.uf.FXMLModel;

/**
 *
 * @author duyi
 */
public class RootModel extends FXMLModel {

    private final StringProperty result = new SimpleStringProperty();

    public StringProperty resultProperty() {
        return result;
    }

    public void setResult(String result) {
        this.result.setValue(result);
    }

    public String getResult() {
        return this.result.getValue();
    }

}
