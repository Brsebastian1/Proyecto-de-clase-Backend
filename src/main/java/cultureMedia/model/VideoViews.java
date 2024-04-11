package cultureMedia.model;

import java.time.LocalDateTime;

public class VideoViews {
    private String userFullName;
    private LocalDateTime starPlayTime;
    private Integer age;
    private Video video;

    public String getUserFullName() {
        return userFullName;
    }

    public LocalDateTime getStarPlayTime() {
        return starPlayTime;
    }

    public Integer getAge() {
        return age;
    }

    public Video getVideo() {
        return video;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public void setStarPlayTime(LocalDateTime starPlayTime) {
        this.starPlayTime = starPlayTime;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}
