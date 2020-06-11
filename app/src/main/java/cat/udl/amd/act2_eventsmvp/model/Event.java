package cat.udl.amd.act2_eventsmvp.model;

public class Event {

    private String title;
    private String desc;
    private String date;
    private String type;

    public Event(String title, String desc, String date, String type) {
        this.title = title;
        this.desc = desc;
        this.date = date;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Et convido a la meva festa " + title + " de " + type + " el dia " + date + ": " + desc;
    }
}
