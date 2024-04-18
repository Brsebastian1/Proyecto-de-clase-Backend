package cultureMedia.service;

import cultureMedia.model.Video;
import cultureMedia.model.VideoViews;

import java.util.List;

public interface CultureMediaService {
    List<Video> findAll();
    Video add(Video video);
    VideoViews add(VideoViews videoViews);
}
