package cultureMedia.service.Impl;

import cultureMedia.exception.CultureMediaException;
import cultureMedia.exception.VideoNotFoundException;
import cultureMedia.model.Video;
import cultureMedia.model.VideoViews;
import cultureMedia.repository.VideoRepository;
import cultureMedia.repository.ViewsRepository;
import cultureMedia.service.CultureMediaService;

import java.util.List;


public class CultureMediaServiceImpl implements CultureMediaService {

    VideoRepository videoRepository;
    ViewsRepository viewsRepository;

    public CultureMediaServiceImpl(VideoRepository videoRepository, ViewsRepository viewsRepository) {
        this.videoRepository = videoRepository;
        this.viewsRepository = viewsRepository;
    }

    @Override
    public List<Video> findAll()throws CultureMediaException {
        List<Video> videoList = videoRepository.findAll();
        if (videoList.isEmpty()){
            throw new VideoNotFoundException();
        }else{
            return videoList;
        }

    }

    @Override
    public Video add(Video video){
        return videoRepository.save(video);
    }

    @Override
    public VideoViews add(VideoViews videoViews) {
        return null;
    }

    @Override
    public List<Video> find(String title) throws CultureMediaException {
        List<Video> filteredVideos = videoRepository.find(title);
        if (filteredVideos.isEmpty()){
            throw new VideoNotFoundException();
        }else{
            return filteredVideos;
        }

    }

    @Override
    public List<Video> find(Double fromDuration, Double toDuration) throws CultureMediaException {
        List<Video> filteredVideos = videoRepository.find(fromDuration, toDuration);
        if (filteredVideos.isEmpty()){
            throw new VideoNotFoundException();
        }else{
            return filteredVideos;
        }
    }
}
