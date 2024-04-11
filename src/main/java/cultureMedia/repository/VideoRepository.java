package cultureMedia.repository;

import cultureMedia.model.Video;

import java.util.List;

public interface VideoRepository {
    List<Video> findAll();
    Video save(Video save);
    List<Video> find(String title);
    List<Video> find(double fromDuration, double toDuration);
}
