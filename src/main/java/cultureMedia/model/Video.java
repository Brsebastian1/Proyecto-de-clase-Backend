package cultureMedia.model;

public class Video {
    private String code;
    private String title;
    private String description;
    private double duration;

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getDuration() {
        return duration;
    }

    public void setCode(String code) {this.code = code;}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
