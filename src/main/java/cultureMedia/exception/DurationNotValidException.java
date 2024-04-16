package cultureMedia.exception;

import java.text.MessageFormat;

public class DurationNotValidException extends CultureMediaException{

    public DurationNotValidException(String title, double duration) {
        super(MessageFormat.format("Video {0} with duration {1} have a invalid duration",title,duration));
    }
}
