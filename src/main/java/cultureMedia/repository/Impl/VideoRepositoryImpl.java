package cultureMedia.repository.Impl;

import cultureMedia.model.Video;
import cultureMedia.repository.VideoRepository;
import java.util.ArrayList;
import java.util.List;

public class VideoRepositoryImpl implements VideoRepository {

    private final List<Video> videos;

    public VideoRepositoryImpl() {
        videos = new ArrayList<>();
    }

    @Override
    public List<Video> findAll() {
        return videos;
    }

    @Override
    public Video save(Video video) {
        this.videos.add( video );
        return video;
    }

    @Override
    public List<Video> find(String title) {
        List<Video> filteredVideos = new ArrayList<Video>();
        for ( Video video : videos ) {
            if( video.getTitle().contains(title) ){
                filteredVideos.add(video);
            }
        }
        return filteredVideos;
    }

    @Override
    public List<Video> find(Double fromDuration, Double toDuration) {
        List<Video> filteredVideos = new ArrayList<Video>();
        for ( Video video : videos ) {
            if(video.getDuration()>= fromDuration && video.getDuration()<= toDuration){
                filteredVideos.add(video);
            }
        }
        return filteredVideos;
    }
}
