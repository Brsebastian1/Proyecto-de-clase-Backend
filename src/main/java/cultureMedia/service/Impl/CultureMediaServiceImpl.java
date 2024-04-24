package cultureMedia.service.Impl;

import cultureMedia.exception.CultureMediaException;
import cultureMedia.exception.VideoNotFoundException;
import cultureMedia.model.Video;
import cultureMedia.model.VideoViews;
import cultureMedia.repository.VideoRepository;
import cultureMedia.repository.ViewsRepository;
import cultureMedia.service.CultureMediaService;

import java.util.ArrayList;
import java.util.List;


public class CultureMediaServiceImpl implements CultureMediaService {
    VideoRepository videoRepository;
    ViewsRepository viewsRepository;

    private final List<Video> videos;

    public CultureMediaServiceImpl() {
        videos = new ArrayList<>();
    }

    @Override
    public List<Video> findAll()throws CultureMediaException {
            if (!videos.isEmpty()) {
                return videos;
            } else {
                throw new VideoNotFoundException();
            }
    }

    @Override
    public Video add(Video video)  {
        this.videos.add(video);
        return video;
    }

    @Override
    public VideoViews add(VideoViews videoViews) {
        return null;
    }

    @Override
    public List<Video> find(String title) throws VideoNotFoundException {
        List<Video> filteredVideos = new ArrayList<Video>();
        if (!videos.isEmpty()){
            for ( Video video : videos ) {
                if( video.getTitle().contains(title) ){
                    filteredVideos.add(video);
                }
            }
        }
        if (filteredVideos.isEmpty()){
            throw new VideoNotFoundException(title);
        }else{
            return filteredVideos;
        }
    }

    @Override
    public List<Video> find(Double fromDuration, Double toDuration) throws VideoNotFoundException {
        List<Video> filteredVideos = new ArrayList<Video>();
        if (!videos.isEmpty()) {
            for (Video video : videos) {
                if (video.getDuration() >= fromDuration && video.getDuration() <= toDuration) {
                    filteredVideos.add(video);
                }
            }
        }
        if (filteredVideos.isEmpty()) {
            throw new VideoNotFoundException();
        } else {
            return filteredVideos;
        }
    }
}
