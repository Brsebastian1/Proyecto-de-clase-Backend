package cultureMedia.controllers;

import cultureMedia.exception.CultureMediaException;
import cultureMedia.exception.VideoNotFoundException;
import cultureMedia.model.Video;
import cultureMedia.repository.Impl.VideoRepositoryImpl;
import cultureMedia.repository.Impl.ViewsRepositoryImpl;
import cultureMedia.service.CultureMediaService;
import cultureMedia.service.Impl.CultureMediaServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;


@RestController
public class CultureMediaController {
    private final CultureMediaService cultureMediaService;


    public CultureMediaController(CultureMediaService cultureMediaService) {
        this.cultureMediaService = cultureMediaService;
    }

    public CultureMediaController(){
        this.cultureMediaService = new CultureMediaServiceImpl(new VideoRepositoryImpl(), new ViewsRepositoryImpl());
    }

    @GetMapping
    public List<Video> findAllVideos() throws CultureMediaException {
        try {
            return cultureMediaService.findAll();
        }catch (VideoNotFoundException e){
            return Collections.emptyList();
        }
    }

    @PostMapping
    public Video addVideo(@RequestBody Video video){
        return cultureMediaService.add(video);
    }
}
