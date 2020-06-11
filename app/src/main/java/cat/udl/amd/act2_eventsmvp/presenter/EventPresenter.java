package cat.udl.amd.act2_eventsmvp.presenter;

import cat.udl.amd.act2_eventsmvp.EventViewActions;
import cat.udl.amd.act2_eventsmvp.model.Event;

public class EventPresenter {
    private Event event;

    private EventViewActions view;

    public EventPresenter(EventViewActions view){
        this.view = view;
    }

    public void setEvent(String nom, String desc, String date, String type) {
        this.event = new Event(nom,desc,date,type);
    }

    public void getEvent(){
        view.updateUI(this.event.toString());
    }
}
