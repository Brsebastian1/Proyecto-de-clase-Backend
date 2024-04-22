package cultureMedia.service;

import cultureMedia.exception.CultureMediaException;
import cultureMedia.model.Video;
import cultureMedia.model.VideoViews;

import java.util.List;

public interface CultureMediaService {
    List<Video> findAll() throws CultureMediaException;
    Video add(Video video);
    VideoViews add(VideoViews videoViews);
}
