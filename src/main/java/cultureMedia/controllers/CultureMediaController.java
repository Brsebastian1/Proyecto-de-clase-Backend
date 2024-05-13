package cultureMedia.controllers;

import cultureMedia.exception.CultureMediaException;
import cultureMedia.model.Video;
import cultureMedia.repository.Impl.VideoRepositoryImpl;
import cultureMedia.repository.Impl.ViewsRepositoryImpl;
import cultureMedia.service.CultureMediaService;
import cultureMedia.service.Impl.CultureMediaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public CultureMediaController() {
        this.cultureMediaService = new CultureMediaServiceImpl(new VideoRepositoryImpl(), new ViewsRepositoryImpl());
    }

    @GetMapping("/videos")
    public ResponseEntity<List<Video>> findAllVideos() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cultureMediaService.findAll());
        } catch (CultureMediaException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.emptyList());
        }
    }



    @PostMapping("/videos")
    public Video addVideo(@RequestBody Video video){
        return cultureMediaService.add(video);
    }
}
