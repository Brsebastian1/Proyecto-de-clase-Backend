package cultureMedia.service.Impl;

import cultureMedia.model.Video;
import cultureMedia.model.VideoViews;
import cultureMedia.repository.VideoRepository;
import cultureMedia.repository.ViewsRepository;
import cultureMedia.service.CultureMediaService;

import java.util.List;

public class CultureMediaServiceImpl implements CultureMediaService {
    VideoRepository videoRepository;
    ViewsRepository viewsRepository;

    @Override
    public List<Video> findAll() {
        return null;
    }

    @Override
    public Video add(Video video) {
        return null;
    }

    @Override
    public VideoViews add(VideoViews videoViews) {
        return null;
    }
}
