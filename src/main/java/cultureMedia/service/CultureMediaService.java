package cultureMedia.service;

import cultureMedia.exception.CultureMediaException;
import cultureMedia.exception.VideoNotFoundException;
import cultureMedia.model.Video;
import cultureMedia.model.VideoViews;

import java.util.List;

public interface CultureMediaService {
    List<Video> findAll() throws CultureMediaException;
    Video add(Video video);
    VideoViews add(VideoViews videoViews);
    List<Video> find(String title) throws CultureMediaException;
    List<Video> find(Double fromDuration, Double toDuration) throws CultureMediaException;
}
