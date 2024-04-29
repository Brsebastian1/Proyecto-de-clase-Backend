package cultureMedia.controllers;

import cultureMedia.exception.CultureMediaException;
import cultureMedia.model.Video;
import cultureMedia.service.CultureMediaService;

import java.util.List;

public class CultureMediaController {
    private final CultureMediaService cultureMediaService;


    public CultureMediaController(CultureMediaService cultureMediaService) {
        this.cultureMediaService = cultureMediaService;
    }


    public List<Video> findAllVideos() throws CultureMediaException {
        return cultureMediaService.findAll();
    }
}
