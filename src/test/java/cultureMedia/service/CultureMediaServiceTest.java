package cultureMedia.service;


import cultureMedia.exception.CultureMediaException;
import cultureMedia.exception.VideoNotFoundException;
import cultureMedia.model.Video;
import cultureMedia.repository.Impl.ViewsRepositoryImpl;
import cultureMedia.repository.VideoRepository;
import cultureMedia.repository.ViewsRepository;
import cultureMedia.service.Impl.CultureMediaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

public class CultureMediaServiceTest {
    private CultureMediaService cultureMediaService;
    private VideoRepository videoRepository = Mockito.mock();

    private Video video1 = new Video("01", "Título 1", "----", 4.5);
    private Video video2  = new Video("02", "Título 2", "----", 5.5);
    private Video video3  = new Video("03", "Título 3", "----", 4.4);
    private Video video4  = new Video("04", "Título 4", "----", 3.5);
    private Video video5  = new Video("05", "Clic 5", "----", 5.7);
    private Video video6  = new Video("06", "Clic 6", "----", 5.1);


    @BeforeEach
    void unit(){
        ViewsRepository viewsRepository = new ViewsRepositoryImpl();
        cultureMediaService = new CultureMediaServiceImpl( videoRepository, viewsRepository);
    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws CultureMediaException {
        doReturn(List.of(video1, video2, video3, video4, video5, video6))
                .when(videoRepository)
                .findAll();
    }
    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() throws CultureMediaException {
        VideoNotFoundException videoNotFoundException = assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.findAll();

        });
    }
}
