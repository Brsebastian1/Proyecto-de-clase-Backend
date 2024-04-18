package cultureMedia.repository.Impl;

import cultureMedia.model.VideoViews;
import cultureMedia.repository.ViewsRepository;

import java.util.ArrayList;
import java.util.List;

public class ViewsRepositoryImpl implements ViewsRepository {

    private final List<VideoViews> videoViews;

    public ViewsRepositoryImpl() {
        this.videoViews = new ArrayList<>();
    }

    @Override
    public VideoViews add(VideoViews videoViews) {
        this.videoViews.add( videoViews );
        return videoViews;
    }
}
