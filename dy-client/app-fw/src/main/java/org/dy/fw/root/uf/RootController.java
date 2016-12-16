/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dy.fw.root.uf;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.dy.fw.cf.EventCommand;
import org.dy.fw.uf.FXMLController;

/**
 *
 * @author duyi
 */
public class RootController extends FXMLController<RootModel> {

    @FXML
    private Button button;
    @FXML
    private Label label;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EventCommand command = (EventCommand) getCommand("ROOT_HELLOWOLD_CF");
                command.setEvent(event);
                command.doCommand();
            }
        });
        label.textProperty().bind(getModel().resultProperty());
    }

}
