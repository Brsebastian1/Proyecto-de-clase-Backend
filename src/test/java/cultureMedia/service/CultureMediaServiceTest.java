package cultureMedia.service;


import cultureMedia.exception.CultureMediaException;
import cultureMedia.exception.VideoNotFoundException;
import cultureMedia.model.Video;
import cultureMedia.service.Impl.CultureMediaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CultureMediaServiceTest {
    private CultureMediaService cultureMediaService;

    @BeforeEach
    void unit(){
        cultureMediaService = new CultureMediaServiceImpl();
    }

    private void listVideos(){
        List<Video> videos = List.of(
                new Video("01", "Título 1", "----", 4.5),
                new Video("02", "Título 2", "----", 5.5),
                new Video("03", "Título 3", "----", 4.4),
                new Video("04", "Título 4", "----", 3.5),
                new Video("05", "Clic 5", "----", 5.7),
                new Video("06", "Clic 6", "----", 5.1));

        for(Video video : videos){
            cultureMediaService.add(video);
        }
    }
    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws CultureMediaException {
        listVideos();
        List<Video> videos = cultureMediaService.findAll();
        assertEquals(6, videos.size());
    }
    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() throws CultureMediaException {
         VideoNotFoundException videoNotFoundException = assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.findAll();
        });
    }
}
