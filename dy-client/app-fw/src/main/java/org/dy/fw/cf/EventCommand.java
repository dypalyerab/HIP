package org.dy.fw.cf;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.Event;
import org.dy.fw.AbstractApplication;

/**
 *
 * @author duyi
 */
public abstract class EventCommand extends Command {

    /**
     * 当前事件的Event
     */
    private Event event;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

}
