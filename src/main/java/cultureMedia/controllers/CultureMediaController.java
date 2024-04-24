package cultureMedia.controllers;

import cultureMedia.exception.VideoNotFoundException;
import cultureMedia.model.Video;
import cultureMedia.service.Impl.CultureMediaServiceImpl;

import java.util.List;

public class CultureMediaController {
    private final CultureMediaServiceImpl cultureMediaService;


    public CultureMediaController(CultureMediaServiceImpl cultureMediaService) {
        this.cultureMediaService = cultureMediaService;
    }


    public List<Video> find_allVideos() throws VideoNotFoundException {
        List<Video> videos = null;
        videos = cultureMediaService.findAll();
        return videos;
    }
}
