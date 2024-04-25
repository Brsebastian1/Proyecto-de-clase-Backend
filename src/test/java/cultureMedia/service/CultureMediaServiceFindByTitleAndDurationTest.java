package cultureMedia.service;

import cultureMedia.exception.CultureMediaException;
import cultureMedia.exception.VideoNotFoundException;
import cultureMedia.model.Video;
import cultureMedia.repository.Impl.VideoRepositoryImpl;
import cultureMedia.repository.Impl.ViewsRepositoryImpl;
import cultureMedia.repository.VideoRepository;
import cultureMedia.repository.ViewsRepository;
import cultureMedia.service.Impl.CultureMediaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CultureMediaServiceFindByTitleAndDurationTest {
    private CultureMediaService cultureMediaService;
    @BeforeEach
    void unit(){
        VideoRepository videoRepository = new VideoRepositoryImpl();
        ViewsRepository viewsRepository = new ViewsRepositoryImpl();
        cultureMediaService = new CultureMediaServiceImpl(videoRepository, viewsRepository);

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
    void when_FindByTitle_only_videos_which_contains_the_word_in_the_title_should_be_returned_successfully() throws CultureMediaException {
        List<Video> videos;
        videos = cultureMediaService.find("Clic");
        assertEquals(2, videos.size());
    }

    @Test
    void when_FindByTitle_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        VideoNotFoundException videoNotFoundException = assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.find("video");
        });
    }

    @Test
    void when_FindByDuration_only_videos_between_the_range_should_be_returned_successfully() throws CultureMediaException {
        List<Video> videos = cultureMediaService.find(4.5,5.5);
        assertEquals(3, videos.size());
    }

    @Test
    void when_FindByDuration_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully(){
        VideoNotFoundException videoNotFoundException = assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.find(9.5,10.5);
        });
    }
}
